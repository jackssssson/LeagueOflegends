import com.lol.*;

public class Application {
    public static void main(String[] args) {

        //Hero ahri = new Ahri();
        //Drake drake = new Drake();
        //Creeps creeps = new Creeps();
        //Nashor nashor = new Nashor();


        //for (int i = 0; i < 10; i++){
        //    drake.attackHeroes(ahri);

        Hero Ahri = new Ahri();
        Hero Jarvan = new Jarvan();
        Ahri.normalAttack(Ahri,Jarvan);
        Ahri.magicAttack(Ahri, Jarvan);
        Jarvan.ultimateAttack(Jarvan, Ahri);


        //test Rumi

        System.out.println("Before byu Hunters Machete - Ahri AttackDamage:"+Ahri.getAttackDamage()+"  Ahri Gold:"+Ahri.getGold());

        Items newitem = Items.HUNTERS_MACHETE;
        Item.buyItem(Ahri, newitem);

        System.out.println("After byu Hunters Machete - Ahri AttackDamage:"+Ahri.getAttackDamage()+"  Ahri Gold:"+Ahri.getGold());


        // tests


        //    System.out.println(ahri.getHealth());
        //}

        //for (int i = 0; i < 30; i++){
        //    creeps.attackHeroes(ahri);

        //    System.out.println(ahri.getHealth());
        //}

        //for (int i = 0; i < 3; i++){
        //    nashor.attackHeroes(ahri);

        //    System.out.println(ahri.getHealth());
        //}










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
