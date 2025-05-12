package bg.tu_varna.sit.a1.f23621639.project.commands;

import java.util.HashMap;
import java.util.Map;

public class MenuInvoker {
    private final Map<CommandsEnum, Command> commandMap = new HashMap<>();

    public void registerCommand(CommandsEnum commandsEnum, Command command) {
        commandMap.put(commandsEnum, command);
    }

    public void executeCommand(String input) throws InterruptedException {
        CommandsEnum cmd = CommandsEnum.fromInput(input);
        if (cmd != null && commandMap.containsKey(cmd)) {
            commandMap.get(cmd).execute();
        } else {
            System.out.println("\nInvalid Command. Please type the full phrase exactly as shown.");
        }
    }

    public boolean hasCommand(String commandName) {
        CommandsEnum cmd = CommandsEnum.fromInput(commandName);
        return cmd != null && commandMap.containsKey(cmd);
    }
}
