package bg.tu_varna.sit.a1.f23621639.project.commands;

import java.util.HashMap;
import java.util.Map;

/**
 * The MenuInvoker class manages the registration and execution of commands
 * represented by the CommandsEnum enum. It acts as a command dispatcher,
 * mapping input strings to their respective command implementations.
 */
public class MenuInvoker {
    private final Map<CommandsEnum, Command> commandMap = new HashMap<>();

    /**
     * Registers a command with its corresponding CommandsEnum key.
     *
     * @param commandsEnum the enum key representing the command
     * @param command the Command instance to register
     */
    public void registerCommand(CommandsEnum commandsEnum, Command command) {
        commandMap.put(commandsEnum, command);
    }

    /**
     * Executes the command associated with the given input string.
     * If the input does not match any registered command, an error message is printed.
     *
     * @param input the input string representing the command to execute
     * @throws InterruptedException if the command execution is interrupted
     */
    public void executeCommand(String input) throws InterruptedException {
        CommandsEnum cmd = CommandsEnum.fromInput(input);
        if (cmd != null && commandMap.containsKey(cmd)) {
            commandMap.get(cmd).execute();
        } else {
            System.out.println("\nInvalid Command. Please type the full phrase exactly as shown.");
        }
    }

    /**
     * Checks if a command corresponding to the given command name is registered.
     *
     * @param commandName the command name to check
     * @return true if the command is registered; false otherwise
     */
    public boolean hasCommand(String commandName) {
        CommandsEnum cmd = CommandsEnum.fromInput(commandName);
        return cmd != null && commandMap.containsKey(cmd);
    }
}
