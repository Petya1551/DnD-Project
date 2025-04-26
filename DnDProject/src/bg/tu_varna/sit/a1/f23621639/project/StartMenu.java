package bg.tu_varna.sit.a1.f23621639.project;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class StartMenu {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("                   Dungeons & Dragons\n" +
                "                  Welcome, Adventurers!\n" +
                "-----------------------------------------------------------\n" +
                "|   The winds of fate have carried you here, to a world   |\n" +
                "|  teeming with danger, mystery, and legend. Your choices |\n" +
                "|   will shape the course of history, your courage will   |\n" +
                "|  be tested, and your bonds will be forged in the fires  |\n" +
                "|                     of adventure.                       |\n" +
                "-----------------------------------------------------------\n");

        System.out.println("Click Any Key To Continue...");
        String command = scanner.nextLine();

        System.out.println("----------------------------------------------------------------\n" +
                "|   Steel your hearts, ready your spells, and keep your wits   |\n" +
                "|    about you-for the road ahead is uncertain, and only the   |\n" +
                "|         bold shall carve their names into legend.            |\n" +
                "----------------------------------------------------------------\n");

        System.out.println("Click Any Key To Continue...");
        scanner.nextLine();

        System.out.println("----------------------------------------------------------------------------------------------\n" +
                "|   Are you prepared to embark on this journey? The dice are waiting... and so is destiny.   |\n" +
                "----------------------------------------------------------------------------------------------");
        System.out.printf("Yes(Y) / No(N) ");
        command = scanner.nextLine();

        while (!command.equalsIgnoreCase("Y") && !command.equalsIgnoreCase("N")) {
            System.out.printf("\nInvalid Command. Please try again ");
            command = scanner.nextLine();
        }

        if (command.equalsIgnoreCase("N")) {
            System.out.println("\n-----------------------------------------------------------------------\n" +
                    "|       Very well, traveler. The adventure is not for everyone.       |\n" +
                    "|   Should you change your mind, the realm will be waiting for you.   |\n" +
                    "-----------------------------------------------------------------------\n");
            System.exit(0);

        } else if (command.equalsIgnoreCase("Y")) {
            int choice = 0;
            System.out.println("\n    /\\      /\\      /\\      ");
            System.out.println("   //\\\\    //\\\\    //\\\\    ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("==========================");
            System.out.println("   THE LABYRINTH AWAITS");
            System.out.println("==========================\n");
            System.out.println("1. Begin Your Quest");
            System.out.println("2. Continue Your Tale");
            System.out.println("3. Leave the Realm");

            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 1 && choice <= 3) {
                        break;
                    }
                    else {
                        System.out.printf("\nInvalid Command. Please enter a number between 1 and 3. ");
                    }
                }
                else {
                    System.out.printf("\nInvalid Command. Please enter a number. ");
                }
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    scanner.nextLine();
                    System.out.println("\nBefore we begin your journey, please enter your username to embark on your quest.(max 10 characters)");
                    String username = scanner.nextLine();
                    String user = username;

                    while (username.length() > 10){
                        System.out.println("Username exceeds the 10-character limit. Please enter a shorter username.");
                        username = scanner.nextLine();
                    }

                    System.out.println("\nChoose your hero class: \n" +
                                        "1. Human\n" +
                                        "2. Mage\n" +
                                        "3. Warrior");

                    int heroChoice = scanner.nextInt();

                    Map<Integer, Supplier<Hero>> heroMap = new HashMap<>();
                    heroMap.put(1, () -> new Human(user));
                    heroMap.put(2, () -> new Mage(user));
                    heroMap.put(3, () -> new Warrior(user));

                    Supplier<Hero> defaultHero = () -> new Warrior(user);
                    Hero hero = heroMap.getOrDefault(heroChoice, defaultHero).get();

                    System.out.println("\nYou have chosen the " + hero.getRace() + " race! Here is the current information for your hero:");
                    System.out.println(hero.toString() + "\n");

                    //hero.levelUp();
                    //System.out.println(hero.toString());

                    /*ItemFactory itemFactory = new ItemFactory();
                    Item foundItem = itemFactory.generateRandomItem();
                    hero.findTreasure(foundItem);
                    System.out.println(hero.toString() + "\n");*/

                    for (int i = 0; i <= 100; i++) {
                        System.out.print("\rLoading " + i +"%");
                        Thread.sleep(50);
                    }
                    scanner.nextLine();

                    System.out.println("\n\n-------------------------------------------------------------------------------\n" +
                            "|       The air is damp, the scent of moss and stone filling your lungs.      |\n" +
                            "|   Behind you, the entrance has vanished - only endless, winding corridors   |\n" +
                            "|    remain. The flickering torchlight barely reaches the walls, casting      |\n" +
                            "|           twisting shadows that seem to move on their own.                  |\n" +
                            "-------------------------------------------------------------------------------\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println("--------------------------------------------------------------------------------------\n" +
                            "|   A distant echo - a scrape of something against the stone - breaks the silence.   |\n" +
                            "--------------------------------------------------------------------------------------\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    String message = "You shouldn't have come here " + username + "...";
                    int boxWidth = 89;
                    int padding = (boxWidth - 4 - message.length()) / 2;
                    int rightPadding = boxWidth - 4 - message.length() - padding;
                    String spacesLeft = "";
                    for (int i = 0; i < padding; i++) {
                        spacesLeft += " ";
                    }
                    String spacesRight = "";
                    for (int i = 0; i < rightPadding; i++) {
                        spacesRight += " ";
                    }

                    System.out.println(
                            "---------------------------------------------------------------------------------------\n" +
                            "|" + spacesLeft + message + spacesRight + "|\n" +
                            "---------------------------------------------------------------------------------------\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println("CONTROL GUIDE ");
                    System.out.println("Use the following controls to navigate and interact with the world:");
                    System.out.println("**W / Up Arrow**: Move Forward");
                    System.out.println("**A / Left Arrow**: Move Left");
                    System.out.println("**S / Down Arrow**: Move Backward");
                    System.out.println("**D / Right Arrow**: Move Right");
                    break;
                case 2:
                    scanner.nextLine();
                    for (int i = 0; i <= 100; i++) {
                        System.out.print("\rLoading " + i +"%");
                        Thread.sleep(50);
                    }
                    System.out.println("\n\n---------------------------\n" +
                            "|   You dare to return?   |\n" +
                            "---------------------------\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println("----------------------------------------------------------------\n" +
                            "|      The labyrinth's twisted walls creak and groan as if     |\n" +
                            "|   they too are waking from slumber. A low, mocking whisper   |\n" +
                            "|       fills the air, as if the very stones themselves        |\n" +
                            "|             are laughing at your foolishness.                |\n" +
                            "----------------------------------------------------------------\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println(
                            "-----------------------------------------------------------------------\n" +
                            "|           'You foolish soul, thinking you can escape...             |\n" +
                            "|   You are not done here yet. The labyrinth has not forgotten you.   |\n" +
                            "|         It has waited. And now... it will test you again.'          |\n" +
                            "-----------------------------------------------------------------------\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println(
                            "--------------------------------------------------------------\n" +
                            "|    The flickering torchlight reveals only more shadows,    |\n" +
                            "|   more corridors that seem to shift as you step forward.   |\n" +
                            "|    The labyrinth remembers your fear, your failures...     |\n" +
                            "|               and it will show no mercy.                   |\n" +
                            "--------------------------------------------------------------\n");
                    break;
                case 3:
                    System.out.println("\n-----------------------------------------------------------------------\n" +
                            "|       Very well, traveler. The adventure is not for everyone.       |\n" +
                            "|   Should you change your mind, the realm will be waiting for you.   |\n" +
                            "-----------------------------------------------------------------------\n");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Command. Please try again");
            }
        }
        scanner.close();
    }
}
