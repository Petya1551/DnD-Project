package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelFour;
import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelOne;
import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelThree;
import bg.tu_varna.sit.a1.f23621639.project.map.MapLevelTwo;
import bg.tu_varna.sit.a1.f23621639.project.races.Hero;
import bg.tu_varna.sit.a1.f23621639.project.races.Human;
import bg.tu_varna.sit.a1.f23621639.project.races.Mage;
import bg.tu_varna.sit.a1.f23621639.project.races.Warrior;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;


/**
 * Command implementation that starts the hero creation and quest initiation process.
 */
public class BeginQuestCommand implements Command {
    private final Scanner scanner;

    /**
     * Constructs a BeginQuestCommand with the given Scanner for user input.
     *
     * @param scanner the Scanner to read user input from
     */
    public BeginQuestCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Executes the command by guiding the user through hero creation,
     * displaying story introduction, and starting the first game level.
     *
     * @throws InterruptedException if the thread sleep is interrupted during loading animations
     */
    @Override
    public void execute() throws InterruptedException {
        System.out.println("\nBefore we begin your journey, please enter your username to embark \non your quest (up to 10 characters, only alphabetic characters without free spaces):");
        String username = scanner.nextLine();

        while (username.length() > 10 || username.length() <= 0 || !username.matches("[a-zA-Z]+")) {
            if (username.length() > 10) {
                System.out.println("Username exceeds the 10-character limit. Please enter a shorter username.");
            } else if (username.length() <= 0) {
                System.out.println("It seems you haven't entered your hero's username yet. Please provide your username to continue.");
            } else {
                System.out.println("Username contains invalid characters. Only alphabetic characters are allowed without free spaces.");
            }

            username = scanner.nextLine();
        }

        System.out.println("\nChoose your hero race (e.g. Human, Mage or Warrior): \n" +
                "1. Human\n" +
                "2. Mage\n" +
                "3. Warrior");

        String heroChoice = scanner.nextLine().toLowerCase();
        String user = username;

        Map<String, Supplier<Hero>> heroMap = new HashMap<>();
        heroMap.put("human", new Supplier<Hero>() {
            public Hero get() {
                return new Human(user);
            }
        });
        heroMap.put("mage", new Supplier<Hero>() {
            public Hero get() {
                return new Mage(user);
            }
        });
        heroMap.put("warrior", new Supplier<Hero>() {
            public Hero get() {
                return new Warrior(user);
            }
        });

        while (!heroMap.containsKey(heroChoice) || heroMap.containsKey("[a-zA-Z]+")) {
            System.out.println("\nInvalid race selection detected. Please enter one of the following races - Human, Mage, Warrior:");
            heroChoice = scanner.nextLine().toLowerCase();
        }
        Hero hero = heroMap.get(heroChoice).get();

        System.out.println("\nYou have chosen the " + hero.getRace() + " race! Here is the current information for your hero:");
        System.out.println(hero.toString() + "\n");

        for (int i = 0; i <= 100; i++) {
            System.out.print("\rLoading " + i + "%");
            Thread.sleep(50);
        }

        System.out.println("\n\n-------------------------------------------------------------------------------\n" +
                "|       The air is damp, the scent of moss and stone filling your lungs.      |\n" +
                "|   Behind you, the entrance has vanished - only endless, winding corridors   |\n" +
                "|    remain. The flickering torchlight barely reaches the walls, casting      |\n" +
                "|           twisting shadows that seem to move on their own.                  |\n" +
                "-------------------------------------------------------------------------------\n");
        System.out.println("Click Enter To Continue...");
        scanner.nextLine();

        System.out.println("--------------------------------------------------------------------------------------\n" +
                "|   A distant echo - a scrape of something against the stone - breaks the silence.   |\n" +
                "--------------------------------------------------------------------------------------\n");
        System.out.println("Click Enter To Continue...");
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
        System.out.println("Click Enter To Continue...");
        scanner.nextLine();

        System.out.println("CONTROL GUIDE ");
        System.out.println("Your journey begins at the top left corner of the labyrinth.");
        System.out.println("The player's position on the map is located as 'H'.");
        System.out.println("To escape the maze's dark and foreboding walls, you must \nmake your way to the gate at the bottom right corner.");
        System.out.println("In the labyrinth you may face different monsters ('M') or you can find exciting treasures ('T').");
        System.out.println("\nUse the following controls to navigate and interact with the world:");
        System.out.println("W: Move Backward");
        System.out.println("A: Move Left");
        System.out.println("S: Move Forward");
        System.out.println("D: Move Right\n");

        for (int i = 0; i <= 100; i++) {
            System.out.print("\rLoading " + i + "%");
            Thread.sleep(50);
        }
        System.out.println();
        System.out.println();

        MapLevelOne levelOne = new MapLevelOne(hero);
        levelOne.start();
    }
}
