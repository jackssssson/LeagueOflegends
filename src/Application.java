import com.lol.Creeps;
import com.lol.Drake;
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

        //heroAttackDrake
        /* Hero zed = new Hero("zed");
        Drake drake = new Drake("Mountain");
        System.out.println(zed.getHeroSpeed());
        System.out.println(zed.getAttackDamage());
        System.out.println(zed.getArmor());
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
    }
}
