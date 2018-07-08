package com.lol;

public class Nashor extends Creatures {
    private static final String NAME = "Nashor";
    private static final int NASHOR_ARMOR = 300;
    private static final int NASHOR_DAMAGE = 150;
    private static final int NASHOR_HEALTH_AT_START = 1200;
    private static final int NASHOR_BUFF = 300;
    private static final int ABSORB_DAMAGE = 8;

    public Nashor() throws InvalidStatsException {
        super(NAME, NASHOR_HEALTH_AT_START, NASHOR_ARMOR, NASHOR_DAMAGE, false, ABSORB_DAMAGE);
    }

    @Override
    public void attackHeroes(Hero hero) throws InvalidStatsException {
        if (getIsDead()){
            System.out.println(hero.getName() + " is already dead!");
            return;
        }

        int heroHealth = hero.getHealth();
        int heroArmor = hero.getArmor();
        int absorbDamage = heroArmor / getAbsorbDamage();
        heroHealth -= NASHOR_DAMAGE - absorbDamage;

        if (heroHealth <= CREATURE_STATS_DEAD) {
            hero.setHealth(CREATURE_STATS_DEAD);
            hero.setIsDead(true);
            System.out.println(hero.getName() + " is dead!");
            return;
        }

        hero.setHealth(heroHealth);
    }

    int getNashorBuff() {
        return NASHOR_BUFF;
    }
}
