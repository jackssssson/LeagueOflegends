package com.lol;

public class Hero {
    //constants for validation only First
    private static final int MIN_GOLD = 0;
    private static final int MIN_ATTACK_DAMAGE = 1;
    private static final int MAX_ATTACK_DAMAGE = 1000;
    private static final int MIN_AP_DAMAGE = 0;
    private static final int MAX_AP_DAMAGE = 1500;
    private static final int MAX_HEALTH = 10000;
    private static final int MIN_MANA = 50;
    private static final int MAX_MANA = 4000;
    private static final int MIN_SPEED = 0;
    private static final int MAX_SPEED = 1000;
    private static final int HERO_BUFFED_SPEED = 10;

    // fields First
    private int health;
    private int mana;
    private int armor;
    private int attackDamage;
    private int apDamage;
    private int gold;
    private int heroSpeed;
    private Nashor nashor = new Nashor();
    private Creeps creep = new Creeps();
    private Drake drake = new Drake();


    // Alex
    private boolean isDead = false;

    //constructor First
    public Hero(){
    }

    //getters and setters First
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
    public void setisDead(boolean dead){
        isDead = dead;
    }

    public boolean getIsHeroDead() {
        return isHeroDead();
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

    //methods First

    public void nashorAttackHero() {
        health -= nashor.doDamage(getHeroSpeed());
        setHealth(health);
    }

    public void heroAttackNashor() {
        gold += nashor.heroAttack(attackDamage);
        setGold(gold);
    }

    public void creepAttackHero() {
        int creepSpeed = creep.move(getHeroSpeed());

        if (creepSpeed < heroSpeed) {
            System.out.println("Creep can`t attack because hero is not in range");
        } else {
            health -= creep.doDamage(getHeroSpeed());
            setHealth(health);
        }
    }

    public void heroAttackCreep() {
        setHeroSpeed(heroSpeed + HERO_BUFFED_SPEED);
        if (heroSpeed < creep.getSpeed()) {
            System.out.println("Hero can`t attack because creep is not in range");
        } else {
            gold += creep.heroAttack(attackDamage);
            setGold(gold);
        }
    }

    public void drakeAttackHero() {
        int drakeSpeed = drake.move(getHeroSpeed());

        if (drakeSpeed < heroSpeed) {
            System.out.println("Drake can`t attack because hero is not in range");
        } else {
            health -= drake.doDamage(getHeroSpeed());
            setHealth(health);
        }
    }

    public void heroAttackDrake() {
        setHeroSpeed(heroSpeed + HERO_BUFFED_SPEED);
        if (heroSpeed < drake.getSpeed()) {
            System.out.println("Hero can`t attack because Drake is not in range");
        } else {
            gold += drake.heroAttack(attackDamage);
            setGold(gold);
        }
    }

    public int heroAttackAnotherHero(Hero attacker, Hero defender) {
        defender.health -= attacker.attackDamage;

        return defender.health;
    }

    public void NormalAttack(){

    }


    private boolean isHeroDead() {
        if (health <= 0) {
            return true;
        }

        return false;
    }
}
