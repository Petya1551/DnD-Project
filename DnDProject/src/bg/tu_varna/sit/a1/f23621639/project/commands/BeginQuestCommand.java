package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;
import bg.tu_varna.sit.a1.f23621639.project.races.Human;
import bg.tu_varna.sit.a1.f23621639.project.races.Mage;
import bg.tu_varna.sit.a1.f23621639.project.races.Warrior;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class BeginQuestCommand implements Command {
    private final Scanner scanner;

    public BeginQuestCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws InterruptedException {
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
    }
}
