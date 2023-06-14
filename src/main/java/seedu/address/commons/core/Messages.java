package seedu.address.commons.core;

import java.util.Set;
import java.util.stream.Collectors;

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
            "Multiple values specified for the following single-valued field%1$s: %2$s\n"
                    + "Please only supply a single value for the field%1$s mentioned above.";

    /**
     * Formats the duplicate prefixes into an error message.
     */
    public static String getDuplicatePrefixesToMessage(Set<Prefix> duplicatePrefixes) {
        if (duplicatePrefixes.size() == 0) {
            return "";
        }

        Set<String> duplicateFields = duplicatePrefixes.stream().map(Prefix::toString).collect(Collectors.toSet());

        return String.format(MESSAGE_DUPLICATE_FIELDS, duplicateFields.size() > 1 ? "s" : "",
                String.join(" ", duplicateFields));
    }
}
