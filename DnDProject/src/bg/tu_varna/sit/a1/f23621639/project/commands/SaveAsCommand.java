package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class SaveAsCommand implements Command{
    private final Hero hero;
    private final int monsters;
    private final int treasures;
    private final Scanner scanner;

    public SaveAsCommand(Hero hero, int monsters, int treasures, Scanner scanner) {
        this.hero = hero;
        this.monsters = monsters;
        this.treasures = treasures;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
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
