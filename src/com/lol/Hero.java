package com.lol;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class Hero extends Unit{
    //constants for validation only
    private static final int MIN_GOLD = 0;
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 1000;
    private static final int GOLD_ON_KILL = 300;

    Consts constants = new Consts();

    @Override
    public String toString() {
        return  " name = " + getName() +
                ", health = " + getHealth() +
                ", mana = " + mana +
                ", armor = " + getArmor() +
                ", attackDamage = " + getAttackDamage() +
                ", apDamage = " + getApDamage() +
                ", gold = " + gold +
                ", heroSpeed = " + heroSpeed +
                ", isDead = " + isDead +
                '}';
    }


    public Hero(String name) throws NoSuchFieldException,
            IllegalAccessException {
        setHeroStats(name.toUpperCase());
    }

    private int mana;
    private int gold;
    private int heroSpeed;
    private boolean isDead = false;
    private String herotype;

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
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
        int normalAttackDmg = attacker.getAttackDamage();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();

        if(defenderArmor >= normalAttackDmg) {
            defender.setArmor(defenderArmor - normalAttackDmg);
            return;
        }

        if(defenderHealth <= normalAttackDmg){
            defender.setHealth(0);
            defender.setIsDead(true);
            attacker.setGold(attacker.getGold()+GOLD_ON_KILL);
            System.out.println(attacker.getName()+ " receives "+GOLD_ON_KILL+" gold for killing "+ defender.getName());
            return;
        }

        defender.setHealth((defenderHealth+defenderArmor) - normalAttackDmg);
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
                System.out.println(attacker.getName()+ " receives "+GOLD_ON_KILL+" gold for killing "+ defender.getName());
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
            System.out.println( "Not enough mana to cast "+attacker.getName()+"'s Ultimate");

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
                System.out.println(attacker.getName()+ " receives "+GOLD_ON_KILL+" gold for killing "+ defender.getName());
                return;
            }

            attacker.setMana(attackerMana - ultimateManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - ultimateDmg);
            defender.setArmor(0);

        }

    }

}
