package seedu.address.ui;

import java.util.Comparator;
import java.util.Objects;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
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

    //Change to actual number when merge
    private final int numberOfStudents = 5;
    //private ImageView profile = new ImageView();

    @FXML
    private HBox cardPane;
    @FXML
    private HBox studentProfiles;
    @FXML
    private ImageView header;
    @FXML
    private ImageView header1;
    @FXML
    private ImageView header2;
    @FXML
    private ImageView header3;
    @FXML
    private Label name;
    @FXML
    private Label id;
    @FXML
    private Label phone;
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

        setStudentProfiles();

        id.setText(displayedIndex + ". ");
        name.setText(person.getName().fullName);
        phone.setText(person.getPhone().value);
        address.setText(person.getAddress().value);
        email.setText(person.getEmail().value);
        remark.setText(person.getRemark().value);
        performance.setText(person.getPerformance().value);
        person.getTags().stream()
                .sorted(Comparator.comparing(tag -> tag.tagName))
                .forEach(tag -> tags.getChildren().add(new Label(tag.tagName)));
    }

    //Dummy temporary student profile and number of students
    void setStudentProfiles() {
        int shift = 100;
        int multiply = 10;
        int height = 65;
        int width = 70;
        int circleX = 40;
        int circleY = 20;
        int radius = 20;
        Image studentImage =
                new Image(Objects.requireNonNull(this.getClass().getResourceAsStream("/images/student.png")));
        for (int i=1; i<numberOfStudents;i++) {
            ImageView profile = new ImageView();
            profile.setImage(studentImage);
            profile.setFitHeight(height);
            profile.setFitWidth(width);
            profile.setX(profile.getX() + (i));
            circleX = circleX + (i);
            profile.setClip(new Circle(circleX, circleY, radius));
            studentProfiles.getChildren().addAll(profile);
        }
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
