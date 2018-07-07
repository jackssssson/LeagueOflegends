package com.lol;

import java.util.Scanner;

public class Item {

    private ItemConsts constants = new ItemConsts();

    @Override
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

    public String buyItem(Hero hero, Items item, String oldItem) throws NoSuchFieldException, IllegalAccessException, InvalidStatsException {
        String itemPrise = item + "_PRICE";
        Scanner in = new Scanner(System.in);
        if (hero.getGold() > ItemConsts.class.getDeclaredField(itemPrise).getInt(constants)) {
            hero.getListHeroItems().add(item);
            equipItem(hero, item);
            if (hero.getEquippedItems().size() > ItemConsts.MAX_EQUIPPED_ITEMS) {
                System.out.println("You have equipped too much item, which one you want to unequipp from next list:");
                System.out.println(hero.getEquippedItems());
                oldItem = in.nextLine();
                unEquipItem(hero, Items.valueOf(oldItem));
            }
            hero.setGold(hero.getGold() - ItemConsts.class.getDeclaredField(itemPrise).getInt(constants));
        }
        return "";
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

        for (Items item : Items.values()) {
            System.out.print(item.toString() + "\t");
            if (item.toString().length() < 17) {
                System.out.print("\t");
            }
            System.out.print("\tAdd damage:" + (ItemConsts.class.getDeclaredField(item + "_ADD_DAMAGE").getInt(constants)));
            System.out.print("\tAdd magic:" + (ItemConsts.class.getDeclaredField(item + "_ADD_MAGIC").getInt(constants)));
            System.out.print("\t\tAdd armor:" + (ItemConsts.class.getDeclaredField(item + "_ADD_ARMOR").getInt(constants)));
            System.out.print("\t\tPrice:" + (ItemConsts.class.getDeclaredField(item + "_PRICE").getInt(constants)));
            System.out.println();
        }
    }

    public void setStats(Items item) throws NoSuchFieldException, IllegalAccessException {
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

    public Items getName() {
        return name;
    }

    public void setName(Items name) {
        this.name = name;
    }
}
