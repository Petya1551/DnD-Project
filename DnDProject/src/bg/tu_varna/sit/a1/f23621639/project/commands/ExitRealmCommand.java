package bg.tu_varna.sit.a1.f23621639.project.commands;

import java.util.Scanner;

public class ExitRealmCommand implements Command {
    private final Scanner scanner;

    public ExitRealmCommand(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void execute() throws InterruptedException {
        System.out.println("\n-----------------------------------------------------------------------\n" +
                "|       Very well, traveler. The adventure is not for everyone.       |\n" +
                "|   Should you change your mind, the realm will be waiting for you.   |\n" +
                "-----------------------------------------------------------------------\n");
        System.exit(0);
    }
}
