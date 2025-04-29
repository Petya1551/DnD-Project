package bg.tu_varna.sit.a1.f23621639.project.commands;

import java.util.HashMap;
import java.util.Map;

public class MenuInvoker {
    private final Map<String, Command> commandMap = new HashMap<>();

    public void registerCommand(String input, Command command) {
        commandMap.put(input.toLowerCase().trim(), command);
    }

    public void executeCommand(String input) throws InterruptedException {
        Command command = commandMap.get(input.toLowerCase().trim());
        if (command != null) {
            command.execute();
        } else {
            System.out.println("\nInvalid Command. Please type the full phrase exactly as shown.");
        }
    }
}
