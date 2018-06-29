package com.lol;

public class Drake extends Creatures implements Movable {
    private static final int DRAKE_GOLD_DEAD = 300;
    private static final int DRAKE_DAMAGE = 100;
    private static final int DRAKE_HEALTH = 5000;
    private static final int MAX_DRAKE_HEALTH = 10000;
    private static final int MAX_DRAKE_SPEED = 1000;
    private static final int MIN_DRAKE_SPEED = 0;
    private static final int BUFFED_DRAKE_SPEED = 10;
    private boolean isBuffed;
    private int drakeHealth;
    private int speed;

    public Drake() {
        this.drakeHealth = DRAKE_HEALTH;
        setSpeed(speed);
    }

    @Override
    public int doDamage(int heroSpeed) {
        if (getSpeed() < heroSpeed){
            return 0;
        }

        return DRAKE_DAMAGE;
    }

    @Override
    public int heroAttack(int damage) {
        drakeHealth = getDrakeHealth() - damage;
        setDrakeHealth(drakeHealth);

        if (drakeHealth <= 0){
            return DRAKE_GOLD_DEAD;
        }

        return 0;
    }


    @Override
    public int move() {
        int currentSpeedDrake = getSpeed();

        if (getIsBuffed()){
            currentSpeedDrake += BUFFED_DRAKE_SPEED;
        }

        setBuffed(false);
        return currentSpeedDrake;
    }

    public void setSpeed(int speed) {
        if (speed < MIN_DRAKE_SPEED || speed > MAX_DRAKE_SPEED) {
            throw new RuntimeException("Invalid speed");
        }

        this.speed = speed;
    }

    public int getDrakeHealth() {
        return drakeHealth;
    }

    public void setDrakeHealth(int drakeHealth) {
        if (drakeHealth > MAX_DRAKE_HEALTH) {
            throw new RuntimeException("Invalid health");
        }

        this.drakeHealth = drakeHealth;
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
