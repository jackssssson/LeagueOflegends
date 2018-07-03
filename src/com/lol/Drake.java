package com.lol;

public class Drake extends Creatures implements Movable {
    private static final String NAME = "Drake";
    private static final int DRAKE_DAMAGE = 100;
    private static final int DRAKE_ARMOR = 50;
    private static final int DRAKE_HEALTH = 5000;
    private static final int DRAKE_SPEED = 250;
    private static final int BUFFED_DRAKE_SPEED = 10;
    private static final int DRAKE_MIN_SPEED = 0;
    private static final int DRAKE_MAX_SPEED = 500;
    private int speed;

    public Drake() {
        setName(NAME);
        setHealth(DRAKE_HEALTH);
        setArmor(DRAKE_ARMOR);
        setAttackDamage(DRAKE_DAMAGE);
        setSpeed(DRAKE_SPEED);
        setIsDead(false);
    }

    @Override
    public void attackHeroes(Hero hero) {
        if (getIsDead()){
            System.out.println("Hero is already dead!");
            return;
        }

        int currentSpeedDrake = move(hero.getSpeed());

        if (currentSpeedDrake < hero.getSpeed()){
            System.out.println("Hero is out of range");
            return;
        }

        int heroHealth = hero.getHealth();
        heroHealth -= DRAKE_DAMAGE;

        if (heroHealth <= 0) {
            hero.setHealth(0);
            setIsDead(true);
            System.out.println("Hero is dead!");
            return;
        }

        hero.setHealth(heroHealth);
    }


    @Override
    public int move(int heroSpeed) {
        int currentSpeedDrake = getSpeed();

        if (currentSpeedDrake < heroSpeed){
            currentSpeedDrake += BUFFED_DRAKE_SPEED;
            setSpeed(currentSpeedDrake);
        }


        return currentSpeedDrake;
    }

    private int getSpeed() {
        return this.speed;
    }


    private void setSpeed(int speed) {
        if (speed < DRAKE_MIN_SPEED || speed > DRAKE_MAX_SPEED) {
            throw new RuntimeException("Invalid speed");
        }

        this.speed = speed;
    }
}
