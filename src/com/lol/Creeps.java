package com.lol;

public class Creeps extends Creatures implements Movable {
    private static final int CREEPS_GOLD_DEAD = 20;
    private static final int CREEPS_DAMAGE = 20;
    private static final int CREEPS_HEALTH = 200;
    private static final int MAX_CREEPS_HEALTH = 2000;
    private static final int MAX_CREEPS_SPEED = 300;
    private static final int MIN_CREEPS_SPEED = 0;
    private static final int BUFFED_CREEP_SPEED = 10;
    private boolean isBuffed;
    private int creepsHealth;
    private int speed;

    public Creeps() {
        this.creepsHealth = CREEPS_HEALTH;
        setSpeed(speed);
    }

    @Override
    public int doDamage(int heroSpeed) {
        if (getSpeed() < heroSpeed){
            return 0;
        }

        return CREEPS_DAMAGE;
    }

    @Override
    public int heroAttack(int damage) {
        creepsHealth = getCreepsHealth() - damage;
        setCreepsHealth(creepsHealth);

        if (creepsHealth <= 0){
            return CREEPS_GOLD_DEAD;
        }
        return 0;
    }


    @Override
    public int move() {
        int currentSpeedCreep = getSpeed();

        if (getIsBuffed()){
            currentSpeedCreep += BUFFED_CREEP_SPEED;
        }

        setBuffed(false);
        return currentSpeedCreep;
    }

    public void setSpeed(int speed) {
        if (speed < MIN_CREEPS_SPEED || speed > MAX_CREEPS_SPEED){
            throw new RuntimeException("Invalid speed");
        }

        this.speed = speed;
    }

    public int getCreepsHealth() {
        return creepsHealth;
    }

    public void setCreepsHealth(int creepsHealth) {
        if (creepsHealth > MAX_CREEPS_HEALTH){
            throw new RuntimeException("Invalid health");
        }

        this.creepsHealth = creepsHealth;
    }

    public int getSpeed() {
        return this.speed;
    }

    public boolean getIsBuffed() {
        return isBuffed;
    }

    public void setBuffed(boolean buffed) {
        isBuffed = buffed;
    }
}
