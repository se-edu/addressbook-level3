package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PERFORMANCE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PERFORMANCE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.CommandTestUtil.showPersonAtIndex;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Performance;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

/**
 * Contains integration tests (interaction with the Model) and unit tests for RemarkCommand.
 */
public class PerformanceCommandTest {

    private static final String PERFORMANCE_STUB = "1";

    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());

    @Test
    public void execute_addPerformanceUnfilteredList_success() {
        Person firstPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(firstPerson).withPerformance(PERFORMANCE_STUB).build();

        PerformanceCommand performanceCommand = new PerformanceCommand(INDEX_FIRST_PERSON,
                new Performance(editedPerson.getPerformance().value));

        String expectedMessage = String.format(PerformanceCommand.MESSAGE_ADD_PERFORMANCE_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstPerson, editedPerson);

        assertCommandSuccess(performanceCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_deletePerformanceUnfilteredList_success() {
        Person firstPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(firstPerson).withPerformance("").build();

        PerformanceCommand performanceCommand = new PerformanceCommand(INDEX_FIRST_PERSON,
                new Performance(editedPerson.getPerformance().toString()));

        String expectedMessage = String.format(PerformanceCommand.MESSAGE_DELETE_PERFORMANCE_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstPerson, editedPerson);

        assertCommandSuccess(performanceCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_filteredList_success() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);

        Person firstPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased()))
                .withPerformance(PERFORMANCE_STUB).build();

        PerformanceCommand performanceCommand = new PerformanceCommand(INDEX_FIRST_PERSON,
                new Performance(editedPerson.getPerformance().value));

        String expectedMessage = String.format(PerformanceCommand.MESSAGE_ADD_PERFORMANCE_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstPerson, editedPerson);

        assertCommandSuccess(performanceCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidPersonIndexUnfilteredList_failure() {
        Index outOfBoundIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        PerformanceCommand performanceCommand = new PerformanceCommand(outOfBoundIndex,
                new Performance(VALID_PERFORMANCE_BOB));

        assertCommandFailure(performanceCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    /**
     * Edit filtered list where index is larger than size of filtered list,
     * but smaller than size of address book
     */
    @Test
    public void execute_invalidPersonIndexFilteredList_failure() {
        showPersonAtIndex(model, INDEX_FIRST_PERSON);
        Index outOfBoundIndex = INDEX_SECOND_PERSON;
        // ensures that outOfBoundIndex is still in bounds of address book list
        assertTrue(outOfBoundIndex.getZeroBased() < model.getAddressBook().getPersonList().size());

        PerformanceCommand performanceCommand = new PerformanceCommand(outOfBoundIndex,
                new Performance(VALID_PERFORMANCE_BOB));

        assertCommandFailure(performanceCommand, model, Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
    }

    @Test
    public void equals() {
        final PerformanceCommand standardCommand = new PerformanceCommand(INDEX_FIRST_PERSON,
                new Performance(VALID_PERFORMANCE_AMY));

        // same values -> returns true
        PerformanceCommand commandWithSameValues = new PerformanceCommand(INDEX_FIRST_PERSON,
                new Performance(VALID_PERFORMANCE_AMY));
        assertTrue(standardCommand.equals(commandWithSameValues));

        // same object -> returns true
        assertTrue(standardCommand.equals(standardCommand));

        // null -> returns false
        assertFalse(standardCommand.equals(null));

        // different types -> returns false
        assertFalse(standardCommand.equals(new ClearCommand()));

        // different index -> returns false
        assertFalse(standardCommand.equals(new PerformanceCommand(INDEX_SECOND_PERSON,
                new Performance(VALID_PERFORMANCE_AMY))));

        // different remark -> returns false
        assertFalse(standardCommand.equals(new PerformanceCommand(INDEX_FIRST_PERSON,
                new Performance(VALID_PERFORMANCE_BOB))));
    }
}
