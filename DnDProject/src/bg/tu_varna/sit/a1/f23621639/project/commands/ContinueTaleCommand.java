package bg.tu_varna.sit.a1.f23621639.project.commands;

import java.util.Scanner;

public class ContinueTaleCommand implements Command {

    private final Scanner scanner;

    public ContinueTaleCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws InterruptedException {
        System.out.println();
        for (int i = 0; i <= 100; i++) {
            System.out.print("\rLoading " + i +"%");
            Thread.sleep(50);
        }
        System.out.println("\n\n---------------------------\n" +
                "|   You dare to return?   |\n" +
                "---------------------------\n");
        System.out.println("Click Any Key To Continue...");
        scanner.nextLine();

        System.out.println("----------------------------------------------------------------\n" +
                "|      The labyrinth's twisted walls creak and groan as if     |\n" +
                "|   they too are waking from slumber. A low, mocking whisper   |\n" +
                "|       fills the air, as if the very stones themselves        |\n" +
                "|             are laughing at your foolishness.                |\n" +
                "----------------------------------------------------------------\n");
        System.out.println("Click Any Key To Continue...");
        scanner.nextLine();

        System.out.println(
                "-----------------------------------------------------------------------\n" +
                        "|           'You foolish soul, thinking you can escape...             |\n" +
                        "|   You are not done here yet. The labyrinth has not forgotten you.   |\n" +
                        "|         It has waited. And now... it will test you again.'          |\n" +
                        "-----------------------------------------------------------------------\n");
        System.out.println("Click Any Key To Continue...");
        scanner.nextLine();

        System.out.println(
                "--------------------------------------------------------------\n" +
                        "|    The flickering torchlight reveals only more shadows,    |\n" +
                        "|   more corridors that seem to shift as you step forward.   |\n" +
                        "|    The labyrinth remembers your fear, your failures...     |\n" +
                        "|               and it will show no mercy.                   |\n" +
                        "--------------------------------------------------------------\n");
    }
}
