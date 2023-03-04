package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class GuiSettingsTest {

    @Test
    public void windowScene_defaultObject_widthReturned() {
        int defaultWidth = 900;
        assertEquals(defaultWidth, new GuiSettings().getWindowWidth());
    }

    @Test
    public void windowScene_defaultObject_heightReturned() {
        int defaultHeight = 800;
        assertEquals(defaultHeight, new GuiSettings().getWindowHeight());
    }

    @Test
    public void windowScene_defaultObject_nullReturned() {
        assertNull(new GuiSettings().getWindowCoordinates());
    }

    @Test
    public void imageView_defaultObject_heightReturned() {
        int defaultImageViewHeight = 35;
        assertEquals(defaultImageViewHeight, new GuiSettings().getImageViewHeight());
    }

    @Test
    public void imageView_defaultObject_widthReturned() {
        int defaultImageViewWidth = 40;
        assertEquals(defaultImageViewWidth, new GuiSettings().getImageViewWidth());
    }

    @Test
    public void circleShape_defaultObject_xCoordinatesReturned() {
        int defaultCircleXCoordinates = 17;
        assertEquals(defaultCircleXCoordinates, new GuiSettings().getCircleX());
    }

    @Test
    public void circleShape_defaultObject_yCoordinatesReturned() {
        int defaultCircleYCoordinates = 17;
        assertEquals(defaultCircleYCoordinates, new GuiSettings().getCircleY());
    }

    @Test
    public void circleShape_defaultObject_radiusReturned() {
        int defaultCircleRadius = 17;
        assertEquals(defaultCircleRadius, new GuiSettings().getCircleRadius());
    }

    @Test
    public void equalsMethod() {
        Object anotherObject = new Object();
        assertEquals(false, new GuiSettings().equals(anotherObject));
    }

    @Test
    public void hashMethod() {
        GuiSettings guiSettings = new GuiSettings();
        assertNotNull(guiSettings.hashCode());
    }
}
