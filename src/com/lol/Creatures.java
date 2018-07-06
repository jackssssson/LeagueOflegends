package com.lol;

public abstract class Creatures extends Unit {
    public abstract void attackHeroes(Hero hero);

    public Creatures(String name){
        setName(name);
    }

    public Creatures(String name, int health, int armor, int attackDamage, boolean isDead, int absorbDamage) {
        setName(name);
        setHealth(health);
        setArmor(armor);
        setAttackDamage(attackDamage);
        setIsDead(isDead);
        setAbsorbDamage(absorbDamage);
    }

    public Creatures creatureRespawn(Creatures creature) throws NoSuchFieldException,
            IllegalAccessException {
        if (creature.getIsDead()) {
            if (creature instanceof Creeps) {
                return new Creeps();
            } else if (creature instanceof Nashor) {
                return new Nashor();
            } else {
                return new Drake(creature.getName());
            }
        } else {
            System.out.println("Creature is alive!");
            return creature;
        }
    }
}
