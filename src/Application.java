import com.lol.*;

import java.util.Arrays;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {

        Scanner in = new Scanner(System.in);

        String Heroes = "Ahri Jarvan Zed Lucian Pantheon";
        String[] HeroesList = Heroes.split(" ");

        System.out.println("Available Heroes: " + Arrays.toString(HeroesList));
        System.out.print("Choose your hero: ");
        String ChosenHero = in.nextLine().toUpperCase();

        Hero hero = new Hero(ChosenHero);
        /*
        Creatures creep = new Creeps();
        Creatures drake = new Drake("Mountain");
        Creatures nashor = new Nashor();

        //heroAttackDrake

        System.out.println(hero.getName() + " speed before attack drake " + hero.getHeroSpeed());
        System.out.println(hero.getName() + " attackDamage before attack drake " + hero.getAttackDamage());
        System.out.println(hero.getName() + " armor before attack drake " + hero.getArmor());
        System.out.println(hero.getName() + " health before attack drake " + hero.getHealth());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 250; i++){
            hero.heroAttackDrake((Drake) drake);
            if (drake.getHealth() <= 0){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.println(drake.getName() + " health is " + drake.getHealth());
        }

        System.out.println(hero.getName() + " speed after attack drake " + hero.getHeroSpeed());
        System.out.println(hero.getName() + " attackDamage after attack drake " + hero.getAttackDamage());
        System.out.println(hero.getName() + " armor after attack drake " + hero.getArmor());
        System.out.println(hero.getName() + " health after attack drake " + hero.getHealth());
        System.out.println("-------------------------------------");

        //respawn drake
        drake = drake.creatureRespawn(drake);
        System.out.println(drake.getName() + " is respawn");
        System.out.println("-------------------------------------");


        //heroAttackNashor

        System.out.println(hero.getName() + " gold before attack Nashor is " + hero.getGold());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 1000; i++){
            hero.heroAttackNashor((Nashor) nashor);
            if (nashor.getHealth() <= 0){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.println(nashor.getName() + " health is " + nashor.getHealth());
        }

        System.out.println(hero.getName() + " gold after attack Nashor is " + hero.getGold());
        System.out.println("-------------------------------------");

        //respawn nashor
        nashor = nashor.creatureRespawn(nashor);
        System.out.println(nashor.getName() + " is respawn");
        System.out.println("-------------------------------------");


        //heroAttackCreep

        System.out.println(hero.getName() + " gold before attack creep is " + hero.getGold());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 1000; i++){
            hero.heroAttackCreep((Creeps) creep);
            if (creep.getHealth() <= 0){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.println(creep.getName() + " health is " + creep.getHealth());
        }

        System.out.println(hero.getName() + " gold after attack creep is " + hero.getGold());
        System.out.println("-------------------------------------");

        //respawn creep

        creep = creep.creatureRespawn(creep);
        System.out.println(creep.getName() + " is respawn");
        System.out.println("-------------------------------------");


        //creepAttackHero

        System.out.println(hero.getName() + " health before creep attack him " + hero.getHealth());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 250; i++){
            creep.attackHeroes(hero);
            if (hero.getHealth() <= 0){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.println(hero.getName() + " health after creep attack him " + hero.getHealth());
        }


        //heroRevive

        hero.heroRevive(hero);
        System.out.println(hero.getName() + " is revive");
        System.out.println("-------------------------------------");


        //nashorAttackHero

        System.out.println(hero.getName() + " health before nashor attack him " + hero.getHealth());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 250; i++){
            nashor.attackHeroes(hero);
            if (hero.getHealth() <= 0){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.println(hero.getName() + " health after nashor attack him " + hero.getHealth());
        }

        //heroRevive

        hero.heroRevive(hero);
        System.out.println(hero.getName() + " is revive");
        System.out.println("-------------------------------------");


        //drakeAttackHero

        System.out.println(hero.getName() + " health before drake attack him " + hero.getHealth());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 250; i++){
            drake.attackHeroes(hero);
            if (hero.getHealth() <= 0){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.println(hero.getName() + " health after drake attack him " + hero.getHealth());
        }


        //heroRevive

        hero.heroRevive(hero);
        System.out.println(hero.getName() + " is revive");
        System.out.println("-------------------------------------");



        //normalAttack

        System.out.println("Available Heroes: " + Arrays.toString(HeroesList));
        System.out.print("Choose your hero: ");
        Hero enemyHeroNormalAttack = new Hero(in.nextLine().toUpperCase());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 250; i++){
            hero.normalAttack(hero, enemyHeroNormalAttack);
            if (enemyHeroNormalAttack.getIsDead()){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.printf("%s health after %s attack him with normal attack is %s\n",
                    enemyHeroNormalAttack.getName(),  hero.getName(), enemyHeroNormalAttack.getHealth());
        }


        //magicAttack

        System.out.println("Available Heroes: " + Arrays.toString(HeroesList));
        System.out.print("Choose your hero: ");
        Hero enemyHeroMagicAttack = new Hero(in.nextLine().toUpperCase());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 250; i++){
            hero.magicAttack(hero, enemyHeroMagicAttack);
            if (enemyHeroMagicAttack.getIsDead()){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.printf("%s health after %s attack him with magic attack is %s\n",
                    enemyHeroMagicAttack.getName(),  hero.getName(), enemyHeroMagicAttack.getHealth());
        }


        //ultimateAttack
        System.out.println("Available Heroes: " + Arrays.toString(HeroesList));
        System.out.print("Choose your hero: ");
        Hero enemyHeroUltimateAttack = new Hero(in.nextLine().toUpperCase());
        System.out.println("-------------------------------------");

        for (int i = 0; i < 250; i++){
            hero.magicAttack(hero, enemyHeroUltimateAttack);
            if (enemyHeroUltimateAttack.getIsDead()){
                System.out.println("-------------------------------------");
                break;
            }
            System.out.printf("%s health after %s attack him with ultimate attack is %s\n",
                    enemyHeroUltimateAttack.getName(),  hero.getName(), enemyHeroUltimateAttack.getHealth());
        }
        */


        //items


        Item newItem = new Item();
       // Hero hero = new Hero("zed");
        newItem.listItem();
        System.out.print("Choose items to buy (when you are ready press enter): ");
        String[] chosenItems = in.nextLine().toUpperCase().split(" ");
        String oldItem = "";

        //buy and equip new items

        for (String item : chosenItems) {
            for(Items items: Items.values()){
                if(item.equals(items.toString())) {          //verification of the selected item are exists in enum
                    newItem.buyItem(hero, items, oldItem);
                }
            }
        }
        System.out.println(hero.toString());
        newItem.buyItem(hero, Items.BILGWATER_CUTLASS, "" );
        System.out.println(hero.getListHeroItems());
        System.out.println(hero.getEquippedItems());
        System.out.println(hero.toString());
        Item item = new Item(Items.HUNTERS_MACHETE);
        System.out.println(item);


    }
}
