package seedu.address.ui;

import java.util.Arrays;
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
public class GreetingBar extends UiPart<Region> {
    private static final String FXML = "PersonListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(PersonListPanel.class);

    @FXML
    private ListView<Person> personListViewLeftCol;
    @FXML
    private ListView<Person> personListViewMidCol;
    @FXML
    private ListView<Person> personListViewRightCol;

    List<ListView<Person>> listOfPersonListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public GreetingBar(ObservableList<Person> personList) {
        super(FXML);
        listOfPersonListView = Arrays.asList(personListViewLeftCol, personListViewMidCol, personListViewRightCol);
        for (int i = 0; i < 3; i++) {
            ObservableList<Person> filteredPersonList = filterPersonList(personList, i);
            populatePersonListView(listOfPersonListView.get(i), filteredPersonList);
        }
    }

    ObservableList<Person> filterPersonList(ObservableList<Person> personList, int index) {
        int skip = 3;
        int size = personList.size();
        int limit = size / skip + Math.min(size % skip, 1);

        ObservableList<Person> filteredPersonList = Stream.iterate(index, i -> i + skip)
                .limit(limit)
                .map(personList::get)
                .collect(Collectors.toCollection(FXCollections::observableArrayList));

        return filteredPersonList;
    }

    void populatePersonListView(ListView<Person> personListView, ObservableList<Person> filteredPersonList) {
        personListView.setItems(filteredPersonList);
        personListView.setCellFactory(listView -> new PersonListViewCell());
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
