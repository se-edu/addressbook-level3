//package seedu.address.ui;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
////import static org.junit.jupiter.api.Assertions.assertNotNull;
//
//import org.junit.jupiter.api.Test;
//
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
//import javafx.embed.swing.JFXPanel;
//import javafx.scene.control.Label;
//import seedu.address.model.person.Person;
//import seedu.address.testutil.PersonBuilder;
//
//public class GreetingBarTest {
//
//    @Test
//    public void greetingBar_nullPersonList_zeroReturned() {
//        JFXPanel jfxPanel = new JFXPanel();
//        int size = 0;
//        assertEquals(size, new GreetingBar(null).getSize());
//    }
//
//    @Test
//    public void greetingBar_notNullPersonList_sizeReturned() {
//        int size = 1;
//        ObservableList<Person> personList = FXCollections.observableArrayList();
//        personList.add(new PersonBuilder().build());
//        GreetingBar barTest = new GreetingBar(personList);
//        //assertEquals(size, new GreetingBar(personList).getSize());
//    }
//
//    @Test
//    public void greetingBar_greetingLabel_newLabelReturned() {
//        int size = 1;
//        Label greetings = new Label("Hello, you have " + size + " tasks undone");
//        ObservableList<Person> personList = FXCollections.observableArrayList();
//        personList.add(new PersonBuilder().build());
//        GreetingBar greetingBar = new GreetingBar(personList);
//        greetingBar.setGreetingCounter(personList);
//        assertEquals(greetings, greetingBar.getGreetings());
//    }
//}
