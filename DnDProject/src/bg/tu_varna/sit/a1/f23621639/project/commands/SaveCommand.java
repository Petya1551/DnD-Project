package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Command for saving the current game state to a predefined file "save_game.txt".
 * This includes hero stats, remaining monsters, and remaining treasures.
 */
public class SaveCommand implements Command {
    private final Hero hero;
    private final int monsters;
    private final int treasures;

    /**
     * Creates a new SaveCommand with the given hero, number of remaining monsters, and treasures.
     *
     * @param hero     the Hero whose state will be saved
     * @param monsters the number of remaining monsters in the game
     * @param treasures the number of remaining treasures in the game
     */
    public SaveCommand(Hero hero, int monsters, int treasures) {
        this.hero = hero;
        this.monsters = monsters;
        this.treasures = treasures;
    }

    /**
     * Saves game progress to "save_game.txt" file.
     * Overwrites any existing data in the file.
     *
     * @throws InterruptedException Declared to satisfy the Command interface, not used.
     */
    @Override
    public void execute() throws InterruptedException {
        try (FileWriter writer = new FileWriter("save_game.txt", false)) {
            writer.write("=== Game Save ===\n");
            writer.write("Remaining Monsters: " + monsters + "\n");
            writer.write("Remaining Treasures: " + treasures + "\n");
            writer.write("Hero Status:\n");
            writer.write(hero.toString());
            writer.write("\n=================\n");
            System.out.println("Game saved successfully.");
        } catch (IOException e) {
            System.out.println("Failed to save game: " + e.getMessage());
        }
    }
}
