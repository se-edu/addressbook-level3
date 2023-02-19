package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class PerformanceTest {

    @Test
    public void equals() {
        Performance performance = new Performance("1");

        // same object -> returns true
        assertTrue(performance.equals(performance));

        // same values -> returns true
        Performance performanceCopy = new Performance(performance.value);
        assertTrue(performance.equals(performanceCopy));

        // different types -> returns false
        assertFalse(performance.equals(1));

        // different types but same value -> returns true
        assertTrue(Integer.parseInt(performance.value) == 1);

        // null -> returns false
        assertFalse(performance.equals(null));

        // different remark -> returns false
        Performance differentPerformance = new Performance("10");
        assertFalse(performance.equals(differentPerformance));
    }
}
