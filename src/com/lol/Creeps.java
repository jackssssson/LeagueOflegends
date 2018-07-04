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
    private static final int ABSORB_DAMAGE = 10;
    private static final int CREEP_BUFF = 20;
    private int speed;

    public Creeps() {
        setName(NAME);
        setHealth(CREEPS_HEALTH);
        setArmor(CREEPS_ARMOR);
        setAttackDamage(CREEPS_DAMAGE);
        setSpeed(CREEPS_SPEED);
        setAbsorbDamage(ABSORB_DAMAGE);
        setIsDead(false);
    }

    @Override
    public void attackHeroes(Hero hero) {
        if (getIsDead()){
            System.out.println("Hero is already dead!");
            System.out.println("You can revive him!");
            return;
        }

        int currentSpeedCreep = move(hero.getHeroSpeed());

        if (currentSpeedCreep < hero.getHeroSpeed()){
            System.out.println("Hero is out of range");
            return;
        }

        int heroHealth = hero.getHealth();
        int heroArmor = hero.getArmor();
        int absorbDamage = heroArmor / ABSORB_DAMAGE;
        heroHealth -= CREEPS_DAMAGE - absorbDamage;

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

    int getSpeed() {
        return this.speed;
    }

    int getCreepBuff() {
        return CREEP_BUFF;
    }
}
