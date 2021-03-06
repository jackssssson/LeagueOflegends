package com.lol;

import java.util.Scanner;

public class Item {

    private ItemConsts constants = new ItemConsts();

    public String toString() {
        return getName()+
                ", \taddDamage=" + getAddDamage() +
                ", \taddArmor=" + getAddArmor() +
                ", \taddMagic=" + getAddMagic() +
                ", \tprice=" + getPrice() +
                ';';
    }

    private Items name;
    private int addDamage;
    private int addArmor;
    private int addMagic;
    private int price;

    public Item()  {

    }

    public Item(Items name) throws NoSuchFieldException, IllegalAccessException{
        setName(name);
        setStats(name);
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
        int itemNumber=1;
        for (Items item : Items.values()) {
            System.out.print(itemNumber+"\t"+item.toString() + "\t");
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

    public Items stringToItems(String name){
        for (Items items : Items.values()) {
            if (name.equals(items.toString())) {
                return items;
            }
        }
        return null;
    }

    private void setStats(Items item) throws NoSuchFieldException, IllegalAccessException {
        setAddDamage(ItemConsts.class.getDeclaredField(item + "_ADD_DAMAGE").getInt(constants));
        setAddArmor(ItemConsts.class.getDeclaredField(item + "_ADD_ARMOR").getInt(constants));
        setAddMagic(ItemConsts.class.getDeclaredField(item + "_ADD_MAGIC").getInt(constants));
        setPrice(ItemConsts.class.getDeclaredField(item + "_PRICE").getInt(constants));
    }

    private int getAddDamage() {
        return addDamage;
    }

    private void setAddDamage(int addDamage) {
        this.addDamage = addDamage;
    }

    private int getAddArmor() {
        return addArmor;
    }

    private void setAddArmor(int addArmor) {
        this.addArmor = addArmor;
    }

    private int getAddMagic() {
        return addMagic;
    }

    private void setAddMagic(int addMagic) {
        this.addMagic = addMagic;
    }

    private int getPrice() {
        return price;
    }

    private void setPrice(int price) {
        this.price = price;
    }

    private Items getName() {
        return name;
    }

    private void setName(Items name) {
        this.name = name;
    }

//    System.out.println("If you want to view the characteristics of the item, type it's name: ");
//    String name = in.nextLine();
//    item = new Item(newItem.stringToItems(name));
//    System.out.println(item);

}
