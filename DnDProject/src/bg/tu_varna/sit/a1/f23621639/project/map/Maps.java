package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.battle.Battle;
import bg.tu_varna.sit.a1.f23621639.project.commands.*;
import bg.tu_varna.sit.a1.f23621639.project.files.FileManager;
import bg.tu_varna.sit.a1.f23621639.project.items.Item;
import bg.tu_varna.sit.a1.f23621639.project.items.ItemFactory;
import bg.tu_varna.sit.a1.f23621639.project.monsters.Dragon;
import bg.tu_varna.sit.a1.f23621639.project.monsters.Monster;
import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.util.Random;
import java.util.Scanner;

public abstract class Maps {
    private char[][] map;
    private Hero hero;
    int playerX = 1;
    int playerY = 1;
    private int remainingMonsters = 0;
    private int remainingTreasures = 0;

    public Maps(Hero hero) {
        this.hero = hero;
    }

    /**
     * Returns the file paths of the available maps for this level.
     *
     * @return array of map file paths
     */
    protected abstract String[] getMapFilePaths();
    /**
     * Returns the string representation of the current level.
     *
     * @return current level name
     */
    protected abstract String getLevel();
    /**
     * Returns the integer representing the current level number.
     *
     * @return current level number
     */
    public abstract int currentLevel();
    /**
     * Returns the X coordinate of the map exit for the player.
     *
     * @return X coordinate of the exit
     */
    protected abstract int getPlayerXEnd();
    /**
     * Returns the Y coordinate of the map exit for the player.
     *
     * @return Y coordinate of the exit
     */
    protected abstract int getPlayerYEnd();


    /**
     * Starts the map level gameplay loop.
     * Handles player movement, encounters, and level progression.
     *
     * @throws InterruptedException if the thread is interrupted
     */
    public void start() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        Random randomFile = new Random();
        String[] mapFiles = getMapFilePaths();
        String selectedMap = mapFiles[randomFile.nextInt(mapFiles.length)];

        map = FileManager.loadMapFromFile(selectedMap);

        for (char[] row : map) {
            for (char c : row) {
                if (c == 'M') remainingMonsters++;
                else if (c == 'T') remainingTreasures++;
            }
        }

        while (true) {
            System.out.println(getLevel() + " level:");
            printMap();

            if (playerX == getPlayerXEnd() && playerY == getPlayerYEnd()) {
                System.out.println("\n==============================================");
                System.out.println("            End of the Labyrinth!             ");
                System.out.println("    You have conquered this level of the      ");
                System.out.println("                    maze!                     ");
                System.out.println("==============================================");

                System.out.println("\nType one of the following phrases to continue your journey (e.g. Close the Grimoire or Back to the Adventure).");
                System.out.println("1. Close the Grimoire");
                System.out.println("2. Back to the Adventure");

                String inputClose = scanner.nextLine().trim().toLowerCase();
                while (!inputClose.equalsIgnoreCase("Close the Grimoire") && !inputClose.equalsIgnoreCase("Back to the Adventure")) {
                    System.out.println("\nInvalid Command. Please type the full phrase exactly as shown.");
                    inputClose = scanner.nextLine().trim().toLowerCase();
                }
                if (inputClose.equalsIgnoreCase("Close the Grimoire")) {
                    MenuInvoker invoker = new MenuInvoker();
                    invoker.registerCommand(CommandsEnum.CLOSE, new CloseCommand(scanner, hero));
                    invoker.executeCommand(inputClose);
                }
                else if (inputClose.equalsIgnoreCase("Back to the Adventure")) {
                    hero.levelUp();
                    System.out.println("Current status: \n" + hero.toString());
                    System.out.println("\nType one of the following phrases to save your journey (e.g. Seal Your Fate or Seal New Destiny).");
                    System.out.println("1. Seal Your Fate");
                    System.out.println("2. Seal New Destiny");

                    MenuInvoker invoker = new MenuInvoker();
                    invoker.registerCommand(CommandsEnum.SAVE, new SaveCommand(hero, remainingMonsters, remainingTreasures));
                    invoker.registerCommand(CommandsEnum.SAVE_AS, new SaveAsCommand(hero, remainingMonsters, remainingTreasures, scanner));

                    String inputSave;
                    while (true) {
                        inputSave = scanner.nextLine().trim().toLowerCase();
                        if (invoker.hasCommand(inputSave)) {
                            invoker.executeCommand(inputSave);
                            break;
                        } else {
                            System.out.println("\nInvalid Command. Please type the full phrase exactly as shown.");
                        }
                    }

                    System.out.println("\n------------------------------\n" +
                            "|  You dare to continue your |\n" +
                            "|     journey to the next    |\n" +
                            "|   level of the labyrinth?  |\n" +
                            "------------------------------\n");
                    System.out.printf("Yes(Y) / No(N) ");

                    String command = scanner.nextLine();
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
                    } else if (command.equalsIgnoreCase("Y")){
                        Maps nextLevel = getNextLevel();
                        if (nextLevel != null) {
                            nextLevel.start();
                            return;
                        } else {
                            System.out.println("\n-----------------------------------------------------------------------\n" +
                                    "|                Your journey ends here… for now.                     |\n" +
                                    "|   The echoes of your footsteps will remain in these ancient halls.  |\n" +
                                    "|        Rest well, brave soul — we shall meet again soon.            |\n" +
                                    "-----------------------------------------------------------------------\n");
                            System.exit(0);
                        }
                    }
                }
                break;
            }

