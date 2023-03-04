package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import java.net.URL;
import javax.imageio.ImageIO;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents a Person's photo in the address book.
 * Guarantees: immutable; is always valid
 */
public class Photo {

    public static final String MESSAGE_CONSTRAINTS = "Photo should be of the format https://valid_path "
            + "and adhere to the following constraints:\n"
            + "1. The url is a valid url \n"
            + "2. The url leads to a valid image";

    //Make it final to prevent unnecessary mutations
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
        GuiSettings guiSettings = new GuiSettings();

        //If the url is not a valid image, set it to the default image found in GuiSettings
        if (!isValidPhoto(photoFilePath)) {
            this.photoFilePath = guiSettings.getPhoto();
        } else {
            this.photoFilePath = photoFilePath;
        }

        setDefaultDimensions(guiSettings);
    }

    /**
     * Sets the necessary dimensions of the Image and the circle that crops that image
     */
    void setDefaultDimensions(GuiSettings guiSettings) {
        this.height = guiSettings.getImageViewHeight();
        this.width = guiSettings.getImageViewWidth();
        this.circleX = guiSettings.getCircleX();
        this.circleY = guiSettings.getCircleY();
        this.radius = guiSettings.getCircleRadius();
    }

    /**
     * Checks if the url provided is a valid image.
     * @param photoFilePath
     * @return boolean value if whether url is valid
     */
    public static boolean isValidPhoto(String photoFilePath) {
        try {
            ImageIO.read(new URL(photoFilePath));
        } catch (Exception e) {
            //If URL is not valid, set it to a default image icon
            return false;
        }
        return true;
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
