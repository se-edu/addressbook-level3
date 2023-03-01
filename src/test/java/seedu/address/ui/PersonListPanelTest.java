package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class PersonListPanelTest {

    @Test
    public void personListPanel_notNullPersonList_filteredListReturned() {
        ObservableList<Person> personList = FXCollections.observableArrayList();
        personList.add(new PersonBuilder().build());
        assertNotNull(new PersonListPanel(personList).filterPersonList(personList, 0));
    }
}
