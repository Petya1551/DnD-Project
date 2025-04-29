package bg.tu_varna.sit.a1.f23621639.project;

import bg.tu_varna.sit.a1.f23621639.project.commands.BeginQuestCommand;
import bg.tu_varna.sit.a1.f23621639.project.commands.ContinueTaleCommand;
import bg.tu_varna.sit.a1.f23621639.project.commands.ExitRealmCommand;
import bg.tu_varna.sit.a1.f23621639.project.commands.MenuInvoker;

import java.util.Scanner;

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

            MenuInvoker invoker = new MenuInvoker();
            invoker.registerCommand("Begin your quest", new BeginQuestCommand(scanner));
            invoker.registerCommand("Continue your tale", new ContinueTaleCommand(scanner));
            invoker.registerCommand("Leave the realm", new ExitRealmCommand(scanner));

            String input;
            while (true) {
                input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("Begin your quest") ||
                        input.equalsIgnoreCase("Continue your tale") ||
                        input.equalsIgnoreCase("Leave the realm")) {
                    break;
                } else {
                    System.out.println("\nInvalid Command. Please type the full phrase exactly as shown.");
                }
            }

            invoker.executeCommand(input);
            scanner.close();
        }
    }
}
