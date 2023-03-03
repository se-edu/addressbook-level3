package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.core.GuiSettings;

/**
 * Represents a Person's remark in the address book.
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

    void setDimensions() {
        GuiSettings guiSettings = new GuiSettings();
        this.height = guiSettings.getImageViewHeight();
        this.width = guiSettings.getImageViewWidth();
        this.circleX = guiSettings.getCircleX();
        this.circleY = guiSettings.getCircleY();
        this.radius = guiSettings.getCircleRadius();
    }

    //No setters to customise profile picture dimensions in this iteration
    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int getCircleX() {
        return this.circleX;
    }

    public int getCircleY() {
        return this.circleY;
    }

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
