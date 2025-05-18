package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Command that allows the player to save
 * their current game state (including hero status, remaining monsters, and treasures)
 * to a custom text file specified by the user.
 */
public class SaveAsCommand implements Command{
    private final Hero hero;
    private final int monsters;
    private final int treasures;
    private final Scanner scanner;

    /**
     * Constructs a new {@code SaveAsCommand} with the given hero, monster and treasure counts, and input scanner.
     *
     * @param hero      the hero object representing the current game character
     * @param monsters  the number of remaining monsters in the current level
     * @param treasures the number of remaining treasures in the current level
     * @param scanner   the scanner object for user input
     */
    public SaveAsCommand(Hero hero, int monsters, int treasures, Scanner scanner) {
        this.hero = hero;
        this.monsters = monsters;
        this.treasures = treasures;
        this.scanner = scanner;
    }

    /**
     * Prompts the user to enter a valid `.txt` filename and saves the game state
     * including hero information, remaining monsters, and treasures to that file.
     *
     * @throws InterruptedException Required by the Command interface, not used here.
     */
    @Override
    public void execute() throws InterruptedException {
        String fileName;
        while (true) {
            System.out.print("Enter a file name ending with `.txt` (e.g., `my_save.txt`): ");
            fileName = scanner.nextLine().trim();

            if (fileName.toLowerCase().endsWith(".txt")) {
                break;
            } else {
                System.out.println("Invalid file name. It must end with `.txt`.");
            }
        }

        try (FileWriter writer = new FileWriter(fileName)) {
            writer.write("=== Game Save ===\n");
            writer.write("Remaining Monsters: " + monsters + "\n");
            writer.write("Remaining Treasures: " + treasures + "\n");
            writer.write("Hero Status:\n");
            writer.write(hero.toString());
            writer.write("\n=================\n");
            System.out.println("Game saved as '" + fileName + "' successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save game: " + e.getMessage());
        }
    }
}
