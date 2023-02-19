package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Performance;
import seedu.address.model.person.Person;


/**
 * Changes the remark of an existing person in the address book.
 */
public class PerformanceCommand extends Command {

    public static final String COMMAND_WORD = "performance";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the performance of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing performance will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "r/ [PERFORMANCE]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "r/ 5";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "Performance command not implemented yet";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Performance: %1$d";

    public static final String MESSAGE_ADD_PERFORMANCE_SUCCESS = "Added performance to Person: %1$d";
    public static final String MESSAGE_DELETE_PERFORMANCE_SUCCESS = "Removed performance from Person: %1$d";

    private final Index index;
    private final Performance performance;

    /**
     * @param index of the person in the filtered person list to edit the remark
     * @param performance of the person to be updated to
     */
    public PerformanceCommand(Index index, Performance performance) {
        requireAllNonNull(index, performance);

        this.index = index;
        this.performance = performance;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = new Person(
                personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), personToEdit.getRemark(), performance, personToEdit.getTags());

        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(PREDICATE_SHOW_ALL_PERSONS);

        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    /**
     * Generates a command execution success message based on whether
     * the remark is added to or removed from
     * {@code personToEdit}.
     */
    private String generateSuccessMessage(Person personToEdit) {
        String message = performance.value != null ? MESSAGE_ADD_PERFORMANCE_SUCCESS
                : MESSAGE_DELETE_PERFORMANCE_SUCCESS;
        return String.format(message, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof RemarkCommand)) {
            return false;
        }

        // state check
        PerformanceCommand e = (PerformanceCommand) other;
        return index.equals(e.index)
                && performance.equals(e.performance);
    }
}
