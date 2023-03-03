package seedu.address.ui;

import java.util.Comparator;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.shape.Circle;
import seedu.address.model.person.Person;

/**
 * An UI component that displays information of a {@code Person}.
 */
public class PersonCard extends UiPart<Region> {

    private static final String FXML = "PersonListCard.fxml";

    /**
     * Note: Certain keywords such as "location" and "resources" are reserved keywords in JavaFX.
     * As a consequence, UI elements' variable names cannot be set to such keywords
     * or an exception will be thrown by JavaFX during runtime.
     *
     * @see <a href="https://github.com/se-edu/addressbook-level4/issues/336">The issue on AddressBook level 4</a>
     */

    public final Person person;

    //Change to actual number in next iteration
    private final int numberOfStudents = 5;

    @FXML
    private HBox cardPane;
    @FXML
    private HBox studentProfiles;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
    @FXML
    private Label photo;
    @FXML
    private Label address;
    @FXML
    private Label email;
    @FXML
    private FlowPane tags;
    @FXML
    private Label remark;
    @FXML
    private Label performance;

    /**
     * Creates a {@code PersonCode} with the given {@code Person} and index to display.
     */
    public PersonCard(Person person, int displayedIndex) {
        super(FXML);
        this.person = person;

        //Retrieve the image url from the person object
        Image studentImage =
                new Image(person.getPhoto().photoFilePath);

        for (int i = 1; i < numberOfStudents; i++) {
            //Set the retrieved image url height and width
            ImageView profile = new ImageView();
            profile.setImage(studentImage);
            profile.setFitHeight(person.getPhoto().getHeight());
            profile.setFitWidth(person.getPhoto().getWidth());

            //Set the image circle crop dimensions
            Circle circleCrop = new Circle();
            circleCrop.setCenterX(person.getPhoto().getCircleX());
            circleCrop.setCenterY(person.getPhoto().getCircleY());
            circleCrop.setRadius(person.getPhoto().getCircleRadius());

            //Crop the image into a circle
            profile.setClip(circleCrop);

            //Add the cropped circle image into the dummy list
            studentProfiles.getChildren().addAll(profile);
        }

        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        email.setText(person.getEmail().value);
        photo.setText(person.getPhoto().photoFilePath);
        remark.setText(person.getRemark().value);
        performance.setText(person.getPerformance().value);
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PersonCard)) {
            return false;
        }

        // state check
        PersonCard card = (PersonCard) other;
        return id.getText().equals(card.id.getText())
                && person.equals(card.person);
    }
}
