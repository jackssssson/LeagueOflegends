import com.lol.*;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException {

       //Scanner in = new Scanner(System.in);

       //String Heroes = "Ahri Jarvan Zed Lucian Pantheon";
       //String[] HeroesList = Heroes.split(" ");

       //System.out.println("Available Heros: " + Arrays.toString(HeroesList));
       //System.out.print("Choose your hero: ");
       //String ChosenHero = in.nextLine().toUpperCase();


       //Hero zed = new Hero(ChosenHero);
       //zed.setIsDead(true);
       //System.out.println(zed.toString());
       //zed.heroRevive(zed);
       //System.out.println(zed.toString());

        //heroAttackDrake
        /*
        Hero zed = new Hero("zed");
        Creatures drake = new Drake("Mountain");
        System.out.println(zed.getHeroSpeed());
        System.out.println(zed.getAttackDamage());
        System.out.println(zed.getArmor());
        //Hero zed = new Hero(ChosenHero);
        System.out.println(zed.getHealth());

        for (int i = 0; i < 250; i++){
            zed.heroAttackDrake((Drake) drake);
            if (drake.getHealth() <= 0){
                break;
            }
            System.out.println(drake.getHealth());
        }

        System.out.println(zed.getHeroSpeed());
        System.out.println(zed.getAttackDamage());
        System.out.println(zed.getArmor());
        System.out.println(zed.getHealth());
        drake = drake.creatureRespawn(drake);
        System.out.println(drake.getName());
        System.out.println(drake.getHealth());
        */

        //heroAttackNashor
        /*
        Hero zed = new Hero("zed");
        Creatures nashor = new Nashor();
        System.out.println(zed.getGold());

        for (int i = 0; i < 1000; i++){
            zed.heroAttackNashor((Nashor) nashor);
            if (nashor.getHealth() <= 0){
                break;
            }
            System.out.println(nashor.getHealth());
        }

        System.out.println(zed.getGold());
        nashor = nashor.creatureRespawn(nashor);
        System.out.println(nashor.getHealth());
        */

        //heroAttackCreep
        /*
        Hero zed = new Hero("zed");
        Creatures creep = new Creeps();
        System.out.println(zed.getGold());

        for (int i = 0; i < 1000; i++){
            zed.heroAttackCreep((Creeps) creep);
            if (creep.getHealth() <= 0){
                break;
            }
            System.out.println(creep.getHealth());
        }

        System.out.println(zed.getGold());
        creep = creep.creatureRespawn(creep);
        System.out.println(creep.getHealth());
        */

        //creepAttackHero
        /*
        Hero zed1 = new Hero("zed");
        Creatures creep = new Creeps();

        for (int i = 0; i < 250; i++){
            creep.attackHeroes(zed1);
            if (zed1.getHealth() <= 0){
                break;
            }
            System.out.println(zed1.getHealth());
        }
        */

        //heroRevive
        //zed1.heroRevive(zed1);
        //System.out.println(zed1.getHealth());

        //nashorAttackHero
        /* Hero zed = new Hero("zed");
        Creatures nashor = new Nashor();

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
        Creatures drake = new Drake("Mountain");

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
//        Item newItem = new Item();
//        newItem.buyItem(zed, Items.BILGWATER_CUTLASS);
//        newItem.buyItem(zed, Items.AEGIS_OF_THE_LEGION);
//        newItem.buyItem(zed, Items.DORANS_SHIELD);
//        System.out.println("After byu Items - zed AttackDamage:"+zed.getAttackDamage()+", zed armor:"+zed.getArmor()+"  zed Gold:"+zed.getGold());
//        System.out.println(zed.getEquippedItems());
//        System.out.println(zed.getListHeroItems());


    }
}
