package bg.tu_varna.sit.a1.f23621639.project.commands;

import java.util.Scanner;

/**
 * Command to exit the game realm.
 * When executed, it displays a farewell message and terminates the application.
 */
public class ExitRealmCommand implements Command {

    /**
     * Executes the exit command by displaying a farewell message
     * and terminating the program with status code 0.
     *
     * @throws InterruptedException not thrown in this implementation,
     *         but declared to comply with the Command interface.
     */
    @Override
    public void execute() throws InterruptedException {
        System.out.println("\n-----------------------------------------------------------------------\n" +
                "|       Very well, traveler. The adventure is not for everyone.       |\n" +
                "|   Should you change your mind, the realm will be waiting for you.   |\n" +
                "-----------------------------------------------------------------------\n");
        System.exit(0);
    }
}
