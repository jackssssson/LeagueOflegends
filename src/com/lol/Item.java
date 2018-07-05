package com.lol;

public class Item {

    private Consts constants = new Consts();

    public void buyItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException {
        String itemPrise = item + "_PRICE";
        String itemType = item + "_TYPE";

        if (hero.getGold() >= Consts.class.getDeclaredField(itemPrise).getInt(constants)) {

            hero.getListHeroItems().add(item);

            for (Items oldItem : hero.getEquippedItems()) {
                if(((String) Consts.class.getDeclaredField(oldItem + "_TYPE").get(constants)).equals(((String) Consts.class.getDeclaredField(itemType).get(constants)))){
                    unEquipItem(hero, oldItem);
                }
            }

            equipItem(hero, item);
            hero.setGold(hero.getGold() - Consts.class.getDeclaredField(itemPrise).getInt(constants));
        }
    }

    public void equipItem(Hero hero, Items item)throws NoSuchFieldException, IllegalAccessException {

        String itemBenefit = item + "_ADD";
        String itemType = item + "_TYPE";

        if (hero.getListHeroItems().contains(item)) {

            if (((String) Consts.class.getDeclaredField(itemType).get(constants)).equals("WEAPON")) {
                hero.setAttackDamage(hero.getAttackDamage() + Consts.class.getDeclaredField(itemBenefit).getInt(constants));
            }
            if (((String) Consts.class.getDeclaredField(itemType).get(constants)).equals("SHIELD")) {
                hero.setArmor(hero.getArmor() + Consts.class.getDeclaredField(itemBenefit).getInt(constants));
            }

            hero.getEquippedItems().add(item);
        }
    }

    public void unEquipItem(Hero hero, Items item)throws NoSuchFieldException, IllegalAccessException {
        String itemBenefit = item + "_ADD";
        String itemType = item + "_TYPE";

        if(hero.getEquippedItems().contains(item)) {

            if (((String) Consts.class.getDeclaredField(itemType).get(constants)).equals("WEAPON")) {
                hero.setAttackDamage(hero.getAttackDamage() - Consts.class.getDeclaredField(itemBenefit).getInt(constants));
            }
            if (((String) Consts.class.getDeclaredField(itemType).get(constants)).equals("SHIELD")) {
                hero.setArmor(hero.getArmor() - Consts.class.getDeclaredField(itemBenefit).getInt(constants));
            }

            hero.getEquippedItems().remove(item);
        }
    }

}