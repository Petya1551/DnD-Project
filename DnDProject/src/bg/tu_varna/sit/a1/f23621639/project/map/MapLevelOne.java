package bg.tu_varna.sit.a1.f23621639.project.map;

import bg.tu_varna.sit.a1.f23621639.project.battle.Battle;
import bg.tu_varna.sit.a1.f23621639.project.items.Item;
import bg.tu_varna.sit.a1.f23621639.project.items.ItemFactory;
import bg.tu_varna.sit.a1.f23621639.project.monsters.Dragon;
import bg.tu_varna.sit.a1.f23621639.project.monsters.Monster;
import bg.tu_varna.sit.a1.f23621639.project.races.Hero;
import bg.tu_varna.sit.a1.f23621639.project.files.FileManager;

import java.util.Random;
import java.util.Scanner;

public class MapLevelOne {
    private static char[][] map;
    private Hero hero;
    private static int playerX = 1;
    private static int playerY = 1;

    public MapLevelOne(Hero hero) {
        this.hero = hero;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        Random randomFile = new Random();
        int randomMap = randomFile.nextInt(2);

        if (randomMap == 0) {
            map = FileManager.loadMapFromFile("res/level1_1.txt");
        }
        else {
            map = FileManager.loadMapFromFile("res/level1_2.txt");
        }

        if (map == null) {
            System.out.println("Map could not be loaded. Exiting game.");
            System.exit(0);
        }

        while (true) {
            System.out.println("First level:");
            printMap();

            if (playerX == 8 && playerY == 8) {
                System.out.println("\n==============================================");
                System.out.println("            End of the Labyrinth!             ");
                System.out.println("   You have conquered the first level of the   ");
                System.out.println("                    maze!                     ");
                System.out.println("==============================================");
                hero.levelUp();
                System.out.println("Current status: \n" + hero.toString());
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
                    Monster monster = new Dragon();
                    Random random = new Random();
                    Battle battle = new Battle(hero, monster, random, scanner);
                    battle.startBattle();
                }
                else if (map[newY][newX] == 'T') {
                    ItemFactory itemFactory = new ItemFactory();
                    Item foundItem = itemFactory.generateRandomItem(hero);
                    hero.findTreasure(foundItem);
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
}
