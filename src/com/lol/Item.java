package com.lol;

public class Item {

    private boolean equipped;
    private Consts constants = new Consts();


    public void buyItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException {
        hero.getListHeroItems().add(item);
        String itemPrise = item + "_PRICE";
        String itemBenefit = item + "_ADD";
        String itemType = item + "_TYPE";


        if (hero.getGold() >= Consts.class.getDeclaredField(itemPrise).getInt(constants)) {

            if (Consts.class.getDeclaredField(itemType).getInt(constants)==Consts.WEAPONS) {
                hero.setAttackDamage(hero.getAttackDamage() + Consts.class.getDeclaredField(itemBenefit).getInt(constants));
            }
            if (Consts.class.getDeclaredField(itemType).getInt(constants)==Consts.SHIELDS) {
                hero.setArmor(hero.getArmor() + Consts.class.getDeclaredField(itemBenefit).getInt(constants));
            }
            hero.setGold(hero.getGold() - Consts.class.getDeclaredField(itemPrise).getInt(constants));

            equipped = true;
        }

    }

//    public void equipItem(Hero hero, Items item) {
//
//    }
//
//    public void unEquipItem(Hero hero, Items item) {
//
//    }

    public boolean isEquipped() {
        return equipped;
    }

    public void setEquipped(boolean equipped) {
        this.equipped = equipped;
    }
}


