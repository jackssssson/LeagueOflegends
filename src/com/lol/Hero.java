package com.lol;

public abstract class Hero extends Unit {
    //const
    private static final int HERO_MIN_SPEED = 0;
    private static final int HERO_MAX_SPEED = 1000;

    //fields
    private int gold;
    private int speed;
    private int mana;
    private int apDamage;

    //abstract methods
    public abstract void normalAttack(Hero attacker , Hero defender);
    public abstract void magicAttack(Hero attacker , Hero defender);
    public abstract void ultimateAttack(Hero attacker, Hero defender);


    //getters and setters
    public int getGold() {
        return gold;
    }

    public void setGold(int heroGold) {
        this.gold = heroGold;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int heroSpeed) {
        if (heroSpeed < HERO_MIN_SPEED || heroSpeed > HERO_MAX_SPEED) {
            throw new RuntimeException("Invalid speed");
        }

        this.speed = heroSpeed;
    }

    public int getApDamage() {
        return apDamage;
    }

    public void setApDamage(int apDamage) {
        this.apDamage = apDamage;
    }
}
