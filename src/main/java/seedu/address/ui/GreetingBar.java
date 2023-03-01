package seedu.address.ui;

import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Informs the user on the number of undone tasks
 */
public class GreetingBar extends UiPart<Region> {
    private static final String FXML = "GreetingBar.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private Label greetings;

    private int size;

    /**
     * Displays the number of students / tasks
     * @param personList
     */
    public GreetingBar(ObservableList<Person> personList) {
        super(FXML);

        if (personList == null) {
            size = 0;
        } else {
            size = personList.size();
        }

        String greetingText = "Hello, you have " + size + " tasks undone";
        greetings.setText(greetingText);
    }
}
