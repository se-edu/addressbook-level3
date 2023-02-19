package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.PerformanceCommand;
import seedu.address.model.person.Performance;

public class PerformanceCommandParserTest {
    private PerformanceCommandParser parser = new PerformanceCommandParser();
    private final String nonEmptyPerformance = "100";

    @Test
    public void parse_indexSpecified_success() {
        // have remark
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_REMARK + nonEmptyPerformance;
        PerformanceCommand expectedCommand = new PerformanceCommand(INDEX_FIRST_PERSON, new Performance(nonEmptyPerformance));
        assertParseSuccess(parser, userInput, expectedCommand);

        // no remark
        userInput = targetIndex.getOneBased() + " " + PREFIX_REMARK;
        expectedCommand = new PerformanceCommand(INDEX_FIRST_PERSON, new Performance(""));
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, PerformanceCommand.MESSAGE_USAGE);

        // no parameters
        assertParseFailure(parser, PerformanceCommand.COMMAND_WORD, expectedMessage);

        // no index
        assertParseFailure(parser, PerformanceCommand.COMMAND_WORD + " " + nonEmptyPerformance, expectedMessage);
    }
}
