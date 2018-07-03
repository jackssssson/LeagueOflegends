package com.lol;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Hero {
    //constants for validation only
    private static final int MIN_GOLD = 0;
    private static final int MIN_ATTACK_DAMAGE = 1;
    private static final int MAX_ATTACK_DAMAGE = 1000;
    private static final int MIN_AP_DAMAGE = 0;
    private static final int MAX_AP_DAMAGE = 1000;
    private static final int MAX_HEALTH = 10000;
    private static final int MIN_MANA = 1;
    private static final int MAX_MANA = 4000;
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 1000;
    private static final int GOLD_ON_KILL = 300;

    Consts constants = new Consts();

    public Hero() {
    }

    @Override
    public String toString() {
        return  " name='" + name + '\'' +
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
    private String herotype;

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

    public boolean isDead() {
        return isDead;
    }

    public void setIsDead(boolean dead) {
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
        return herotype;
    }

    public void setType(String type) {
        this.herotype = type;
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
        int normalAttackDMG = attacker.getAttackDamage();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();

        if(defenderArmor >= normalAttackDMG) {
            defender.setArmor(defenderArmor - normalAttackDMG);
            return;
        }

        if(defenderHealth <= normalAttackDMG){
            defender.setHealth(0);
            defender.setIsDead(true);
            attacker.setGold(attacker.getGold()+GOLD_ON_KILL);
            System.out.println(attacker.getName()+ " receives "+GOLD_ON_KILL+" gold for killing "+ defender.getName());
            return;
        }

        defender.setHealth((defenderHealth+defenderArmor) - normalAttackDMG);
        defender.setArmor(0);
    }

    public void magicAttack(Hero attacker, Hero defender) {
        int attackerAP = attacker.getApDamage();
        int attackerMana = attacker.getMana();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();
        int magicAttackManaCost = 75;

        if (attackerMana < magicAttackManaCost) {
            System.out.println( "Not enough mana to cast "+attacker.getName()+"'s Magic Attack");

        } else {

            int magicAttackDMG = attackerAP + 45;
            if (defenderArmor >= magicAttackDMG) {
                defender.setArmor(defenderArmor - magicAttackDMG);
                attacker.setMana(attackerMana - magicAttackManaCost);
                return;
            }
            if (defenderHealth <= magicAttackDMG) {
                attacker.setMana(attackerMana - magicAttackManaCost);
                defender.setHealth(0);
                defender.setIsDead(true);
                attacker.setGold(attacker.getGold() + GOLD_ON_KILL);
                System.out.println(attacker.getName()+ " receives "+GOLD_ON_KILL+" gold for killing "+ defender.getName());
                return;
            }
            attacker.setMana(attackerMana - magicAttackManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - magicAttackDMG);
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
            System.out.println( "Not enough mana to cast "+attacker.getName()+"'s Ultimate");

        } else {

            int UltimateDMG = attackerAP + attackerAD + 70;
            if (defenderArmor >= UltimateDMG) {
                defender.setArmor(defenderArmor - UltimateDMG);
                attacker.setMana(attackerMana - ultimateManaCost);
                return;
            }
            if (defenderHealth <= UltimateDMG) {
                attacker.setMana(attackerMana - ultimateManaCost);
                defender.setHealth(0);
                defender.setIsDead(true);
                attacker.setGold(attacker.getGold() + 300);
                System.out.println(attacker.getName()+ " receives "+GOLD_ON_KILL+" gold for killing "+ defender.getName());
                return;
            }

            attacker.setMana(attackerMana - ultimateManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - UltimateDMG);
            defender.setArmor(0);

        }

    }

}
