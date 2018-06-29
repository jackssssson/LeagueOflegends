import com.lol.Hero;

public class Application {
    public static void main(String[] args) {
        Hero hero = new Hero(500, 400, 100, 20, 400, 300);


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

        // Hello world
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


    }
}
