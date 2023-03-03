package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PhotoTest {

    @Test
    public void equals() {
        Photo photo = new Photo("https://picsum.photos/id/342/200/300");

        // same object -> returns true
        assertTrue(photo.equals(photo));

        // same values -> returns true
        Photo photoCopy = new Photo(photo.photoFilePath);
        assertTrue(photo.equals(photoCopy));

        // different types -> returns false
        assertFalse(photo.equals(1));

        // null -> returns false
        assertFalse(photo.equals(null));

        // different remark -> returns false
        Photo differentPhoto = new Photo("https://picsum.photos/id/349/200/300");
        assertFalse(photo.equals(differentPhoto));
    }
}
