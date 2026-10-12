package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a person's remark in the address book.
 * Guarantees: immutable; is always valid.
 */
public class Remark {

    public final String value;

    /**
     * Creates a {@code Remark} from the given text.
     *
     * @param remark text of the remark
     */
    public Remark(String remark) {
        requireNonNull(remark);
        value = remark;
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Remark otherRemark)) {
            return false;
        }

        return value.equals(otherRemark.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
