package seedu.address.commons.exceptions;

/**
 * Represents an error during loading of files from the file system.
 */
public class DataConversionException extends Exception {
    public DataConversionException(Exception cause) {
        super(cause);
    }

}
