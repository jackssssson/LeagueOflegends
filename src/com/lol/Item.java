package com.lol;

public class Item {

    private ItemConsts constants = new ItemConsts();

    public void buyItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException, InvalidStatsException {
        String itemPrise = item + "_PRICE";
        String itemType = item + "_TYPE";

        if (hero.getGold() >= ItemConsts.class.getDeclaredField(itemPrise).getInt(constants)) {

            hero.getListHeroItems().add(item);
           /* if (hero.getEquippedItems().size() > 4) {
                askToUnequip(oldItem);
                unEquipItem(hero, oldItem);
            }
*/
            equipItem(hero, item);
            hero.setGold(hero.getGold() - ItemConsts.class.getDeclaredField(itemPrise).getInt(constants));
        }
    }

    private void equipItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException, InvalidStatsException {

        String itemDamage = item + "_ADD_DAMAGE";
        String itemArmor = item + "_ADD_ARMOR";
        String itemMagic = item + "_ADD_MAGIC";

        if (hero.getListHeroItems().contains(item)) {
            hero.setAttackDamage(hero.getAttackDamage() + ItemConsts.class.getDeclaredField(itemDamage).getInt(constants));
            hero.setArmor(hero.getArmor() + ItemConsts.class.getDeclaredField(itemArmor).getInt(constants));
            hero.setApDamage(hero.getApDamage() + ItemConsts.class.getDeclaredField(itemMagic).getInt(constants));
            hero.getEquippedItems().add(item);
        }
    }

    public void unEquipItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException, InvalidStatsException {
        String itemDamage = item + "_ADD_DAMAGE";
        String itemArmor = item + "_ADD_ARMOR";
        String itemMagic = item + "_ADD_MAGIC";

        if (hero.getEquippedItems().contains(item)) {
            hero.setAttackDamage(hero.getAttackDamage() - ItemConsts.class.getDeclaredField(itemDamage).getInt(constants));
            hero.setArmor(hero.getArmor() - ItemConsts.class.getDeclaredField(itemArmor).getInt(constants));
            hero.setApDamage(hero.getApDamage() - Items.class.getDeclaredField(itemMagic).getInt(constants));
            hero.getEquippedItems().remove(item);
        }

    }
}
