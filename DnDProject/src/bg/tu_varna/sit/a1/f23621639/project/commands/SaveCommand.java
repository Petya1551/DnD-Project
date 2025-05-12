package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class SaveCommand implements Command {
    private final Hero hero;
    private final int monsters;
    private final int treasures;

    public SaveCommand(Hero hero, int monsters, int treasures) {
        this.hero = hero;
        this.monsters = monsters;
        this.treasures = treasures;
    }

    @Override
    public void execute() {
        try (FileWriter writer = new FileWriter("save_game.txt", true)) {
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
