package com.lol;

public class Creeps extends Creatures implements Movable {
    private static final String NAME = "Creep";
    private static final int CREEPS_DAMAGE = 20;
    private static final int CREEPS_HEALTH = 200;
    private static final int CREEPS_ARMOR = 150;
    private static final int CREEPS_SPEED = 200;
    private static final int MAX_CREEPS_SPEED = 300;
    private static final int MIN_CREEPS_SPEED = 0;
    private static final int BUFFED_CREEP_SPEED = 20;
    private int speed;

    public Creeps() {
        setName(NAME);
        setHealth(CREEPS_HEALTH);
        setArmor(CREEPS_ARMOR);
        setAttackDamage(CREEPS_DAMAGE);
        setSpeed(CREEPS_SPEED);
        setIsDead(false);
    }

    @Override
    public void attackHeroes(Hero hero) {
        if (getIsDead()){
            System.out.println("Hero is already dead!");
            return;
        }

        int currentSpeedCreep = move(hero.getSpeed());

        if (currentSpeedCreep < hero.getSpeed()){
            System.out.println("Hero is out of range");
            return;
        }

        int heroHealth = hero.getHealth();
        heroHealth -= CREEPS_DAMAGE;

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
        int currentSpeedCreep = getSpeed();

        if (currentSpeedCreep < heroSpeed) {
            currentSpeedCreep += BUFFED_CREEP_SPEED;
            setSpeed(currentSpeedCreep);
        }


        return currentSpeedCreep;
    }

    private void setSpeed(int speed) {
        if (speed < MIN_CREEPS_SPEED || speed > MAX_CREEPS_SPEED) {
            throw new RuntimeException("Invalid speed");
        }

        this.speed = speed;
    }

    private int getSpeed() {
        return this.speed;
    }
}
