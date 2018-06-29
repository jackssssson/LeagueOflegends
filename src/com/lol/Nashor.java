package com.lol;

public class Nashor extends Creatures {
    private static final int NASHOR_GOLD_DEAD = 500;
    private static final int NASHOR_DAMAGE = 200;
    private static final int NASHOR_HEALTH_AT_START = 10000;
    private static final int MAX_NASHOR_HEALTH = 20000;

    private int nashorHealth;

    public Nashor() {
        this.nashorHealth = NASHOR_HEALTH_AT_START;
    }

    @Override
    public int doDamage(int heroSpeed) {
        return NASHOR_DAMAGE;
    }

    @Override
    public int heroAttack(int damage) {
        nashorHealth = getNashorHealth() - damage;
        setNashorHealth(nashorHealth);

        if (nashorHealth <= 0){
            return NASHOR_GOLD_DEAD;
        }

        return 0;
    }


    public int getNashorHealth() {
        return nashorHealth;
    }

    public void setNashorHealth(int nashorHealth) {
        if (nashorHealth > MAX_NASHOR_HEALTH){
            throw new RuntimeException("Invalid health");
        }

        this.nashorHealth = nashorHealth;
    }
}
