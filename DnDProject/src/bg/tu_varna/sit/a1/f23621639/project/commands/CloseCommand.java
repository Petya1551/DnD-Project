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

    @Override
    public void execute() throws InterruptedException {
        System.out.println("\nThe map has been closed. Your stats are changed to default.");
        hero.reset();

        MenuInvoker invoker = new MenuInvoker();
        invoker.registerCommand(CommandsEnum.OPEN, new OpenCommand(scanner, hero));
        invoker.registerCommand(CommandsEnum.LEAVE_REALM, new ExitRealmCommand());

        System.out.println("\nYou can now only type the following commands:");
        System.out.println("1. Open (to begin your journey from the start)");
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
