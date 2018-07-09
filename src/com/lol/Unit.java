package com.lol;

public class Unit {
    //const
    private static final int MIN_AD_DAMAGE = 0;
    private static final int MAX_AD_DAMAGE = 1600;
    private static final int MIN_ARMOR = 0;
    private static final int MAX_ARMOR = 700;
    private static final int MIN_HEALTH = 0;
    private static final int MAX_HEALTH = 10000;
    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 40;
    private static final int MIN_ABSORB_DAMAGE = 0;
    private static final int MAX_ABSORB_DAMAGE = 50;
    static final int CREATURE_STATS_DEAD = 0;

    private String name;
    private int health;
    private int armor;
    private int attackDamage;
    private boolean isDead;
    private int absorbDamage;

    public String getName() {
        return name;
    }

    void setName(String name) throws InvalidStatsException {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH) {
            throw new InvalidStatsException("Invalid name");
        }

        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    void setHealth(int health) throws InvalidStatsException {
        if (health < MIN_HEALTH || health > MAX_HEALTH) {
            throw new InvalidStatsException("Invalid health");
        }

        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    void setArmor(int armor) throws InvalidStatsException {
        if (armor < MIN_ARMOR || armor > MAX_ARMOR) {
            throw new InvalidStatsException("Invalid armor");
        }

        this.armor = armor;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    void setAttackDamage(int attackDamage) throws InvalidStatsException {
        if (attackDamage < MIN_AD_DAMAGE || attackDamage > MAX_AD_DAMAGE) {
            throw new InvalidStatsException("Invalid attackDamage");
        }

        this.attackDamage = attackDamage;
    }

    public boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean dead) throws InvalidStatsException {
        isDead = dead;
    }

    int getAbsorbDamage() {
        return absorbDamage;
    }

    void setAbsorbDamage(int absorbDamage) throws InvalidStatsException {
        if (absorbDamage < MIN_ABSORB_DAMAGE || absorbDamage > MAX_ABSORB_DAMAGE) {
            throw new InvalidStatsException("Invalid absorbDamage");
        }

        this.absorbDamage = absorbDamage;
    }


}
