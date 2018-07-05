package com.lol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hero implements Movable {
    //constants for validation only
    private static final int MIN_GOLD = 0;
    private static final int MIN_ATTACK_DAMAGE = 0;
    private static final int MAX_ATTACK_DAMAGE = 1000;
    private static final int MIN_AP_DAMAGE = 0;
    private static final int MAX_AP_DAMAGE = 1000;
    private static final int MAX_HEALTH = 10000;
    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 4000;
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 1000;
    private static final int GOLD_ON_KILL = 300;
    private static final int BUFFED_SPEED = 12;

    private Consts constants = new Consts();

    public Hero() {
    }

    @Override
    public String toString() {
        return " name='" + name + '\'' +
                ", health=" + health +
                ", mana=" + mana +
                ", armor=" + armor +
                ", attackDamage=" + attackDamage +
                ", apDamage=" + apDamage +
                ", gold=" + gold +
                ", heroSpeed=" + heroSpeed +
                ", isDead=" + isDead +
                '}';
    }

    public Hero(String name) throws NoSuchFieldException,
            IllegalAccessException {
        setHeroStats(name.toUpperCase());
    }

    private String name;
    private int health;
    private int mana;
    private int armor;
    private int attackDamage;
    private int apDamage;
    private int gold;
    private int heroSpeed;
    private boolean isDead = false;
    private String heroType;
    private List<Items> listHeroItems = new ArrayList<>();
    private List<Items> equippedItems = new LinkedList<>();

    public List<Items> getListHeroItems() {
        return listHeroItems;
    }

    public void setListHeroItems(List<Items> listHeroItems) {
        this.listHeroItems = listHeroItems;
    }

    public List<Items> getEquippedItems() {
        return equippedItems;
    }

    public void setEquippedItems(List<Items> equippedItems) {
        this.equippedItems = equippedItems;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health > MAX_HEALTH) {
            throw new RuntimeException("Invalid health");
        }

        this.health = health;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < MIN_MANA || mana > MAX_MANA) {
            throw new RuntimeException("Invalid mana");
        }

        this.mana = mana;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = armor;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        if (attackDamage < MIN_ATTACK_DAMAGE || attackDamage > MAX_ATTACK_DAMAGE) {
            throw new RuntimeException("Invalid attackDamage");
        }

        this.attackDamage = attackDamage;
    }

    public int getApDamage() {
        return apDamage;
    }

    public void setApDamage(int apDamage) {
        if (apDamage < MIN_AP_DAMAGE || apDamage > MAX_AP_DAMAGE) {
            throw new RuntimeException("Invalid apDamage");
        }

        this.apDamage = apDamage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        if (gold < MIN_GOLD) {
            throw new RuntimeException("Invalid gold");
        }

        this.gold = gold;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean dead) {
        if (dead) {
            setHealth(0);
            setMana(0);
            setArmor(0);
            setGold(0);
            setHeroSpeed(0);
            setAttackDamage(0);
            setApDamage(0);
            setType("");
            listHeroItems.clear();
            equippedItems.clear();


        }
        isDead = dead;
    }

    public int getHeroSpeed() {
        return heroSpeed;
    }

    public void setHeroSpeed(int heroSpeed) {
        if (heroSpeed < MIN_SPEED || heroSpeed > MAX_SPEED) {
            throw new RuntimeException("Invalid speed");
        }

        this.heroSpeed = heroSpeed;
    }

    public String getType() {
        return heroType;
    }

    public void setType(String type) {
        this.heroType = type;
    }


    public void setHeroStats(String name) throws NoSuchFieldException,
            IllegalAccessException {
        setName(name.toUpperCase());
        setHealth(Consts.class.getDeclaredField(name + "_HEALTH").getInt(constants));
        setMana(Consts.class.getDeclaredField(name + "_MANA").getInt(constants));
        setArmor(Consts.class.getDeclaredField(name + "_ARMOR").getInt(constants));
        setGold(Consts.class.getDeclaredField(name + "_GOLD").getInt(constants));
        setHeroSpeed(Consts.class.getDeclaredField(name + "_HERO_SPEED").getInt(constants));
        setAttackDamage(Consts.class.getDeclaredField(name + "_ATTACK_DAMAGE").getInt(constants));
        setApDamage(Consts.class.getDeclaredField(name + "_ABILITY_POWER").getInt(constants));
        setIsDead(Consts.class.getDeclaredField(name + "_IS_DEAD").getBoolean(constants));
        setType((String) Consts.class.getDeclaredField(name + "_TYPE").get(constants));


    }

    public void normalAttack(Hero attacker, Hero defender) {
        int normalAttackDmg = attacker.getAttackDamage();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();

        if (defenderArmor >= normalAttackDmg) {
            defender.setArmor(defenderArmor - normalAttackDmg);
            return;
        }

        if (defenderHealth <= normalAttackDmg) {
            defender.setHealth(0);
            defender.setIsDead(true);
            attacker.setGold(attacker.getGold() + GOLD_ON_KILL);
            System.out.println(attacker.getName() + " receives " + GOLD_ON_KILL + " gold for killing " + defender.getName());
            return;
        }

        defender.setHealth((defenderHealth + defenderArmor) - normalAttackDmg);
        defender.setArmor(0);
    }

    public void magicAttack(Hero attacker, Hero defender) {
        int attackerAP = attacker.getApDamage();
        int attackerMana = attacker.getMana();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();
        int magicAttackManaCost = 75;

        if (attackerMana < magicAttackManaCost) {
            System.out.println("Not enough mana to cast " + attacker.getName() + "'s Magic Attack");

        } else {

            int magicAttackDmg = attackerAP + 45;
            if (defenderArmor >= magicAttackDmg) {
                defender.setArmor(defenderArmor - magicAttackDmg);
                attacker.setMana(attackerMana - magicAttackManaCost);
                return;
            }
            if (defenderHealth <= magicAttackDmg) {
                attacker.setMana(attackerMana - magicAttackManaCost);
                defender.setHealth(0);
                defender.setIsDead(true);
                attacker.setGold(attacker.getGold() + GOLD_ON_KILL);
                System.out.println(attacker.getName() + " receives " + GOLD_ON_KILL + " gold for killing " + defender.getName());
                return;
            }
            attacker.setMana(attackerMana - magicAttackManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - magicAttackDmg);
            defender.setArmor(0);

        }
    }

    public void ultimateAttack(Hero attacker, Hero defender) {
        int attackerAP = attacker.getApDamage();
        int attackerAD = attacker.getAttackDamage();
        int attackerMana = attacker.getMana();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();
        int ultimateManaCost = 120;


        if (attackerMana < ultimateManaCost) {
            System.out.println("Not enough mana to cast " + attacker.getName() + "'s Ultimate");

        } else {

            int ultimateDmg = attackerAP + attackerAD + 70;
            if (defenderArmor >= ultimateDmg) {
                defender.setArmor(defenderArmor - ultimateDmg);
                attacker.setMana(attackerMana - ultimateManaCost);
                return;
            }
            if (defenderHealth <= ultimateDmg) {
                attacker.setMana(attackerMana - ultimateManaCost);
                defender.setHealth(0);
                defender.setIsDead(true);
                attacker.setGold(attacker.getGold() + 300);
                System.out.println(attacker.getName() + " receives " + GOLD_ON_KILL + " gold for killing " + defender.getName());
                return;
            }

            attacker.setMana(attackerMana - ultimateManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - ultimateDmg);
            defender.setArmor(0);

        }

    }

    public void heroAttackDrake(Drake drake) {
        if (drake.getIsDead()) {
            System.out.println("Drake is already dead!");
            return;
        }

        int currentSpeedHero = move(drake.getSpeed());

        if (currentSpeedHero < drake.getSpeed()) {
            System.out.println("Drake is out of range");
            return;
        }

        int drakeHealth = drake.getHealth();
        int drakeArmor = drake.getArmor();
        int absorbDamage = drakeArmor / drake.getAbsorbDamage();
        drakeHealth -= getAttackDamage() - absorbDamage;

        if (drakeHealth <= 0) {
            drake.setHealth(0);
            setIsDead(true);
            System.out.println("Drake is dead!");
            switch (drake.getName()) {
                case "CLOUD":
                    setHeroSpeed(getHeroSpeed() + drake.getDrakeBuff());
                    break;
                case "INFERNAL":
                    setAttackDamage(getAttackDamage() + drake.getDrakeBuff());
                    break;
                case "MOUNTAIN":
                    setArmor(getArmor() + drake.getDrakeBuff());
                    break;
                case "OCEAN":
                    setHealth(getHealth() + drake.getDrakeBuff());
                    break;
                case "ELDER":
                    setHeroSpeed(getHeroSpeed() + drake.getDrakeBuff());
                    setAttackDamage(getAttackDamage() + drake.getDrakeBuff());
                    setArmor(getArmor() + drake.getDrakeBuff());
                    setHealth(getHealth() + drake.getDrakeBuff());
                    break;

            }

            return;
        }

        drake.setHealth(drakeHealth);
    }

    public void heroAttackNashor(Nashor nashor) {
        if (nashor.getIsDead()) {
            System.out.println("Nashor is already dead!");
            return;
        }

        int nashorHealth = nashor.getHealth();
        int nashorArmor = nashor.getArmor();
        int absorbDamage = nashorArmor / nashor.getAbsorbDamage();
        nashorHealth -= getAttackDamage() - absorbDamage;

        if (nashorHealth <= 0) {
            nashor.setHealth(0);
            setIsDead(true);
            System.out.println("Nashor is dead!");
            setGold(getGold() + nashor.getNashorBuff());
            return;
        }

        nashor.setHealth(nashorHealth);
    }

    public void heroAttackCreep(Creeps creep) {
        if (creep.getIsDead()) {
            System.out.println("Creep is already dead!");
            return;
        }

        int currentSpeedHero = move(creep.getSpeed());

        if (currentSpeedHero < creep.getSpeed()) {
            System.out.println("Creep is out of range");
            return;
        }

        int creepHealth = creep.getHealth();
        int creepArmor = creep.getArmor();
        int absorbDamage = creepArmor / creep.getAbsorbDamage();
        creepHealth -= getAttackDamage() - absorbDamage;

        if (creepHealth <= 0) {
            creep.setHealth(0);
            setIsDead(true);
            setGold(getGold() + creep.getCreepBuff());
            System.out.println("Creep is dead!");
            return;
        }

        creep.setHealth(creepHealth);
    }

    @Override
    public int move(int drakeSpeed) {
        int currentHeroSpeed = getHeroSpeed();

        if (currentHeroSpeed < drakeSpeed) {
            currentHeroSpeed += BUFFED_SPEED;
            setHeroSpeed(currentHeroSpeed);
        }


        return currentHeroSpeed;
    }


    public void heroRevive(Hero hero) throws NoSuchFieldException,
            IllegalAccessException {
        String heroName = hero.getName();
        if (hero.getIsDead()) {
            hero.setIsDead(false);
            hero.setHeroStats(heroName);


        } else {
            System.out.println("Hero is alive!");
        }
    }

}
