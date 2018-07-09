package com.lol;

import java.util.Scanner;

public class Item {

    private ItemConsts constants = new ItemConsts();

    public Item() {

    }

    public void buyItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException, InvalidStatsException {
        String itemPrise = item + "_PRICE";
        String oldItem;
        Scanner in = new Scanner(System.in);
        if (hero.getGold() > ItemConsts.class.getDeclaredField(itemPrise).getInt(constants)) {
            hero.getListHeroItems().add(item);
            equipItem(hero, item);
            if (hero.getEquippedItems().size() > ItemConsts.MAX_EQUIPPED_ITEMS) {
                System.out.println("You have equipped too much items, which one you want to unequip from next list:");
                System.out.println(hero.getEquippedItems());
                oldItem = in.nextLine().toUpperCase();
                System.out.println();
                unEquipItem(hero, Items.valueOf(oldItem));
            }
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

    private void unEquipItem(Hero hero, Items item) throws NoSuchFieldException, IllegalAccessException, InvalidStatsException {
        String itemDamage = item + "_ADD_DAMAGE";
        String itemArmor = item + "_ADD_ARMOR";
        String itemMagic = item + "_ADD_MAGIC";

        if (hero.getEquippedItems().contains(item)) {
            hero.setAttackDamage(hero.getAttackDamage() - ItemConsts.class.getDeclaredField(itemDamage).getInt(constants));
            hero.setArmor(hero.getArmor() - ItemConsts.class.getDeclaredField(itemArmor).getInt(constants));
            hero.setApDamage(hero.getApDamage() - ItemConsts.class.getDeclaredField(itemMagic).getInt(constants));
        }
        hero.getEquippedItems().remove(item);
    }

    public void listItem() throws NoSuchFieldException, IllegalAccessException {
        System.out.println("Available Items: ");
        System.out.println("-------------------------------------");
        int itemNumber = 1;
        for (Items item : Items.values()) {
            System.out.print(itemNumber + "\t" + item.toString() + "\t");
            if (item.toString().length() < 17) {
                System.out.print("\t");
            }
            System.out.print("\tATTACK DAMAGE:+" + (ItemConsts.class.getDeclaredField(item + "_ADD_DAMAGE").getInt(constants)));
            System.out.print("\tABILITY POWER:+" + (ItemConsts.class.getDeclaredField(item + "_ADD_MAGIC").getInt(constants)));
            System.out.print("\t\tARMOR:+" + (ItemConsts.class.getDeclaredField(item + "_ADD_ARMOR").getInt(constants)));
            System.out.print("\t\tPRICE:" + (ItemConsts.class.getDeclaredField(item + "_PRICE").getInt(constants)));
            System.out.println();
            itemNumber++;
        }
    }

}