package bg.tu_varna.sit.a1.f23621639.project.commands;

/**
 * Command that displays a guide of all available commands to the user.
 * This is intended to help the player understand how to interact with the system.
 */
public class HelpCommand implements Command{

    /**
     * Executes the help command by printing a formatted list of all valid user commands.
     * Each command is shown with a brief description to guide the user.
     *
     * @throws InterruptedException not used in this implementation,
     *         but declared to fulfill the Command interface contract.
     */
    @Override
    public void execute() throws InterruptedException {
        System.out.println("\n===============================================================");
        System.out.println("                        Command Guide                         ");
        System.out.println("===============================================================");
        System.out.println("|  Begin Your Quest    - Start a new journey                  |");
        System.out.println("|  Leave the Realm     - Exit the realm entirely              |");
        System.out.println("|  Load Saved Journey  - Load your previously saved progress  |");
        System.out.println("|  Close the Grimoire  - Close the currently opened file      |");
        System.out.println("|  Seal Your Fate      - Save current state to 'save_game.txt'|");
        System.out.println("|  Seal New Destiny    - Save progress to a new custom file   |");
        System.out.println("|  Learn the Ways      - Display this help guide              |");
        System.out.println("===============================================================");
        System.out.println("\nType one of the following phrases to continue (e.g. Begin Your Quest, Leave the Realm...).");
    }
}
