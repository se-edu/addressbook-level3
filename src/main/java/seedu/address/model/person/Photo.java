package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents a Person's photo in the address book.
 * Guarantees: immutable; is always valid
 */
public class Photo {
    public final String photoFilePath;
    private int height;
    private int width;
    private int circleX;
    private int circleY;
    private int radius;

    /**
     * Accepts photo that is not empty
     * @param photoFilePath String of filepath
     */
    public Photo(String photoFilePath) {
        requireNonNull(photoFilePath);
        this.photoFilePath = photoFilePath;
        setDimensions();
    }

    /**
     * Sets the necessary dimensions of the Image and the circle that crops that image
     */
    void setDimensions() {
        GuiSettings guiSettings = new GuiSettings();
        this.height = guiSettings.getImageViewHeight();
        this.width = guiSettings.getImageViewWidth();
        this.circleX = guiSettings.getCircleX();
        this.circleY = guiSettings.getCircleY();
        this.radius = guiSettings.getCircleRadius();
    }

    //No setters to customise profile picture dimensions in this iteration

    /**
     * Gets the height of the Image
     * @return height
     */
    public int getHeight() {
        return this.height;
    }

    /**
     * Gets the width of the Image
     * @return width
     */
    public int getWidth() {
        return this.width;
    }

    /**
     * Gets the X coordinate of the circle that crops the image
     * @return circleX
     */
    public int getCircleX() {
        return this.circleX;
    }

    /**
     * Gets the Y coordinate of the circle that crops the image
     * @return circleY
     */
    public int getCircleY() {
        return this.circleY;
    }

    /**
     * Gets the radius of the circle that crops the image
     * @return radius
     */
    public int getCircleRadius() {
        return this.radius;
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
