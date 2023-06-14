package seedu.address.commons.core;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import seedu.address.logic.parser.Prefix;

/**
 * Container for user visible messages.
 */
public class Messages {

    public static final String MESSAGE_UNKNOWN_COMMAND = "Unknown command";
    public static final String MESSAGE_INVALID_COMMAND_FORMAT = "Invalid command format! \n%1$s";
    public static final String MESSAGE_INVALID_PERSON_DISPLAYED_INDEX = "The person index provided is invalid";
    public static final String MESSAGE_PERSONS_LISTED_OVERVIEW = "%1$d persons listed!";
    public static final String MESSAGE_DUPLICATE_FIELDS =
            "Multiple values specified for the following single-valued field(s): %s";
    /**
     * Formats the duplicate prefixes into an error message.
     */
    public static String getDuplicatePrefixesToMessage(Prefix... duplicatePrefixes) {
        if (duplicatePrefixes.length == 0) {
            return "";
        }

        Set<String> duplicateFields =
                Stream.of(duplicatePrefixes).map(Prefix::toString).collect(Collectors.toSet());

        return String.format(MESSAGE_DUPLICATE_FIELDS, String.join(" ", duplicateFields));
    }
}
