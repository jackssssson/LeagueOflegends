package com.lol;

public  class Jarvan extends Hero {

    private static final String NAME = "Ahri";
    private static final int STARTING_HEALTH = 520;
    private static final int STARTING_MANA = 420;
    private static final int STARTING_ARMOR = 50;
    private static final int STARTING_GOLD = 500;
    private static final int STARTING_HERO_SPEED = 45;
    private static final int STARTING_ATTACK_DAMAGE = 50;
    private static final int STARTING_ABILITY_POWER = 15;
    private static final boolean IS_DEAD = false;

    public Jarvan(){
        setName(NAME);
        setHealth(STARTING_HEALTH);
        setMana(STARTING_MANA);
        setArmor(STARTING_ARMOR);
        setGold(STARTING_GOLD);
        setHeroSpeed(STARTING_HERO_SPEED);
        setAttackDamage(STARTING_ATTACK_DAMAGE);
        setApDamage(STARTING_ABILITY_POWER);
        setisDead(IS_DEAD);
    }
    @Override
    public void NormalAttack(Hero attacker, Hero defender){
        int attackerAD = attacker.getAttackDamage();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();

        if(defenderArmor >= attackerAD) {
            defender.setArmor(defenderArmor - attackerAD);
            return;
        }

        if(defenderHealth <= attackerAD){
            defender.setHealth(0);
            defender.setisDead(true);
            attacker.setGold(attacker.getGold()+300);
            System.out.println(attacker.getName()+ " receives 300 gold for killing "+ defender.getName());
            return;
        }

        defender.setHealth((defenderHealth+defenderArmor) - attackerAD);
        defender.setArmor(0);
    }
    @Override
    public void MagicAttack(Hero attacker , Hero defender) {
        int attackerAP = attacker.getApDamage();
        int attackerMana = attacker.getMana();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();
        int TaleCutManaCost = 85;

        if (attackerMana < TaleCutManaCost) {
            System.out.println( "Not enough mana to cast "+attacker.getName()+"'s Magic Spell - TaleCut");

        } else {

            int TaleCut = attackerAP + 45;
            if (defenderArmor >= TaleCut) {
                defender.setArmor(defenderArmor - TaleCut);
                attacker.setMana(attackerMana - TaleCutManaCost);
                return;
            }
            if (defenderHealth <= TaleCut) {
                attacker.setMana(attackerMana - TaleCutManaCost);
                defender.setHealth(0);
                defender.setisDead(true);
                attacker.setGold(attacker.getGold() + 300);
                System.out.println(attacker.getName()+ " receives 300 gold for killing "+ defender.getName());
                return;
            }
            attacker.setMana(attackerMana - TaleCutManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - TaleCut);
            defender.setArmor(0);

        }
    }

    // Attacks with FireFox = (AD+AP+70) , considers defender's Armor and attacker's Mana, if enemy is killed , attacker receives 300 gold
    @Override
    public void UltimateAttack(Hero attacker, Hero defender){
        int AttackerAP = attacker.getApDamage();
        int AttackerAD = attacker.getAttackDamage();
        int attackerMana = attacker.getMana();
        int defenderArmor = defender.getArmor();
        int defenderHealth = defender.getHealth();
        int FireFoxManaCost = 120;

        if (attackerMana < FireFoxManaCost) {
            System.out.println( "Not enough mana to cast "+attacker.getName()+"'s Ultimate - FireFox");

        } else {

            int FireFox = AttackerAP + AttackerAD + 70;
            if (defenderArmor >= FireFox) {
                defender.setArmor(defenderArmor - FireFox);
                attacker.setMana(attackerMana - FireFoxManaCost);
                return;
            }
            if (defenderHealth <= FireFox) {
                attacker.setMana(attackerMana - FireFoxManaCost);
                defender.setHealth(0);
                defender.setisDead(true);
                attacker.setGold(attacker.getGold() + 300);
                System.out.println(attacker.getName()+ " receives 300 gold for killing "+ defender.getName());
                return;
            }

            attacker.setMana(attackerMana - FireFoxManaCost);
            defender.setHealth((defenderHealth + defenderArmor) - FireFox);
            defender.setArmor(0);

        }

    }
}
