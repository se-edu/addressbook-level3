package seedu.address.ui;

import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.person.Person;

/**
 * Panel containing the list of persons.
 */
public class PersonListPanel extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Person> personListViewLeftCol;
    @FXML
    private ListView<Person> personListViewMidCol;
    @FXML
    private ListView<Person> personListViewRightCol;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);
        //Split into different group later
        int skip = 3;
        int size = personList.size();
// Limit to carefully avoid IndexOutOfBoundsException
        int limit = size / skip + Math.min(size % skip, 1);

        ObservableList<Person> filteredPersonList = Stream.iterate(0, i -> i + skip)
                .limit(limit)
                .map(personList::get)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        //Ensure no duplicate when skip especially if only have less than 6 etc
        personListViewLeftCol.setItems(filteredPersonList);
        personListViewLeftCol.setCellFactory(listView -> new PersonListViewCell());

        filteredPersonList = Stream.iterate(1, i -> i + skip)
                .limit(limit)
                .map(personList::get)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        personListViewMidCol.setItems(filteredPersonList);
        personListViewMidCol.setCellFactory(listView -> new PersonListViewCell());

        filteredPersonList = Stream.iterate(2, i -> i + skip)
                .limit(limit)
                .map(personList::get)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        personListViewRightCol.setItems(filteredPersonList);
        personListViewRightCol.setCellFactory(listView -> new PersonListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Person} using a {@code PersonCard}.
     */
    class PersonListViewCell extends ListCell<Person> {
        @Override
        protected void updateItem(Person person, boolean empty) {
            super.updateItem(person, empty);

            if (empty || person == null) {
                setGraphic(null);
                setText(null);
            } else {
                setGraphic(new PersonCard(person, getIndex() + 1).getRoot());
            }
        }
    }

}
