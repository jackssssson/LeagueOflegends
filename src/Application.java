import com.lol.*;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {
        String drakes = "Mountain Infernal Ocean Elder Cloud";
        String[]drakeList = drakes.split(" ");
        Creatures creep = new Creeps();
        Creatures nashor = new Nashor();
        Item Store = new Item();
        String Heroes = "Ahri Jarvan Zed Lucian Pantheon";
        String[] HeroesList = Heroes.split(" ");

        //Creates random hero for Doncho
        Random rand = new Random();
        int min = 1;
        int max = HeroesList.length;
        int randomNum = rand.nextInt((max - min) + 1) + min;
        Creatures drake = new Drake(drakeList[randomNum-1]);
        Hero hero = new Hero(HeroesList[randomNum - 1]);

        //checks if the player is ready
        boolean readyChecker = readyCheck();


        if (readyChecker) {
            //User selects a Hero from the HeroesList
            System.out.println("Your first step is to select a Hero");
            hero.listHeroes();
            String playerSelection = HeroesList[chooseHero()];
            Hero player = new Hero(playerSelection);
            System.out.println("You have selected " + player.getName());

            //User selects,buys and equips 3 items from the ItemList
            selectItems(Store, player);

            //Select an Enemy
            int enemy = chooseEnemy();

            if (enemy == 1) {
                System.out.println("Doncho chooses " + hero.getName() + " to fight for him!");
                fightDoncho(player, hero);
                return;
            }
            if (enemy == 2) {
                fightCreatures(player, creep, drake, nashor);
            }

        }


    }


    private static boolean readyCheck() {
        Scanner in = new Scanner(System.in);
        boolean isReady = false;
        System.out.println("Welcome to League of legends!!");
        System.out.println("To start a game write \"ready\" ");
        int readyCount = 0;
        String readyCheck = in.nextLine();
        while (!readyCheck.equals("ready")) {
            try {
                System.out.println("To start a game write \"ready\". ");
                System.out.println("Check if you are spelling \"ready\" correct. ");
                readyCheck = in.nextLine();

            } catch (InputMismatchException e) {
                in.next();
            }
            readyCount++;
            if (readyCount >= 3) {
                System.out.println("I guess you were never ready for this game :/");
                return false;
            }

        }
        if (readyCheck.equals("ready")) {
            isReady = true;
        }

        return isReady;
    }

    private static int chooseHero() {
        Scanner in = new Scanner(System.in);
        System.out.println("To choose your hero , enter it's number and press Enter! ");
        int selectedHero = getAnInteger();
        while (selectedHero > 5) {
            try {
                System.out.println("There is no such Hero.");
                System.out.println("Please choose a number from the list to continue. ");
                selectedHero = in.nextInt();

            } catch (InputMismatchException e) {
                in.next();
                System.out.print("It seems like you did not enter a number buddy! ");

            }


        }

        return selectedHero - 1;


    }

    private static void selectItems(Item Store, Hero player) throws NoSuchFieldException,
            IllegalAccessException, InvalidStatsException {
        Scanner in = new Scanner(System.in);
        System.out.println();
        System.out.println("Your second step is to buy your hero some equipment, select your items from the store: ");
        Store.listItem();
        System.out.println("To buy an item - enter it's number and press Enter , you are allowed to buy up to 3 items");
        for (int i = 0; i < 3; i++) {
            System.out.println("Select an item from the list:");
            int selectedItem = getAnInteger();
            while (selectedItem > 5) {
                try {
                    System.out.println("There is no such Item.");
                    System.out.println("Please choose a number from the list to continue. ");
                    selectedItem = in.nextInt();

                } catch (InputMismatchException e) {
                    in.next();
                    System.out.print("It seems like you did not enter a number buddy! ");

                }


            }
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

    private static int chooseEnemy() {
        Scanner in = new Scanner(System.in);
        System.out.println("Now you must choose your enemy");
        System.out.println("To fight player Doncho - press 1");
        System.out.println("To fight against Creatures - press 2");
        int enemy = getAnInteger();
        while (enemy > 2) {
            try {
                System.out.println("Please Press 1 or 2 to continue");
                enemy = in.nextInt();

            } catch (InputMismatchException e) {
                in.next();
                System.out.print("It seems like you did not enter a correct number buddy! ");
                System.out.println("Please press 1 or 2 to continue ");
            }

        }
        return enemy;
    }

    private static void fightDoncho(Hero player, Hero doncho) throws InvalidStatsException, NoSuchFieldException, IllegalAccessException {
        System.out.println("Your hero has 3 attacks: Normal , Magic and Ultimate Attack");
        System.out.println("To attack with each spell in the following order , press 1,2 or 3 and hit Enter!");
        int round = 1;
        while (doncho.getHealth() > 0 && player.getHealth() > 0) {
            System.out.println("Round " + round + " - FIGHT!");
            System.out.println("Choose your attack");
            System.out.println();
            int chosenAttack = getAnInteger();

            switch (chosenAttack) {
                case 1:
                    player.normalAttack(player, doncho);
                    System.out.println("You attacked Doncho with Normal attack!");
                    break;
                case 2:
                    player.magicAttack(player, doncho);
                    System.out.println("You attacked Doncho with Magic attack! ");
                    break;
                case 3:
                    player.ultimateAttack(player, doncho);
                    System.out.println("You attacked Doncho with your Ultimate attack! ");
                    break;

            }
            doncho.normalAttack(doncho, player);

            if (player.getHealth() > 0 && doncho.getHealth() > 0) {
                System.out.println(doncho.getName() + " attacked with Normal attack for " + doncho.getAttackDamage() + " damage!");
                System.out.println();
                System.out.println("Player stats after round " + round + ":");
                player.printHeroStats();
                doncho.printHeroStats();
                round++;
            } else {
                if (doncho.getIsDead()) {
                    Scanner donchoScans = new Scanner(System.in);
                    System.out.println("VICTORY , you defeated Doncho!!!");
                    System.out.println("If you wish to revive Doncho press write \"love for Doncho\", otherwise press Enter");
                    String loveDoncho = donchoScans.nextLine();
                    if (loveDoncho.equals("love for Doncho")) {
                        doncho.heroRevive(doncho);
                        System.out.println("To all Legends DONCHO is ALIVE ");
                    } else {
                        System.out.println("No love for Doncho :/ ");
                        System.out.println("You WIN!");
                    }
                } else {
                    System.out.println("DEFEAT , Doncho has defeated you :/ ");
                }

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
            System.out.println();
            System.out.println("Round " + round + " - FIGHT!");
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 and hit Enter to attack ");
            System.out.println();
            int chosenAttack = getAnInteger();
            while (chosenAttack > 1) {
                try {
                    System.out.println("If you want to attack press 1 and hit Enter. ");
                    chosenAttack = in.nextInt();

                } catch (InputMismatchException e) {
                    in.next();
                    System.out.print("It seems like you did not enter a number buddy! ");

                }


            }
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
            }


        }
        System.out.println("Congratulations, you have defeated the first creature!!");
        System.out.println();
        System.out.println("Now you must face the mighty "+drake.getName()+ " Drake");
        round = 1;
        while (drake.getHealth() > 0) {
            System.out.println();
            System.out.println("Round " + round + " - FIGHT!");
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 and Enter to attack. ");
            System.out.println();
            int chosenAttack = getAnInteger();
            while (chosenAttack > 1) {
                try {
                    System.out.println("If you want to attack the drake press 1 and hit Enter. ");
                    chosenAttack = in.nextInt();

                } catch (InputMismatchException e) {
                    in.next();
                    System.out.print("It seems like you did not enter a number buddy! ");

                }


            }
            if (chosenAttack == 1) {
                player.heroAttackDrake((Drake) drake);
                drake.attackHeroes(player);
                if (player.getHealth() > 0 && drake.getHealth() > 0) {
                    System.out.println(player.getName() + " attacked drake for " + player.getAttackDamage() + ",but Drake absorbed some damage!");
                    System.out.println("Drake attacked " + player.getName() + " for " + drake.getAttackDamage() + ",but " + player.getName() + " absorbed some damage!");
                    System.out.println();
                    System.out.println("Player and Drake stats after round: " + round + ":");
                    player.printHeroStats();
                    System.out.println("DRAKE HEALTH:\t " + drake.getHealth());
                    round++;
                }
            }


        }
        System.out.println();
        System.out.println("Good JOB! Now you must face the final boss - BARON NASHOR.");
        round = 1;
        while (nashor.getHealth() > 0) {
            System.out.println();
            System.out.println("Round " + round + " - FIGHT!");
            Scanner in = new Scanner(System.in);
            System.out.println("Press 1 and Enter to attack. ");
            System.out.println();
            int chosenAttack = getAnInteger();
            while (chosenAttack > 1) {
                try {
                    System.out.println("If you want to attack Nashor press 1 and hit Enter. ");
                    chosenAttack = in.nextInt();

                } catch (InputMismatchException e) {
                    in.next();
                    System.out.print("It seems like you did not enter a number buddy! ");

                }


            }
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
            }


        }
        System.out.println("Excellent, you have defeated all the Creatures!!");
        System.out.println("VICTORY, you might actually become a Legend one day!!");

    }

    private static int getAnInteger() {
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                sc.next();
                System.out.print("It seems like you did not enter a number buddy! ");
                System.out.println("Try again: ");
            }
        }
    }

}
