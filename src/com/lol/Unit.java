package com.lol;

public class Unit {
    //const
    private static final int MIN_AP_DAMAGE = 0;
    private static final int MAX_AP_DAMAGE = 1500;
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


    private String name;
    private int health;
    private int armor;
    private int attackDamage;
    private int apDamage;
    private boolean isDead;
    private int absorbDamage;


    public String getName() {
        return name;
    }

    void setName(String name) {
        if (name.length() < MIN_NAME_LENGTH || name.length() > MAX_NAME_LENGTH){
            throw new RuntimeException("Invalid name");
        }

        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        if (health < MIN_HEALTH || health > MAX_HEALTH){
            throw new RuntimeException("Invalid health");
        }

        this.health = health;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        if (armor < MIN_ARMOR || armor > MAX_ARMOR){
            throw new RuntimeException("Invalid armor");
        }

        this.armor = armor;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        if (attackDamage < MIN_AD_DAMAGE || attackDamage > MAX_AD_DAMAGE){
            throw new RuntimeException("Invalid attackDamage");
        }

        this.attackDamage = attackDamage;
    }

    public int getApDamage() {
        return apDamage;
    }

    void setApDamage(int apDamage) {
        if (apDamage < MIN_AP_DAMAGE || apDamage > MAX_AP_DAMAGE){
            throw new RuntimeException("Invalid apDamage");
        }

        this.apDamage = apDamage;
    }

     boolean getIsDead() {
        return isDead;
    }

    public void setIsDead(boolean dead) {
        isDead = dead;
    }

    public int getAbsorbDamage() {
        return absorbDamage;
    }

    public void setAbsorbDamage(int absorbDamage) {
        if (absorbDamage < MIN_ABSORB_DAMAGE || absorbDamage > MAX_ABSORB_DAMAGE) {
            throw new RuntimeException("Invalid absorbDamage");
        }

        this.absorbDamage = absorbDamage;
    }
}
