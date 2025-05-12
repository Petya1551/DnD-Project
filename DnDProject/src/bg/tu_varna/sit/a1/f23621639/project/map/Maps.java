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

    protected abstract String[] getMapFilePaths();
    protected abstract String getLevel();
    public abstract int currentLevel();
    protected abstract int getPlayerXEnd();
    protected abstract int getPlayerYEnd();

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

        if (map == null) {
            System.out.println("Map could not be loaded. Exiting game.");
            System.exit(0);
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

                System.out.println("\nType one of the following phrases to continue your journey (e.g. Close or Continue).");
                System.out.println("1. Close");
                System.out.println("2. Continue");

                String inputClose = scanner.nextLine().trim().toLowerCase();
                while (!inputClose.equalsIgnoreCase("Close") && !inputClose.equalsIgnoreCase("Continue")) {
                    System.out.println("\nInvalid Command. Please type the full phrase exactly as shown.");
                    inputClose = scanner.nextLine().trim().toLowerCase();
                }
                if (inputClose.equalsIgnoreCase("Close")) {
                    MenuInvoker invoker = new MenuInvoker();
                    invoker.registerCommand(CommandsEnum.CLOSE, new CloseCommand(scanner, hero));
                    invoker.executeCommand(inputClose);
                }
                else if (inputClose.equalsIgnoreCase("Continue")) {
                    System.out.println("\nType one of the following phrases to save your journey (e.g. Save or Save as).");
                    System.out.println("1. Save");
                    System.out.println("2. Save as");

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

                    if (hero.getLevel() <= currentLevel()) {
                        hero.levelUp();
                    } else {
                        System.out.println("\n" + hero.getName() + " is already stronger than this level and doesn't need to level up again.\n");
                    }

                    System.out.println("Current status: \n" + hero.toString());

                    break;
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

    private void printMap() {
        for (char[] row : map) {
            for (char c : row) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    public int getRemainingMonsters() {
        return remainingMonsters;
    }

    public int getRemainingTreasures() {
        return remainingTreasures;
    }
}
