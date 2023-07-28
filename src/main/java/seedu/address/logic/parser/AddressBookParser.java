package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.Messages.MESSAGE_UNKNOWN_COMMAND;

import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import seedu.address.commons.core.LogsCenter;
import seedu.address.logic.commands.AddCommand;
import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.Command;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.parser.exceptions.ParseException;

/**
 * Parses user input.
 */
public class AddressBookParser {

    /**
     * Used for initial separation of command word and args.
     */
    private static final Pattern BASIC_COMMAND_FORMAT = Pattern.compile("(?<commandWord>\\S+)(?<arguments>.*)");
    private static final Logger logger = LogsCenter.getLogger(AddressBookParser.class);

    /**
     * Parses user input into command for execution.
     *
     * @param userInput full user input string
     * @return the command based on the user input
     * @throws ParseException if the user input does not conform the expected format
     */
    public Command parseCommand(String userInput) throws ParseException {
        final Matcher matcher = BASIC_COMMAND_FORMAT.matcher(userInput.trim());
        if (!matcher.matches()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT, HelpCommand.MESSAGE_USAGE));
        }

        final String commandWord = matcher.group("commandWord");
        final String arguments = matcher.group("arguments");
        logger.fine("Command word: " + commandWord);
        logger.fine("Arguments: " + arguments);

        switch (commandWord) {

        case AddCommand.COMMAND_WORD:
            logger.fine("Add command detected");
            return new AddCommandParser().parse(arguments);

        case EditCommand.COMMAND_WORD:
            logger.fine("Edit command detected");
            return new EditCommandParser().parse(arguments);

        case DeleteCommand.COMMAND_WORD:
            logger.fine("Delete command detected");
            return new DeleteCommandParser().parse(arguments);

        case ClearCommand.COMMAND_WORD:
            logger.fine("Clear command detected");
            return new ClearCommand();

        case FindCommand.COMMAND_WORD:
            logger.fine("Find command detected");
            return new FindCommandParser().parse(arguments);

        case ListCommand.COMMAND_WORD:
            logger.fine("List command detected");
            return new ListCommand();

        case ExitCommand.COMMAND_WORD:
            logger.fine("Exit command detected");
            return new ExitCommand();

        case HelpCommand.COMMAND_WORD:
            logger.fine("Help command detected");
            return new HelpCommand();

        default:
            logger.fine("Unknown command detected");
            throw new ParseException(MESSAGE_UNKNOWN_COMMAND);
        }
    }

}
