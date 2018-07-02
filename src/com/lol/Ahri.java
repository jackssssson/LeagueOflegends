package com.lol;

    public  class Ahri extends Hero implements Spells{

        private static final int STARTING_HEALTH = 520;
        private static final int STARTING_MANA = 420;
        private static final int STARTING_ARMOR = 50;
        private static final int STARTING_GOLD = 500;
        private static final int STARTING_HEROSPEED = 45;
        private static final int STARTING_ATTACKDAMAGE = 50;
        private static final int STARTING_ABILLITY_POWER = 15;
        private static final boolean isDead = false;

        public Ahri(){
            setHealth(STARTING_HEALTH);
            setMana(STARTING_MANA);
            setArmor(STARTING_ARMOR);
            setGold(STARTING_GOLD);
            setHeroSpeed(STARTING_HEROSPEED);
            setAttackDamage(STARTING_ATTACKDAMAGE);
            setApDamage(STARTING_ABILLITY_POWER);
            setisDead(isDead);
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
                defender.setisDead(true);
                attacker.setGold(attacker.getGold()+300);
            }

            defender.setHealth((defenderHealth+defenderArmor) - attackerAD);
            defender.setArmor(0);
        }
        @Override
        public void MagicAttackOne(Hero attacker , Hero defender) {
            int attackerAP = attacker.getApDamage();
            int attackerMana = attacker.getMana();
            int defenderArmor = defender.getArmor();
            int defenderHealth = defender.getHealth();
            int TaleCutManaCost = 85;

            if (attackerMana < TaleCutManaCost) {
                throw new RuntimeException("Not enough mana");

            } else {

                int TaleCut = attackerAP + 45;
                if (defenderArmor >= attackerAP) {
                    defender.setArmor(defenderArmor - TaleCut);
                    return;
                }
                if (defenderHealth <= TaleCut) {
                    defender.setisDead(true);
                    attacker.setGold(attacker.getGold() + 300);
                    return;
                }

                defender.setHealth((defenderHealth + defenderArmor) - TaleCut);

            }
        }
    }