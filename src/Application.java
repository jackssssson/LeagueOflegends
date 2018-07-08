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

            }
            if (enemy == 2) {
                fightCreatures(player, creep, drake, nashor);

            } else {
                System.out.println("Invalid enemy selection");
            }
        }


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
            doncho.normalAttack(doncho, player);
            System.out.println(doncho + " attacked with Normal attack for " + doncho.getAttackDamage() + " damage!");

            if (player.getHealth() > 0 && doncho.getHealth() > 0) {
                System.out.println();
                System.out.println("Player stats after round " + round + ":");
                player.printHeroStats();
                doncho.printHeroStats();
                round++;
            }

        }
    }

    private static void fightCreatures(Hero player, Creatures creep, Creatures drake, Creatures nashor) throws InvalidStatsException {
        System.out.println("Hello player , you are about to face some dangerous creatures !!");
        System.out.println("You have chosen " + player.getName() + " to fight for you.");
        System.out.println("In this mode , in order to win you have to defeat all Creatures in the game");
        System.out.println("BEWARE, A CREEP IS APPROACHING!!");
        int round = 1;
        while (creep.getHealth() > 0) {
            System.out.println("Round " + round + " - FIGHT!");
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1+Enter to attack ");
            System.out.println();
            int chosenAttack = in.nextInt();
            if (chosenAttack == 1) {
                player.heroAttackCreep((Creeps) creep);
                creep.attackHeroes(player);
                if (player.getHealth() > 0 && creep.getHealth() > 0) {
                    System.out.println("Creep attacked " + player.getName() + " for " + creep.getAttackDamage());
                    System.out.println();
                    System.out.println("Player and creep stats after round " + round + ":");
                    player.printHeroStats();
                    System.out.println("CREEP HEALTH: " + creep.getHealth());
                    round++;
                }
            } else {
                System.out.println("You need to defend yourself, press 1 + Enter");
            }


        }
        System.out.println("Congratulations, you have defeated the first creature!!");
        System.out.println();
        System.out.println("Now you must face the mighty Mountain Drake");
        round = 1;
        while (drake.getHealth() > 0) {
            System.out.println("Round " + round + " - FIGHT!");
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 and Enter to attack. ");
            System.out.println();
            int chosenAttack = in.nextInt();
            if (chosenAttack == 1) {
                player.heroAttackDrake((Drake) drake);
                drake.attackHeroes(player);
                if (player.getHealth() > 0 && drake.getHealth() > 0) {
                    System.out.println(player.getName() + "Attacked drake for " + player.getAttackDamage() + ",but Drake absorbed some damage!");
                    System.out.println("Drake attacked " + player.getName() + " for " + drake.getAttackDamage() + ",but " + player.getName() + " absorbed some damage!");
                    System.out.println();
                    System.out.println("Player and Drake stats after round: " + round + ":");
                    player.printHeroStats();
                    System.out.println("DRAKE HEALTH:\t " + drake.getHealth());
                    round++;
                }
            } else {
                System.out.println("You need to defend yourself, press 1 + Enter");
            }


        }
        System.out.println();
        System.out.println("Good JOB! Now you must face the final boss - BARON NASHOR");
        round = 1;
        while (nashor.getHealth() > 0) {
            System.out.println("Round " + round + " - FIGHT!");
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 and Enter to attack. ");
            System.out.println();
            int chosenAttack = in.nextInt();
            if (chosenAttack == 1) {
                player.heroAttackNashor((Nashor) nashor);
                drake.attackHeroes(player);
                if (player.getHealth() > 0 && nashor.getHealth() > 0) {
                    System.out.println(player.getName() + "Attacked Nashor for " + player.getAttackDamage() + ",but Nashor absorbed some damage!");
                    System.out.println("Nashor attacked " + player.getName() + " for " + nashor.getAttackDamage() + ",but " + player.getName() + " absorbed some damage!");
                    System.out.println();
                    System.out.println("Player and Nashor stats after round: " + round + ":");
                    player.printHeroStats();
                    System.out.println("Nashor HEALTH:\t " + nashor.getHealth());
                    round++;
                }
            } else {
                System.out.println("You need to defend yourself, press 1 + Enter");
            }


        }

    }
}
