package com.lol;

public class Item {

    private ItemConsts constants = new ItemConsts();

    public void buyItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException {
        String itemPrise = item + "_PRICE";
        String itemType = item + "_TYPE";

        if (hero.getGold() >= ItemConsts.class.getDeclaredField(itemPrise).getInt(constants)) {

            hero.getListHeroItems().add(item);

            for (Items oldItem : hero.getEquippedItems()) {
                if(( ItemConsts.class.getDeclaredField(oldItem + "_TYPE").get(constants)).equals(( ItemConsts.class.getDeclaredField(itemType).get(constants)))){
                    unEquipItem(hero, oldItem);
                }
            }

            equipItem(hero, item);
            hero.setGold(hero.getGold() - ItemConsts.class.getDeclaredField(itemPrise).getInt(constants));
        }
    }

    public void equipItem(Hero hero, Items item)throws NoSuchFieldException, IllegalAccessException {

        String itemBenefit = item + "_ADD";
        String itemType = item + "_TYPE";


        if (hero.getListHeroItems().contains(item)) {

            if (( ItemConsts.class.getDeclaredField(itemType).get(constants)).equals("WEAPON")) {
                hero.setAttackDamage(hero.getAttackDamage() + ItemConsts.class.getDeclaredField(itemBenefit).getInt(constants));
            }
            if (( ItemConsts.class.getDeclaredField(itemType).get(constants)).equals("SHIELD")) {
                hero.setArmor(hero.getArmor() + ItemConsts.class.getDeclaredField(itemBenefit).getInt(constants));
            }

            hero.getEquippedItems().add(item);
        }
    }

    public void unEquipItem(Hero hero, Items item)throws NoSuchFieldException, IllegalAccessException {
        String itemBenefit = item + "_ADD";
        String itemType = item + "_TYPE";

        if(hero.getEquippedItems().contains(item)) {

            if (( ItemConsts.class.getDeclaredField(itemType).get(constants)).equals("WEAPON")) {
                hero.setAttackDamage(hero.getAttackDamage() - ItemConsts.class.getDeclaredField(itemBenefit).getInt(constants));
            }
            if (( ItemConsts.class.getDeclaredField(itemType).get(constants)).equals("SHIELD")) {
                hero.setArmor(hero.getArmor() - ItemConsts.class.getDeclaredField(itemBenefit).getInt(constants));
            }

            hero.getEquippedItems().remove(item);
        }
    }

}