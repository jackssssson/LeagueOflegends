package com.lol;

public class Item {

    private static final int HUNTERS_MACHETE_ADD_DAMAGE = 15;
    private static final int HUNTERS_MACHETE_PRICE = 350 ;
    int price = HUNTERS_MACHETE_PRICE;

    public static void buyItem(Hero hero, Items item) {
        if(item==Items.HUNTERS_MACHETE){
            hero.setAttackDamage(hero.getAttackDamage()+HUNTERS_MACHETE_ADD_DAMAGE);
            hero.setGold(hero.getGold()-HUNTERS_MACHETE_PRICE);
        }
    }
}
