package seedu.address.commons.exceptions;

/**
 * Represents an error during conversion of data from one format to another
 */
public class ConfigLoadingException extends Exception {
    public ConfigLoadingException(Exception cause) {
        super(cause);
    }

}
