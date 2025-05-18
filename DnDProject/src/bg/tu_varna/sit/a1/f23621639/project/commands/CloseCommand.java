package bg.tu_varna.sit.a1.f23621639.project.commands;

import bg.tu_varna.sit.a1.f23621639.project.races.Hero;

import java.util.Scanner;

public class CloseCommand implements Command{
    private final Scanner scanner;
    private final Hero hero;

    public CloseCommand(Scanner scanner, Hero hero) {
        this.scanner = scanner;
        this.hero = hero;
    }

    /**
     * Executes the close command, notifying the user the map is closed,
     * and restricting available commands to opening a saved journey or leaving the realm.
     * Keeps prompting until a valid command is entered and executed.
     *
     * @throws InterruptedException not thrown in this implementation,
     *         but declared to comply with the Command interface.
     */
    @Override
    public void execute() throws InterruptedException {
        System.out.println("\nThe map has been closed.");

        MenuInvoker invoker = new MenuInvoker();
        invoker.registerCommand(CommandsEnum.OPEN, new OpenCommand());
        invoker.registerCommand(CommandsEnum.LEAVE_REALM, new ExitRealmCommand());

        System.out.println("\nYou can now only type the following commands:");
        System.out.println("1. Open");
        System.out.println("2. Leave the Realm");

        while (true) {
            String input = scanner.nextLine().trim().toLowerCase();

            if (invoker.hasCommand(input)) {
                invoker.executeCommand(input);
                break;
            } else {
                System.out.println("Invalid command. Only 'Open' or 'Leave the Realm' are allowed.");
            }
        }
    }
}
