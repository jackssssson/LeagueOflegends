import com.lol.Hero;

public class Application {
    public static void main(String[] args)throws NoSuchFieldException,
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






        // tests


//        int CriticalChance = 99;
//        int r = (int) (Math.random() * (100 - 1)) + 1;
//
//        if(r < CriticalChance){
//
//
//
//        }












        //Hero hero = new Hero(500, 400, 100, 20, 400, 300);



        // hero.heroAttackNashor();
        /*
        for (int i = 0; i < 200; i++){
            hero.heroAttackNashor();

            if (hero.getGold() != 400){
                System.out.println("Hero gold = " + hero.getGold() + "!");
                System.out.println("Hero killed nashor with " + (i + 1) + " hits!");
                break;
            }

            System.out.println("Hero gold at " + (i + 1) + " hit is " + hero.getGold());
        }
        */


        // heroAttackAnotherHero();
        /*
        Hero darius = new Hero(500, 400, 100, 20, 400, 300);
        Hero morgana = new Hero(500, 400, 100, 20, 400, 300);

        Hero darius = new Hero(500, 400, 100, 20, 400, 300);
        Hero morgana = new Hero(500, 400, 100, 20, 400, 300);

        for (int i = 0; i < 5; i++) {
            morgana.setHealth(darius.heroAttackAnotherHero(darius, morgana));

            if (morgana.getHealth() <= 0) {
                System.out.println("Morgana is dead");
                break;
            }

            System.out.println(morgana.getHealth());
        }


            System.out.println("Morgana health is " + morgana.getHealth());
        }
        */

        // nashorAttackHero();
        /*
        for (int i = 0; i < 5; i++){
            hero.nashorAttackHero();

            if (hero.getIsHeroDead()){
                System.out.println("Nashor killed hero!");
                break;
            }

            System.out.println("Hero health is " + hero.getHealth());
        }
        */

        //creepAttackHero
        /*
        for (int i = 0; i < 50; i++){
            hero.creepAttackHero();


            if (hero.getIsHeroDead()){
                System.out.println("Creep killed hero");
                break;
            }

            System.out.println("Hero health is " + hero.getHealth());
        }
        */

        //drakeAttackHero();
        /*
        for (int i = 0; i < 50; i++){
            hero.drakeAttackHero();


            if (hero.getIsHeroDead()){
                System.out.println("Drake killed hero");
                break;
            }

            System.out.println("Hero health is " + hero.getHealth());
        }
        */
    }
}
