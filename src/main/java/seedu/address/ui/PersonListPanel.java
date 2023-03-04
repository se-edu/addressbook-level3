package seedu.address.ui;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

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

    private List<ListView<Person>> listOfPersonListView;

    /**
     * Creates a {@code PersonListPanel} with the given {@code ObservableList}.
     */
    public PersonListPanel(List<ObservableList<Person>> personList) {
        super(FXML);

        listOfPersonListView = Arrays.asList(personListViewLeftCol, personListViewMidCol, personListViewRightCol);
        for (int i = 0; i < personList.size(); i++) {
            ObservableList<Person> filteredPersonList = personList.get(i);
            listOfPersonListView.get(i).setItems(filteredPersonList);
            listOfPersonListView.get(i).setCellFactory(listView -> new PersonListViewCell());
        }
        //bindListViewsScroll();
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
