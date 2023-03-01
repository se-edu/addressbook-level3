package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import seedu.address.testutil.PersonBuilder;

public class PersonCardTest {

    @Test
    public void numberOfStudents_defaultStudentsSize_sizeReturned() {
        int size = 5;
        assertEquals(size, new PersonCard(new PersonBuilder().build(),0).getNumberOfStudents());
    }

    @Test
    public void getStudentProfiles_defaultStudentsSize_notNullReturned() {
        assertNotNull(new PersonCard(new PersonBuilder().build(),0).getStudentProfiles());
    }

    @Test
    public void setStudentProfiles_defaultStudentsSize_notNullReturned() {
        PersonCard personCard = new PersonCard(new PersonBuilder().build(),0);
        personCard.setStudentProfiles();
        assertNotNull(personCard.getStudentProfiles());
    }
}
