package bg.tu_varna.sit.a1.f23621639.project;

import java.util.Scanner;

public class StartMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("               Dungeons & Dragons\n" +
                "              Welcome, Adventurers!\n" +
                " The winds of fate have carried you here, to a world\n" +
                "teeming with danger, mystery, and legend. Your choices\n" +
                " will shape the course of history, your courage will\n" +
                "be tested, and your bonds will be forged in the fires\n" +
                "                 of adventure.\n");

        System.out.println("Click Any Key To Continue...");
        String command = scanner.nextLine();

        System.out.println("Steel your hearts, ready your spells, and keep your wits\n" +
                "about you-for the road ahead is uncertain, and only the\n" +
                "      bold shall carve their names into legend.\n");

        System.out.println("Click Any Key To Continue...");
        scanner.nextLine();

        System.out.println("Are you prepared to embark on this journey? The dice are waiting... and so is destiny.\n");
        System.out.println("Yes           No");
        command = scanner.nextLine();

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
            System.out.println("   THE LABYRINTH AWAITS");
            System.out.println("==========================\n");
            System.out.println("1. Begin Your Quest");
            System.out.println("2. Continue Your Tale");
            System.out.println("3. Leave the Realm");

            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    scanner.nextLine();
                    if (choice >= 1 && choice <= 3) {
                        break;
                    }
                    else {
                        System.out.println("Invalid Command. Please enter a number between 1 and 4.");
                    }
                }
                else {
                    System.out.println("Invalid Command. Please enter a number.");
                }
                scanner.nextLine();
            }

            switch (choice) {
                case 1:
                    System.out.println("Before we begin your journey, please enter your username to embark on your quest.");
                    String username = scanner.nextLine();

                    System.out.println("   \nThe air is damp, the scent of moss and stone filling your lungs.\n" +
                            "Behind you, the entrance has vanished - only endless, winding corridors\n" +
                            " remain. The flickering torchlight barely reaches the walls, casting\n" +
                            "        twisting shadows that seem to move on their own.\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println("A distant echo - a scrape of something against the stone - breaks the silence.\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println("Then, a voice, faint and whispering: \"You shouldn't have come here " + username + "...\"\n");
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
                    System.out.println("You dare to return?\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println("  The labyrinth's twisted walls creak and groan as if\n" +
                            "they too are waking from slumber. A low, mocking whisper\n" +
                            "   fills the air, as if the very stones themselves\n" +
                            "        are laughing at your foolishness.\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println("   'You foolish soul, thinking you can escape...\n" +
                            "You are not done here yet. The labyrinth has not forgotten you.\n" +
                            "  It has waited. And now... it will test you again.'\n");
                    System.out.println("Click Any Key To Continue...");
                    scanner.nextLine();

                    System.out.println(" The flickering torchlight reveals only more shadows,\n" +
                            "more corridors that seem to shift as you step forward.\n" +
                            " The labyrinth remembers your fear, your failures...\n" +
                            "         and it will show no mercy.\n");
                    break;
                case 3:
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
