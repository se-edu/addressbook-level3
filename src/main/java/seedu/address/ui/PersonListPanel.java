package seedu.address.ui;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
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
    public PersonListPanel(ObservableList<Person> personList) {
        super(FXML);

        listOfPersonListView = Arrays.asList(personListViewLeftCol, personListViewMidCol, personListViewRightCol);
        for (int i = 0; i < 3; i++) {
            ObservableList<Person> filteredPersonList = filterPersonList(personList, i);
            populatePersonListView(listOfPersonListView.get(i), filteredPersonList);
        }
        //bindListViewsScroll();
    }

    ObservableList<Person> filterPersonList(ObservableList<Person> personList, int index) {
        int skip = 3;
        int size = personList.size() - index;
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

    //To add in next push
    void bindListViewsScroll() {

        Node n1 = personListViewLeftCol;
        //Node n2 = personListViewMidCol.lookup(".scroll-bar");
        //Node n3 = personListViewRightCol.lookup(".scroll-bar");

        ScrollBar bar1 = (ScrollBar) personListViewLeftCol.lookup(".scroll-bar:vertical");
        ScrollBar bar2 = (ScrollBar) personListViewMidCol.lookup(".scroll-bar:vertical");
        ScrollBar bar3 = (ScrollBar) personListViewRightCol.lookup(".scroll-bar:vertical");

        bar1.valueProperty().bindBidirectional(bar2.valueProperty());
        bar1.valueProperty().bindBidirectional(bar3.valueProperty());

        bar2.valueProperty().bindBidirectional(bar1.valueProperty());
        bar2.valueProperty().bindBidirectional(bar3.valueProperty());

        bar3.valueProperty().bindBidirectional(bar1.valueProperty());
        bar3.valueProperty().bindBidirectional(bar2.valueProperty());

        /*
        if (n1 instanceof ScrollBar) {
            final ScrollBar bar1 = (ScrollBar) n1;
            Node n2 = personListViewMidCol.lookup(".scroll-bar");
            if (n2 instanceof ScrollBar) {
                final ScrollBar bar2 = (ScrollBar) n2;
                Node n3 = personListViewRightCol.lookup(".scroll-bar");
                if (n3 instanceof ScrollBar) {
                    final ScrollBar bar3 = (ScrollBar) n3;
                }
                bar1.valueProperty().bindBidirectional(bar2.valueProperty());
            }
        }
        */
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
