package seedu.address.logic.parser.exceptions;

import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.IllegalValueException;

/**
 * Represents a parse error encountered by a parser.
 */
public class ParseException extends IllegalValueException {
    private static Logger logger = LogsCenter.getLogger(ParseException.class);

    public ParseException(String message) {
        super(message);
        logger.fine("ParseException thrown: " + message);
    }

    public ParseException(String message, Throwable cause) {
        super(message, cause);
        logger.fine("ParseException thrown: " + message);
    }
}
