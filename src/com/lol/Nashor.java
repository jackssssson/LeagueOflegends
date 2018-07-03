package com.lol;

public class Nashor extends Creatures {
    private static final String NAME = "Nashor";
    private static final int NASHOR_ARMOR = 300;
    private static final int NASHOR_DAMAGE = 200;
    private static final int NASHOR_HEALTH_AT_START = 10000;


    public Nashor() {
        setName(NAME);
        setHealth(NASHOR_HEALTH_AT_START);
        setArmor(NASHOR_ARMOR);
        setAttackDamage(NASHOR_DAMAGE);
        setIsDead(false);
    }

    @Override
    public void attackHeroes(Hero hero) {
        if (getIsDead()){
            System.out.println("Hero is already dead!");
            return;
        }

        int heroHealth = hero.getHealth();
        heroHealth -= NASHOR_DAMAGE;

        if (heroHealth <= 0) {
            hero.setHealth(0);
            setIsDead(true);
            System.out.println("Hero is dead!");
            return;
        }

        hero.setHealth(heroHealth);
    }
}
