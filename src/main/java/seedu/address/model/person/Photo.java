package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's remark in the address book.
 * Guarantees: immutable; is always valid
 */
public class Photo {
    public final String photoFilePath;

    /**
     * Accepts photo that is not empty
     * @param photoFilePath String of filepath
     */
    public Photo(String photoFilePath) {
        requireNonNull(photoFilePath);
        this.photoFilePath = photoFilePath;
    }

    @Override
    public String toString() {
        return photoFilePath;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Photo // instanceof handles nulls
                && photoFilePath.equals(((Photo) other).photoFilePath)); // state check
    }

    @Override
    public int hashCode() {
        return photoFilePath.hashCode();
    }
}
