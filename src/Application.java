import com.lol.Hero;
import com.lol.Item;
import com.lol.Items;
import com.lol.Nashor;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException {


        //Hero tests
       /* Hero Player1 = new Hero("ahri");
        System.out.println(Player1.toString());
        System.out.println(Player1.getType());
        System.out.println();

        Hero Player2 = new Hero("Jarvan");
        System.out.println(Player2.toString());
        System.out.println(Player2.getType());
        System.out.println();

        Hero Player3 = new Hero("zed");
        System.out.println(Player3.toString());
        System.out.println(Player3.getType());
        System.out.println();*/


        Hero zed = new Hero("zed");
        Nashor nashor = new Nashor();
        System.out.println(zed.getHealth());
        nashor.attackHeroes(zed);
        System.out.println(zed.getHealth());
        System.out.println(zed.getMana());

        //test


        System.out.println("Before byu Items - zed AttackDamage:"+zed.getAttackDamage()+", zed armor:"+zed.getArmor()+"  and zed Gold:"+zed.getGold());
        Item newItem = new Item();
        newItem.buyItem(zed, Items.HUNTERS_MACHETE);
        newItem.buyItem(zed, Items.AEGIS_OF_THE_LEGION);
        System.out.println("After byu Items - zed AttackDamage:"+zed.getAttackDamage()+", zed armor:"+zed.getArmor()+"  zed Gold:"+zed.getGold());
        System.out.println(zed.getListHeroItems());
        //


    }
}
