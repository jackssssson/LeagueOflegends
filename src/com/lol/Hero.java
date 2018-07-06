package com.lol;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Hero extends Unit implements Movable {
    //constants for validation only
    private static final int MIN_GOLD = 0;
    private static final int MIN_AP_DAMAGE = 0;
    private static final int MAX_AP_DAMAGE = 1000;
    private static final int MIN_MANA = 0;
    private static final int MAX_MANA = 4000;
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 1000;
    private static final int GOLD_ON_KILL = 300;
    private static final int BUFFED_SPEED = 12;
    private static final int STATS_DEAD = 0;
    private static final int MAGIC_ATTACK_MANA_COST = 75;
    private static final int ADDITION_AP_DAMAGE = 45;
    private static final int ULTIMATE_MANA_COST = 120;
    private static final int ADDITION_ULTIMATE_DAMAGE = 45;

    private Consts constants = new Consts();

    @Override
    public String toString() {
        return " name='" + getName() + '\'' +
                ", health=" + getHealth() +
                ", mana=" + mana +
                ", armor=" + getArmor() +
                ", attackDamage=" + getAttackDamage() +
                ", apDamage=" + apDamage +
                ", gold=" + gold +
                ", heroSpeed=" + heroSpeed +
                ", isDead=" + isDead +
                '}';
    }

    public Hero(String name) throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {
        setHeroStats(name.toUpperCase());
    }

    private int mana;
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

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) throws InvalidStatsException {
        if (mana < MIN_MANA || mana > MAX_MANA) {
            throw new InvalidStatsException("Invalid mana");
        }

        this.mana = mana;
    }

    public int getApDamage() {
        return apDamage;
    }

    public void setApDamage(int apDamage) throws InvalidStatsException {
        if (apDamage < MIN_AP_DAMAGE || apDamage > MAX_AP_DAMAGE) {
            throw new InvalidStatsException("Invalid apDamage");
        }

        this.apDamage = apDamage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) throws InvalidStatsException {
        if (gold < MIN_GOLD) {
            throw new InvalidStatsException("Invalid gold");
        }

        this.gold = gold;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean dead) throws InvalidStatsException {
        if (dead) {
            setHealth(STATS_DEAD);
            setMana(STATS_DEAD);
            setArmor(STATS_DEAD);
            setGold(STATS_DEAD);
            setHeroSpeed(STATS_DEAD);
            setAttackDamage(STATS_DEAD);
            setApDamage(STATS_DEAD);
            setType("");
            listHeroItems.clear();
            equippedItems.clear();
        }
        isDead = dead;
    }

    public int getHeroSpeed() {
        return heroSpeed;
    }

    public void setHeroSpeed(int heroSpeed) throws InvalidStatsException {
        if (heroSpeed < MIN_SPEED || heroSpeed > MAX_SPEED) {
            throw new InvalidStatsException("Invalid speed");
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
            IllegalAccessException, InvalidStatsException {
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

    public void normalAttack(Hero attacker, Hero defender) throws InvalidStatsException {
        int normalAttackDmg = attacker.getAttackDamage();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();

        if (defenderArmor >= normalAttackDmg) {
            defender.setArmor(defenderArmor - normalAttackDmg);
            return;
        }

        if (defenderHealth <= normalAttackDmg) {
            defender.setHealth(STATS_DEAD);
            defender.setIsDead(true);
            attacker.setGold(attacker.getGold() + GOLD_ON_KILL);
            System.out.println(attacker.getName() + " receives " + GOLD_ON_KILL + " gold for killing " + defender.getName());
            return;
        }

        defender.setHealth((defenderHealth + defenderArmor) - normalAttackDmg);
        defender.setArmor(STATS_DEAD);
    }

    public void magicAttack(Hero attacker, Hero defender) throws InvalidStatsException {
        int attackerAP = attacker.getApDamage();
        int attackerMana = attacker.getMana();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();
        int magicAttackManaCost = MAGIC_ATTACK_MANA_COST;

        if (attackerMana < magicAttackManaCost) {
            System.out.println("Not enough mana to cast " + attacker.getName() + "'s Magic Attack");

        } else {

            int magicAttackDmg = attackerAP + ADDITION_AP_DAMAGE;
            if (defenderArmor >= magicAttackDmg) {
                defender.setArmor(defenderArmor - magicAttackDmg);
                attacker.setMana(attackerMana - magicAttackManaCost);
                return;
            }
            if (defenderHealth <= magicAttackDmg) {
                attacker.setMana(attackerMana - magicAttackManaCost);
                defender.setHealth(STATS_DEAD);
                defender.setIsDead(true);
                attacker.setGold(attacker.getGold() + GOLD_ON_KILL);
                System.out.println(attacker.getName() + " receives " + GOLD_ON_KILL + " gold for killing " + defender.getName());
                return;
            }
            attacker.setMana(attackerMana - magicAttackManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - magicAttackDmg);
            defender.setArmor(STATS_DEAD);

        }
    }

    public void ultimateAttack(Hero attacker, Hero defender) throws InvalidStatsException {
        int attackerAP = attacker.getApDamage();
        int attackerAD = attacker.getAttackDamage();
        int attackerMana = attacker.getMana();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();
        int ultimateManaCost = ULTIMATE_MANA_COST;


        if (attackerMana < ultimateManaCost) {
            System.out.println("Not enough mana to cast " + attacker.getName() + "'s Ultimate");

        } else {

            int ultimateDmg = attackerAP + attackerAD + ADDITION_ULTIMATE_DAMAGE;
            if (defenderArmor >= ultimateDmg) {
                defender.setArmor(defenderArmor - ultimateDmg);
                attacker.setMana(attackerMana - ultimateManaCost);
                return;
            }
            if (defenderHealth <= ultimateDmg) {
                attacker.setMana(attackerMana - ultimateManaCost);
                defender.setHealth(STATS_DEAD);
                defender.setIsDead(true);
                attacker.setGold(attacker.getGold() + GOLD_ON_KILL);
                System.out.println(attacker.getName() + " receives " + GOLD_ON_KILL + " gold for killing " + defender.getName());
                return;
            }

            attacker.setMana(attackerMana - ultimateManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - ultimateDmg);
            defender.setArmor(STATS_DEAD);

        }

    }

    public void heroAttackDrake(Drake drake) throws InvalidStatsException {
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

        if (drakeHealth <= STATS_DEAD) {
            drake.setHealth(STATS_DEAD);
            drake.setIsDead(true);
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

    public void heroAttackNashor(Nashor nashor) throws InvalidStatsException {
        if (nashor.getIsDead()) {
            System.out.println("Nashor is already dead!");
            return;
        }

        int nashorHealth = nashor.getHealth();
        int nashorArmor = nashor.getArmor();
        int absorbDamage = nashorArmor / nashor.getAbsorbDamage();
        nashorHealth -= getAttackDamage() - absorbDamage;

        if (nashorHealth <= STATS_DEAD) {
            nashor.setHealth(STATS_DEAD);
            nashor.setIsDead(true);
            System.out.println("Nashor is dead!");
            setGold(getGold() + nashor.getNashorBuff());
            return;
        }

        nashor.setHealth(nashorHealth);
    }

    public void heroAttackCreep(Creeps creep) throws InvalidStatsException {
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

        if (creepHealth <= STATS_DEAD) {
            creep.setHealth(STATS_DEAD);
            creep.setIsDead(true);
            setGold(getGold() + creep.getCreepBuff());
            System.out.println("Creep is dead!");
            return;
        }

        creep.setHealth(creepHealth);
    }

    @Override
    public int move(int drakeSpeed) throws InvalidStatsException {
        int currentHeroSpeed = getHeroSpeed();

        if (currentHeroSpeed < drakeSpeed) {
            currentHeroSpeed += BUFFED_SPEED;
            setHeroSpeed(currentHeroSpeed);
        }


        return currentHeroSpeed;
    }


    public void heroRevive(Hero hero) throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {
        String heroName = hero.getName();
        if (hero.getIsDead()) {
            hero.setIsDead(false);
            hero.setHeroStats(heroName);

        } else {
            System.out.println("Hero is alive!");
        }
    }

}
