import com.lol.*;
import java.util.*;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException {

        Scanner in = new Scanner(System.in);

        String Heroes = "Ahri Jarvan Zed Lucian Pantheon";
        String[] HeroesList = Heroes.split(" ");

        System.out.println("Available Heros: " + Arrays.toString(HeroesList));
        System.out.print("Choose your hero: ");
        String ChosenHero = in.nextLine().toUpperCase();


        //heroAttackDrake
        /* Hero zed = new Hero("zed");
        Drake drake = new Drake("Mountain");
        System.out.println(zed.getHeroSpeed());
        System.out.println(zed.getAttackDamage());
        System.out.println(zed.getArmor());
        Hero zed = new Hero(ChosenHero);
        Nashor nashor = new Nashor();
        System.out.println(zed.getHealth());

        for (int i = 0; i < 250; i++){
            zed.heroAttackDrake(drake);
            if (drake.getHealth() <= 0){
                break;
            }
            System.out.println(drake.getHealth());
        }

        System.out.println(zed.getHeroSpeed());
        System.out.println(zed.getAttackDamage());
        System.out.println(zed.getArmor());
        System.out.println(zed.getHealth());
        */

        //heroAttackNashor
        /*Hero zed = new Hero("zed");
        Nashor nashor = new Nashor();
        System.out.println(zed.getGold());

        for (int i = 0; i < 1000; i++){
            zed.heroAttackNashor(nashor);
            if (nashor.getHealth() <= 0){
                break;
            }
            System.out.println(nashor.getHealth());
        }

        System.out.println(zed.getGold());
        */

        //heroAttackCreep
        /* Hero zed = new Hero("zed");
        Creeps creep = new Creeps();
        System.out.println(zed.getGold());

        for (int i = 0; i < 1000; i++){
            zed.heroAttackCreep(creep);
            if (creep.getHealth() <= 0){
                break;
            }
            System.out.println(creep.getHealth());
        }

        System.out.println(zed.getGold());
        */

        //creepAttackHero
        /* Hero zed = new Hero("zed");
        Creeps creep = new Creeps();

        for (int i = 0; i < 250; i++){
            creep.attackHeroes(zed);
            if (zed.getHealth() <= 0){
                break;
            }
            System.out.println(zed.getHealth());
        }
        */

        //nashorAttackHero
        /* Hero zed = new Hero("zed");
        Nashor nashor = new Nashor();

        for (int i = 0; i < 250; i++){
            nashor.attackHeroes(zed);
            if (zed.getHealth() <= 0){
                break;
            }
            System.out.println(zed.getHealth());
        }
        */

        //drakeAttackHero
        /* Hero zed = new Hero("zed");
        Drake drake = new Drake("Mountain");

        for (int i = 0; i < 250; i++){
            drake.attackHeroes(zed);
            if (zed.getHealth() <= 0){
                break;
            }
            System.out.println(zed.getHealth());
        }
        */
        //System.out.println(zed.getMana());

        ////test

//        Hero zed = new Hero("zed");
//        System.out.println("Before byu Items - zed AttackDamage:"+zed.getAttackDamage()+", zed armor:"+zed.getArmor()+"  and zed Gold:"+zed.getGold());
        Item newItem = new Item();
//        newItem.buyItem(zed, Items.BILGWATER_CUTLASS);
//        newItem.buyItem(zed, Items.AEGIS_OF_THE_LEGION);
//        newItem.buyItem(zed, Items.DORANS_SHIELD);
//        System.out.println("After byu Items - zed AttackDamage:"+zed.getAttackDamage()+", zed armor:"+zed.getArmor()+"  zed Gold:"+zed.getGold());
//        System.out.println(zed.getEquippedItems());
//        System.out.println(zed.getListHeroItems());
//


        //Chose Items to buy

        ItemConsts constants = new ItemConsts();
        System.out.println("Available Items: ");

        for (Items item: Items.values()) {
            System.out.print(item.toString()+"\t");
            if(item.toString().length()<17){ System.out.print("\t"); }
            System.out.print("\tAdd damage:" + (ItemConsts.class.getDeclaredField(item + "_ADD_DAMAGE").getInt(constants)));
            System.out.print("\tAdd magic:" + (ItemConsts.class.getDeclaredField(item + "_ADD_MAGIC").getInt(constants)));
            System.out.print("\t\tAdd armor:" + (ItemConsts.class.getDeclaredField(item + "_ADD_ARMOR").getInt(constants)));
            System.out.print("\t\tPrice:" + (ItemConsts.class.getDeclaredField(item + "_PRICE").getInt(constants)));
            System.out.println();
        }
        System.out.print("Choose items to buy (when you are ready press enter): ");
        String[] chosenItems = in.nextLine().toUpperCase().split(" ");
        Hero hero = new Hero("zed");

        //equip new items

        for (String item : chosenItems) {
            for(Items items: Items.values()){
                if(item.equals(items.toString())) {          //verification of the selected item are exists in enum
                    newItem.buyItem(hero, items);
                }
            }
        }
        System.out.println(hero.getListHeroItems());
        System.out.println(hero.getEquippedItems());
        System.out.println(hero.getAttackDamage()+" "+hero.getArmor()+" "+hero.getApDamage()+" "+hero.getGold());
    }
}
