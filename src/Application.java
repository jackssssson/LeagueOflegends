import com.lol.*;

import java.util.Arrays;
import java.util.Scanner;


public class Application {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException {

        Scanner in = new Scanner(System.in);

        String Heroes = "Ahri Jarvan Zed Lucian Pantheon";
        String[] HeroesList = Heroes.split(" ");

        System.out.println("Available Heros: " + Arrays.toString(HeroesList));
        System.out.print("Choose your hero: ");
        String ChosenHero = in.nextLine().toUpperCase();


        Hero zed = new Hero(ChosenHero);
        Nashor nashor = new Nashor();
        System.out.println(zed.getHealth());
        nashor.attackHeroes(zed);
        System.out.println(zed.getHealth());
        System.out.println(zed.getMana());

        //test

        System.out.println("Before Item Purchase - zed AttackDamage:"+zed.getAttackDamage()+", zed armor:"+zed.getArmor()+"  and zed Gold:"+zed.getGold());
        Item newItem = new Item();
        newItem.buyItem(zed, Items.HUNTERS_MACHETE);
        newItem.buyItem(zed, Items.AEGIS_OF_THE_LEGION);
        System.out.println("After Item purchase - zed AttackDamage:"+zed.getAttackDamage()+", zed armor:"+zed.getArmor()+"  zed Gold:"+zed.getGold());
        System.out.println("Zed items are: "+ zed.getListHeroItems());



    }
}
