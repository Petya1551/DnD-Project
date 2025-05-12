package bg.tu_varna.sit.a1.f23621639.project.commands;

public class HelpCommand implements Command{
    @Override
    public void execute() throws InterruptedException {
        System.out.println("\nThe following commands are supported:");
        System.out.println("Begin your quest starts the game");
        System.out.println("Leave the Realm exits the program");
        System.out.println("Open <file> opens <file>");
        System.out.println("Close closes currently opened file");
        System.out.println("Save saves the current map status and the players status");
        System.out.println("Saveas <file> the current map status and the players status in <file>");
        System.out.println("Help prints this information");
        System.out.println("\nType one of the following phrases to continue (e.g. Begin Your Quest, Leave the Realm, Help).");
    }
}
