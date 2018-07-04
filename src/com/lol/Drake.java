package com.lol;

public class Drake extends Creatures implements Movable {
    private static final int DRAKE_MIN_SPEED = 0;
    private static final int DRAKE_MAX_SPEED = 500;
    private static final int DRAKE_MIN_BUFFED = 0;
    private static final int DRAKE_MAX_BUFFED = 40;
    private static final int DRAKE_MIN_BUFF_HERO = 0;
    private static final int DRAKE_MAX_BUFF_HERO = 500;
    private int speed;
    private int drakeBuff;
    private int buffedDrakeSpeed;
    private DrakeStats constants = new DrakeStats();

    public Drake(String name) throws NoSuchFieldException,
            IllegalAccessException{
        setDrakeStats(name.toUpperCase());
    }

    private void setDrakeStats(String name) throws NoSuchFieldException,
            IllegalAccessException {
        setName(name.toUpperCase());
        setAttackDamage(DrakeStats.class.getDeclaredField(name + "_DAMAGE").getInt(constants));
        setArmor(DrakeStats.class.getDeclaredField(name + "_ARMOR").getInt(constants));
        setHealth(DrakeStats.class.getDeclaredField(name + "_HEALTH").getInt(constants));
        setSpeed(DrakeStats.class.getDeclaredField(name + "_SPEED").getInt(constants));
        setBuffedDrakeSpeed(DrakeStats.class.getDeclaredField(name + "_BUFFED_SPEED").getInt(constants));
        setAbsorbDamage(DrakeStats.class.getDeclaredField(name + "_ABSORB_DAMAGE").getInt(constants));
        setDrakeBuff(DrakeStats.class.getDeclaredField(name + "_BUFF").getInt(constants));
        setIsDead(false);
    }

    @Override
    public void attackHeroes(Hero hero) {
        if (hero.getIsDead()){
            System.out.println("Hero is already dead!");
            return;
        }

        int currentSpeedDrake = move(hero.getHeroSpeed());

        if (currentSpeedDrake < hero.getHeroSpeed()){
            System.out.println("Hero is out of range");
            return;
        }

        int heroHealth = hero.getHealth();
        int heroArmor = hero.getArmor();
        int absorbDamage = heroArmor / getAbsorbDamage();
        heroHealth -= getAttackDamage() - absorbDamage;

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
            currentSpeedDrake += getBuffedDrakeSpeed();
            setSpeed(currentSpeedDrake);
        }


        return currentSpeedDrake;
    }

    int getSpeed() {
        return this.speed;
    }


    private void setSpeed(int speed) {
        if (speed < DRAKE_MIN_SPEED || speed > DRAKE_MAX_SPEED) {
            throw new RuntimeException("Invalid speed");
        }

        this.speed = speed;
    }

    private int getBuffedDrakeSpeed() {
        return buffedDrakeSpeed;
    }

    private void setBuffedDrakeSpeed(int buffedDrakeSpeed) {
        if (buffedDrakeSpeed < DRAKE_MIN_BUFFED || buffedDrakeSpeed > DRAKE_MAX_BUFFED) {
            throw new RuntimeException("Invalid buffedDrakeSpeed");
        }

        this.buffedDrakeSpeed = buffedDrakeSpeed;
    }

    int getDrakeBuff() {
        return drakeBuff;
    }

    private void setDrakeBuff(int drakeBuff) {
        if (drakeBuff < DRAKE_MIN_BUFF_HERO || drakeBuff > DRAKE_MAX_BUFF_HERO) {
            throw new RuntimeException("Invalid drakeBuff");
        }

        this.drakeBuff = drakeBuff;
    }
}
