package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PERFORMANCE;

import seedu.address.commons.core.index.Index;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.logic.commands.PerformanceCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.person.Performance;

/**
 * Parses input arguments and creates a new {@code RemarkCommand} object
 */
public class PerformanceCommandParser implements Parser<PerformanceCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the {@code RemarkCommand}
     * and returns a {@code RemarkCommand} object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public PerformanceCommand parse(String args) throws ParseException {
        requireNonNull(args);
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_PERFORMANCE);

        Index index;
        try {
            index = ParserUtil.parseIndex(argMultimap.getPreamble());
        } catch (IllegalValueException ive) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    PerformanceCommand.MESSAGE_USAGE), ive);
        }

        String performance = argMultimap.getValue(PREFIX_PERFORMANCE).orElse("");

        return new PerformanceCommand(index, new Performance(performance));
    }
}
