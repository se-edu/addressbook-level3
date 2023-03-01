package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class GuiSettingsTest {

    @Test
    public void toString_defaultObject_stringReturned() {
        int defaultWidth = 800;
        assertEquals(defaultWidth, new GuiSettings().getWindowWidth());
    }

    @Test
    public void toStrin_defaultObject_stringReturned() {
        int defaultHeight = 900;
        assertEquals(defaultHeight, new GuiSettings().getWindowHeight());
    }

    @Test
    public void toStri_defaultObject_stringReturned() {
        assertNull(new GuiSettings().getWindowCoordinates());
    }

    @Test
    public void toStr_defaultObject_stringReturned() {
        int defaultImageViewHeight = 35;
        assertEquals(defaultImageViewHeight, new GuiSettings().getImageViewHeight());
    }

    @Test
    public void toStrings_defaultObject_stringReturned() {
        int defaultImageViewWidth = 40;
        assertEquals(defaultImageViewWidth, new GuiSettings().getImageViewWidth());
    }

    @Test
    public void toStrinssg_defaultObject_stringReturned() {
        int defaultCircleXCoordinates = 17;
        assertEquals(defaultCircleXCoordinates, new GuiSettings().getCircleX());
    }

    @Test
    public void toStrinsssg_defaultObject_stringReturned() {
        int defaultCircleYCoordinates = 17;
        assertEquals(defaultCircleYCoordinates, new GuiSettings().getCircleY());
    }

    @Test
    public void toStrigs_defaultObject_stringReturned() {
        int defaultCircleRadius = 17;
        assertEquals(defaultCircleRadius, new GuiSettings().getCircleRadius());
    }
}
