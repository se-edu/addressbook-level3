package seedu.address.commons.core;

import java.awt.Point;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Serializable class that contains the GUI settings.
 * Guarantees: immutable.
 */
public class GuiSettings implements Serializable {

    private static final double DEFAULT_HEIGHT = 800;
    private static final double DEFAULT_WIDTH = 900;

    private static final int DEFAULT_IMAGEVIEW_HEIGHT = 35;
    private static final int DEFAULT_IMAGEVIEW_WIDTH = 40;

    private static final int DEFAULT_CIRCLE_X = 17;
    private static final int DEFAULT_CIRCLE_Y = 17;
    private static final int DEFAULT_CIRCLE_RADIUS = 17;

    private static final String DEFAULT_PHOTO_URL = "https://picsum.photos/id/443/200/300";

    private static final Point NULL_COORDINATE = null;

    private final double windowWidth;
    private final double windowHeight;
    private final Point windowCoordinates;
    private final int imageViewHeight;
    private final int imageViewWidth;
    private final int circleX;
    private final int circleY;
    private final int circleRadius;
    private final String photo;

    /**
     * Constructs a {@code GuiSettings} with the default height, width and position.
     */
    public GuiSettings() {
        windowWidth = DEFAULT_WIDTH;
        windowHeight = DEFAULT_HEIGHT;
        windowCoordinates = NULL_COORDINATE;
        imageViewHeight = DEFAULT_IMAGEVIEW_HEIGHT;
        imageViewWidth = DEFAULT_IMAGEVIEW_WIDTH;
        circleX = DEFAULT_CIRCLE_X;
        circleY = DEFAULT_CIRCLE_Y;
        circleRadius = DEFAULT_CIRCLE_RADIUS;
        photo = DEFAULT_PHOTO_URL;
    }

    //Allow user to modify student profile size in next iteration
    /**
     * Constructs a {@code GuiSettings} with the specified height, width and position but fixed student profile image
     */
    public GuiSettings(double windowWidth, double windowHeight, int xPosition, int yPosition) {
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        windowCoordinates = new Point(xPosition, yPosition);
        imageViewHeight = DEFAULT_IMAGEVIEW_HEIGHT;
        imageViewWidth = DEFAULT_IMAGEVIEW_WIDTH;
        circleX = DEFAULT_CIRCLE_X;
        circleY = DEFAULT_CIRCLE_Y;
        circleRadius = DEFAULT_CIRCLE_RADIUS;
        photo = DEFAULT_PHOTO_URL;
    }

    public double getWindowWidth() {
        return windowWidth;
    }

    public double getWindowHeight() {
        return windowHeight;
    }

    public Point getWindowCoordinates() {
        return windowCoordinates != null ? new Point(windowCoordinates) : null;
    }

    public int getImageViewHeight() {
        return imageViewHeight;
    }

    public int getImageViewWidth() {
        return imageViewWidth;
    }

    public int getCircleX() {
        return circleX;
    }

    public int getCircleY() {
        return circleY;
    }

    public int getCircleRadius() {
        return circleRadius;
    }

    public String getPhoto() {
        return photo;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof GuiSettings)) { //this handles null as well.
            return false;
        }

        GuiSettings o = (GuiSettings) other;

        return windowWidth == o.windowWidth
                && windowHeight == o.windowHeight
                && Objects.equals(windowCoordinates, o.windowCoordinates);
    }

    @Override
    public int hashCode() {
        return Objects.hash(windowWidth, windowHeight, windowCoordinates);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Width : " + windowWidth + "\n");
        sb.append("Height : " + windowHeight + "\n");
        sb.append("Position : " + windowCoordinates);
        return sb.toString();
    }
}
