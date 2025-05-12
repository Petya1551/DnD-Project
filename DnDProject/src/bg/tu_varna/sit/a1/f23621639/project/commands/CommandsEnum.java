package bg.tu_varna.sit.a1.f23621639.project.commands;

public enum CommandsEnum {
    BEGIN_QUEST("begin your quest"),
    LEAVE_REALM("leave the realm"),
    HELP("help"),
    CLOSE("close"),
    OPEN("open"),
    SAVE("save"),
    SAVE_AS("save as");

    private final String displayText;

    CommandsEnum(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    public static String normalize(String input) {
        return input.trim().toLowerCase();
    }

    public static CommandsEnum fromInput(String input) {
        for (CommandsEnum cmd : values()) {
            if (cmd.displayText.equalsIgnoreCase(input.trim().toLowerCase())) {
                return cmd;
            }
        }
        return null;
    }
}
