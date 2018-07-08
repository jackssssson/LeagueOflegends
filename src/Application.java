import com.lol.*;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {

        Hero hero = new Hero("Pantheon");
        Creatures creep = new Creeps();
        Creatures drake = new Drake("Mountain");
        Creatures nashor = new Nashor();
        Item Store = new Item();
        String Heroes = "Ahri Jarvan Zed Lucian Pantheon";
        String[] HeroesList = Heroes.split(" ");


        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to League of legends!!");
        System.out.println("To start a game write ready");
        String readyCheck = in.nextLine();
        if (readyCheck.equals("ready")) {
            //user chooses a Hero from a list of heroes
            System.out.println("Your first step is to select a Hero");
            String playerSelection = HeroesList[chooseHero()];
            Hero player = new Hero(playerSelection);
            System.out.println("You have selected " + player.getName());

            //user buys 3 items for his hero
            selectItems(Store, player);


            System.out.println("Now you must choose your enemy");
            System.out.println("To fight player Doncho - press 1");
            System.out.println("To fight against Creatures - press 2");
            int enemy = in.nextInt();

            if (enemy == 1) {
                fightDoncho(player, hero);

             }if(enemy==2){
                fightCreatures(player,creep,drake,nashor);

            } else {
                System.out.println("Invalid enemy selection");
            }
        }


    }

    public void commennt() {
//
//        //heroAttackDrake
//
//        System.out.println(hero.getName() + " speed before attack drake " + hero.getHeroSpeed());
//        System.out.println(hero.getName() + " attackDamage before attack drake " + hero.getAttackDamage());
//        System.out.println(hero.getName() + " armor before attack drake " + hero.getArmor());
//        System.out.println(hero.getName() + " health before attack drake " + hero.getHealth());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 250; i++){
//            hero.heroAttackDrake((Drake) drake);
//            if (drake.getHealth() <= 0){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.println(drake.getName() + " health is " + drake.getHealth());
//        }
//
//        System.out.println(hero.getName() + " speed after attack drake " + hero.getHeroSpeed());
//        System.out.println(hero.getName() + " attackDamage after attack drake " + hero.getAttackDamage());
//        System.out.println(hero.getName() + " armor after attack drake " + hero.getArmor());
//        System.out.println(hero.getName() + " health after attack drake " + hero.getHealth());
//        System.out.println("-------------------------------------");
//
//        //respawn drake
//        drake = drake.creatureRespawn(drake);
//        System.out.println(drake.getName() + " is respawn");
//        System.out.println("-------------------------------------");
//
//
//        //heroAttackNashor
//
//        System.out.println(hero.getName() + " gold before attack Nashor is " + hero.getGold());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 1000; i++){
//            hero.heroAttackNashor((Nashor) nashor);
//            if (nashor.getHealth() <= 0){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.println(nashor.getName() + " health is " + nashor.getHealth());
//        }
//
//        System.out.println(hero.getName() + " gold after attack Nashor is " + hero.getGold());
//        System.out.println("-------------------------------------");
//
//        //respawn nashor
//        nashor = nashor.creatureRespawn(nashor);
//        System.out.println(nashor.getName() + " is respawn");
//        System.out.println("-------------------------------------");
//
//
//        //heroAttackCreep
//
//        System.out.println(hero.getName() + " gold before attack creep is " + hero.getGold());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 1000; i++){
//            hero.heroAttackCreep((Creeps) creep);
//            if (creep.getHealth() <= 0){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.println(creep.getName() + " health is " + creep.getHealth());
//        }
//
//        System.out.println(hero.getName() + " gold after attack creep is " + hero.getGold());
//        System.out.println("-------------------------------------");
//
//        //respawn creep
//
//        creep = creep.creatureRespawn(creep);
//        System.out.println(creep.getName() + " is respawn");
//        System.out.println("-------------------------------------");
//
//
//        //creepAttackHero
//
//        System.out.println(hero.getName() + " health before creep attack him " + hero.getHealth());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 250; i++){
//            creep.attackHeroes(hero);
//            if (hero.getHealth() <= 0){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.println(hero.getName() + " health after creep attack him " + hero.getHealth());
//        }
//
//
//        //heroRevive
//
//        hero.heroRevive(hero);
//        System.out.println(hero.getName() + " is revive");
//        System.out.println("-------------------------------------");
//
//
//        //nashorAttackHero
//
//        System.out.println(hero.getName() + " health before nashor attack him " + hero.getHealth());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 250; i++){
//            nashor.attackHeroes(hero);
//            if (hero.getHealth() <= 0){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.println(hero.getName() + " health after nashor attack him " + hero.getHealth());
//        }
//
//        //heroRevive
//
//        hero.heroRevive(hero);
//        System.out.println(hero.getName() + " is revive");
//        System.out.println("-------------------------------------");
//
//
//        //drakeAttackHero
//
//        System.out.println(hero.getName() + " health before drake attack him " + hero.getHealth());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 250; i++){
//            drake.attackHeroes(hero);
//            if (hero.getHealth() <= 0){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.println(hero.getName() + " health after drake attack him " + hero.getHealth());
//        }
//
//
//        //heroRevive
//
//        hero.heroRevive(hero);
//        System.out.println(hero.getName() + " is revive");
//        System.out.println("-------------------------------------");
//
//
//
//        //normalAttack
//
//        System.out.println("Available Heroes: " + Arrays.toString(HeroesList));
//        System.out.print("Choose your hero: ");
//        Hero enemyHeroNormalAttack = new Hero(in.nextLine().toUpperCase());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 250; i++){
//            hero.normalAttack(hero, enemyHeroNormalAttack);
//            if (enemyHeroNormalAttack.getIsDead()){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.printf("%s health after %s attack him with normal attack is %s\n",
//                    enemyHeroNormalAttack.getName(),  hero.getName(), enemyHeroNormalAttack.getHealth());
//        }
//
//
//        //magicAttack
//
//        System.out.println("Available Heroes: " + Arrays.toString(HeroesList));
//        System.out.print("Choose your hero: ");
//        Hero enemyHeroMagicAttack = new Hero(in.nextLine().toUpperCase());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 250; i++){
//            hero.magicAttack(hero, enemyHeroMagicAttack);
//            if (enemyHeroMagicAttack.getIsDead()){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.printf("%s health after %s attack him with magic attack is %s\n",
//                    enemyHeroMagicAttack.getName(),  hero.getName(), enemyHeroMagicAttack.getHealth());
//        }
//
//
//        //ultimateAttack
//        System.out.println("Available Heroes: " + Arrays.toString(HeroesList));
//        System.out.print("Choose your hero: ");
//        Hero enemyHeroUltimateAttack = new Hero(in.nextLine().toUpperCase());
//        System.out.println("-------------------------------------");
//
//        for (int i = 0; i < 250; i++){
//            hero.ultimateAttack(hero, enemyHeroUltimateAttack);
//            if (enemyHeroUltimateAttack.getIsDead()){
//                System.out.println("-------------------------------------");
//                break;
//            }
//            System.out.printf("%s health after %s attack him with ultimate attack is %s\n",
//                    enemyHeroUltimateAttack.getName(),  hero.getName(), enemyHeroUltimateAttack.getHealth());
//        }
//
//
//        //items
//
//        Item newItem = new Item();
//        newItem.listItem();
//        System.out.println("-------------------------------------");
//        System.out.println("You have "+ hero.getGold()+" gold.");
//        System.out.println(hero.getName() + " stats before buy items is: damage "+ hero.getAttackDamage()+", armor "+hero.getArmor()+", magic "+hero.getApDamage());
//        System.out.println("You can't equip more than 4 items, but you can buy more. Choose items to buy (when you are ready press enter): ");
//        System.out.println("HUNTERS_MACHETE BILGWATER_CUTLASS AEGIS_OF_THE_LEGION DORANS_SHIELD ARCANE_SWEEPER");
//        String[] chosenItems = in.nextLine().toUpperCase().split(" ");
//        System.out.println("-------------------------------------");
//
//        //buy and equip new items
//
//        for (String item : chosenItems) {
//            for (Items items : Items.values()) {
//                if (item.equals(items.toString())) {
//                    newItem.buyItem(hero, items);
//                }
//            }
//        }
//
//        System.out.println("-------------------------------------");
//        System.out.println("You left "+ hero.getGold()+" gold, after shopping.");
//        System.out.println(hero.getName() + " stats after buy items is: damage "+ hero.getAttackDamage()+", armor "+hero.getArmor()+", magic "+hero.getApDamage());
//        System.out.println("The items that you have are: ");
//        System.out.println(hero.getListHeroItems());
//        System.out.println("The items that you are equipped are: ");
//        System.out.println(hero.getEquippedItems());
//        System.out.println("-------------------------------------");
//
    }

    private static int chooseHero() throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {

        Scanner in = new Scanner(System.in);
        Hero hero = new Hero("Pantheon");
        hero.listHeroes();
        System.out.print("To choose your hero , enter it's number and press Enter! ");
        return in.nextInt() - 1;


    }

    private static void selectItems(Item Store, Hero player) throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {
        System.out.println();
        Scanner in = new Scanner(System.in);
        System.out.println("Your second step is to buy your hero some equipment, select your items from the store: ");
        Store.listItem();
        System.out.println("To buy an item - enter it's number and press Enter , you are allowed to buy up to 3 items");
        for (int i = 0; i < 3; i++) {
            System.out.println("Select an item from the list:");
            int selectedItem = in.nextInt();
            switch (selectedItem) {
                case 1:
                    Store.buyItem(player, Items.HUNTERS_MACHETE);
                    break;
                case 2:
                    Store.buyItem(player, Items.BILGWATER_CUTLASS);
                    break;
                case 3:
                    Store.buyItem(player, Items.AEGIS_OF_THE_LEGION);
                    break;
                case 4:
                    Store.buyItem(player, Items.DORANS_SHIELD);
                    break;
                case 5:
                    Store.buyItem(player, Items.ARCANE_SWEEPER);
                    break;

                default:
                    System.out.println("Invalid item number");
            }
            System.out.println("You have " + player.getGold() + " gold left");
        }
        System.out.println("You have equipped: ");
        System.out.print(player.getEquippedItems());
        System.out.println();
        System.out.println("Your updated hero stats are: ");
        player.printHeroStats();
        System.out.println();
    }

    private static void fightDoncho(Hero player, Hero doncho) throws InvalidStatsException {
        System.out.println("Your hero has 3 attacks: Normal , Magic and Ultimate Attack");
        System.out.println("To attack with each spell in the following order , press 1,2 or 3 and hit Enter!");
        int round = 1;
        while (doncho.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("Round " + round + " - FIGHT!");
            Scanner in = new Scanner(System.in);
            System.out.println("Choose your attack");
            System.out.println();
            int chosenAttack = in.nextInt();
            switch (chosenAttack) {
                case 1:
                    player.normalAttack(player, doncho);
                    break;
                case 2:
                    player.magicAttack(player, doncho);
                    break;
                case 3:
                    player.ultimateAttack(player, doncho);
                    break;

            }
            if (player.getHealth() > 0 && doncho.getHealth() > 0) {
                System.out.println();
                System.out.println("Player stats after round " + round + ":");
                player.printHeroStats();
                doncho.printHeroStats();
                round++;
            }

        }
    }

    private static void fightCreatures(Hero player , Creatures creep, Creatures drake , Creatures nashor){
        System.out.println("Hello player , you are about to face some dangerous creatures !!");
        System.out.println("You have chosen "+player.getName()+" to fight for you.");
        System.out.println("In this mode , in order to win you have to defeat all Creatures in the game");
        System.out.println("Beware!! CREEPS ARE APPROACHING! To attack them press 1 and hit Enter");
        System.out.println("Creep Health "+creep.getHealth());
        System.out.println("Drake Health "+drake.getHealth());
        System.out.println("Nashor Health "+nashor.getHealth());
    }
}
