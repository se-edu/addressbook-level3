package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHOTO;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.PhotoCommand;
import seedu.address.model.person.Photo;

public class PhotoCommandParserTest {
    private PhotoCommandParser parser = new PhotoCommandParser();
    private final String nonEmptyPhoto = "Some photo.";

    @Test
    public void parse_indexSpecified_success() {
        // have remark
        Index targetIndex = INDEX_FIRST_PERSON;
        String userInput = targetIndex.getOneBased() + " " + PREFIX_PHOTO + nonEmptyPhoto;
        PhotoCommand expectedCommand = new PhotoCommand(INDEX_FIRST_PERSON, new Photo(nonEmptyPhoto));
        assertParseSuccess(parser, userInput, expectedCommand);

        // no remark
        userInput = targetIndex.getOneBased() + " " + PREFIX_PHOTO;
        expectedCommand = new PhotoCommand(INDEX_FIRST_PERSON, new Photo(""));
        assertParseSuccess(parser, userInput, expectedCommand);
    }

    @Test
    public void parse_missingCompulsoryField_failure() {
        String expectedMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, PhotoCommand.MESSAGE_USAGE);

        // no parameters
        assertParseFailure(parser, PhotoCommand.COMMAND_WORD, expectedMessage);

        // no index
        assertParseFailure(parser, PhotoCommand.COMMAND_WORD + " " + nonEmptyPhoto, expectedMessage);
    }
}
