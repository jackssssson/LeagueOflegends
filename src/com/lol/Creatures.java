package com.lol;

public abstract class Creatures extends Unit {
    public abstract void attackHeroes(Hero hero);

    public Creatures creatureRespawn (Creatures creature) throws NoSuchFieldException,
            IllegalAccessException{
        if (creature.getIsDead()){
            if (creature instanceof Creeps){
                return new Creeps();
            } else if (creature instanceof Nashor){
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
