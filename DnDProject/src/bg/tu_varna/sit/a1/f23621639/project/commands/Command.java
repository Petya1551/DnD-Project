package bg.tu_varna.sit.a1.f23621639.project.commands;

/**
 * Represents a command that can be executed.
 * Implementations define specific actions triggered by the execute method.
 */
public interface Command {

    /**
     * Executes the command.
     *
     * @throws InterruptedException if the execution is interrupted
     */
    public void execute() throws InterruptedException;
}
