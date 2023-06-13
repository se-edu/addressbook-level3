package seedu.address.commons.exceptions;

/**
 * Represents an error during loading of files from the file system.
 */
public class ConfigLoadingException extends Exception {
    public ConfigLoadingException(Exception cause) {
        super(cause);
    }

}
