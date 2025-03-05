package bg.tu_varna.sit.a1.f23621639.project;

import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("               Dungeons & Dragons\n" +
                "              Welcome, Adventurers!\n" +
                "The winds of fate have carried you here, to a world\n" +
                "teeming with danger, mystery, and legend. Your choices\n" +
                "will shape the course of history, your courage will\n" +
                "be tested, and your bonds will be forged in the fires\n" +
                "                 of adventure.\n" +
                "\n" +
                "Steel your hearts, ready your spells, and keep your wits\n" +
                "about you-for the road ahead is uncertain, and only the\n" +
                "      bold shall carve their names into legend.\n" +
                "\n" +
                "Are you prepared to embark on this journey? The dice are waiting... and so is destiny.\n");

        System.out.println("Yes             No");

        String command = scanner.nextLine();
        while (!command.equalsIgnoreCase("yes") && !command.equalsIgnoreCase("no")) {
            System.out.println("Invalid Command. Please try again");
            command = scanner.nextLine();
        }
        if (command.equalsIgnoreCase("No")) {
            System.out.println("Very well, traveler. The adventure is not for everyone. " +
                    "Should you change your mind, the realm will be waiting for you.");
            System.exit(0);
        } else if (command.equalsIgnoreCase("Yes")) {
            int choice = 0;

            System.out.println("    /\\      /\\      /\\      ");
            System.out.println("   //\\\\    //\\\\    //\\\\    ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("  ||**||  ||**||  ||**||   ");
            System.out.println("==========================");
            System.out.println("      HERO'S JOURNEY");
            System.out.println("==========================\n");
            System.out.println("1. Begin Your Quest");
            System.out.println("2. Continue Your Tale");
            System.out.println("3. Adjust Your Gear (Settings)");
            System.out.println("4. Leave the Realm");
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    if (choice >= 1 && choice <= 4) {
                        break;
                    } else {
                        System.out.println("Invalid Command. Please enter a number between 1 and 4.");
                    }
                } else {
                    System.out.println("Invalid Command. Please enter a number.");
                }
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    System.out.println("hello");
                    break;
                case 2:
                    System.out.println("helloo");
                    break;
                case 3:
                    System.out.println("\n CONTROL GUIDE ");
                    System.out.println("Use the following controls to navigate and interact with the world:");
                    System.out.println("- **W / Up Arrow**: Move Forward");
                    System.out.println("- **A / Left Arrow**: Move Left");
                    System.out.println("- **S / Down Arrow**: Move Backward");
                    System.out.println("- **D / Right Arrow**: Move Right");
                    break;
                case 4:
                    System.out.println("Very well, traveler. The adventure is not for everyone. " +
                            "Should you change your mind, the realm will be waiting for you.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid Command. Please try again");
            }
        }
        scanner.close();
    }
}
