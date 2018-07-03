import com.lol.Hero;
import com.lol.Nashor;

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
    }
}
