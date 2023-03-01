package seedu.address.commons.core;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

public class GuiSettingsTest {

    @Test
    public void getWindowWidth_defaultObject_widthReturned() {
        int defaultWidth = 800;
        assertEquals(defaultWidth, new GuiSettings().getWindowWidth());
    }

    @Test
    public void getWindowHeight_defaultObject_HeightReturned() {
        int defaultHeight = 900;
        assertEquals(defaultHeight, new GuiSettings().getWindowHeight());
    }

    @Test
    public void getWindowCoordinates_defaultObject_NullReturned() {
        assertNull(new GuiSettings().getWindowCoordinates());
    }

    @Test
    public void getImageViewHeight_defaultObject_HeightReturned() {
        int defaultImageViewHeight = 35;
        assertEquals(defaultImageViewHeight, new GuiSettings().getImageViewHeight());
    }

    @Test
    public void getImageViewWidth_defaultObject_WidthReturned() {
        int defaultImageViewWidth = 40;
        assertEquals(defaultImageViewWidth, new GuiSettings().getImageViewWidth());
    }

    @Test
    public void getCircleXCoordinates_defaultObject_XCoordinatesReturned() {
        int defaultCircleXCoordinates = 17;
        assertEquals(defaultCircleXCoordinates, new GuiSettings().getCircleX());
    }

    @Test
    public void getCircleYCoordinates_defaultObject_YCoordinatesReturned() {
        int defaultCircleYCoordinates = 17;
        assertEquals(defaultCircleYCoordinates, new GuiSettings().getCircleY());
    }

    @Test
    public void getCircleRadius_defaultObject_RadiusReturned() {
        int defaultCircleRadius = 17;
        assertEquals(defaultCircleRadius, new GuiSettings().getCircleRadius());
    }
}
