package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Provides a link to the user guide.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    private static final String USER_GUIDE_URL =
            "https://github.com/se-edu/addressbook-level3/blob/master/docs/UserGuide.adoc";

    public static final String MESSAGE_OUTPUT = "The user guide is available at " + USER_GUIDE_URL;

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_OUTPUT);
    }
}