            System.out.printf("\nMove (w/a/s/d): ");
            String input = scanner.nextLine().toLowerCase();
            System.out.println();

            int newX = playerX;
            int newY = playerY;

            while (!input.equals("w") && !input.equals("s") && !input.equals("a") && !input.equals("d")) {
                System.out.printf("Invalid input. Use w, a, s, or d: ");
                input = scanner.nextLine().toLowerCase();
                System.out.println();
            }

            if (input.equals("w")) {
                newY--;
            } else if (input.equals("s")) {
                newY++;
            } else if (input.equals("a")) {
                newX--;
            } else if (input.equals("d")) {
                newX++;
            }

            if (map[newY][newX] == '#') {
                System.out.println("You can't move there. Try again.\n");
            }
            else {
                if (map[newY][newX] == 'M') {
                    Monster monster = new Dragon(currentLevel());
                    Random random = new Random();
                    Battle battle = new Battle(hero, monster, random, scanner);
                    battle.startBattle();
                    remainingMonsters--;
                }
                else if (map[newY][newX] == 'T') {
                    ItemFactory itemFactory = new ItemFactory();
                    Item foundItem = itemFactory.generateRandomItem(currentLevel());
                    boolean kept = hero.findTreasure(foundItem);
                    if (kept) {
                        remainingTreasures--;
                    }
                }

                map[playerY][playerX] = '.';
                playerX = newX;
                playerY = newY;
                map[playerY][playerX] = 'H';
            }
        }
    }

    /**
     * Prints the current state of the map to the console.
     */
    private void printMap() {
        for (char[] row : map) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    /**
     * Returns the number of remaining monsters on the map.
     *
     * @return remaining monsters count
     */
    public int getRemainingMonsters() {
        return remainingMonsters;
    }

    /**
     * Returns the number of remaining treasures on the map.
     *
     * @return remaining treasures count
     */
    public int getRemainingTreasures() {
        return remainingTreasures;
    }

    /**
     * Returns the next map level instance based on the current level.
     *
     * @return next map level or null if none exists
     */
    public Maps getNextLevel() {
        int nextLevel = currentLevel() + 1;
        switch (nextLevel) {
            case 2:
                return new MapLevelTwo(hero);
            case 3:
                return new MapLevelThree(hero);
            case 4:
                return new MapLevelFour(hero);
            default:
                return null;
        }
    }
}
