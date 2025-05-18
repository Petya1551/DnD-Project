package bg.tu_varna.sit.a1.f23621639.project.commands;

public enum CommandsEnum {
    BEGIN_QUEST("begin your quest"),
    LEAVE_REALM("leave the realm"),
    HELP("learn the ways"),
    CLOSE("close the grimoire"),
    OPEN("load saved journey"),
    SAVE("seal your fate"),
    SAVE_AS("seal new destiny");

    private final String displayText;

    CommandsEnum(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }

    /**
     * Finds the enum constant that corresponds to the given input string.
     * The comparison ignores case and trims leading and trailing whitespace.
     *
     * @param input the input string to match against the command display texts
     * @return the matching CommandsEnum constant if found; otherwise, null
     */
    public static CommandsEnum fromInput(String input) {
        for (CommandsEnum cmd : values()) {
            if (cmd.displayText.equalsIgnoreCase(input.trim())) {
                return cmd;
            }
        }
        return null;
    }
}
