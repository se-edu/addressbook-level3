package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;
import static seedu.address.model.Model.PREDICATE_SHOW_ALL_PERSONS;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.Photo;

/**
 * Changes the remark of an existing person in the address book.
 */
public class PhotoCommand extends Command {

    public static final String COMMAND_WORD = "photo";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Edits the photo of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing photo will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "photo/ [PHOTO]\n"
            + "Example: " + COMMAND_WORD + " 1 "
            + "photo/ https://picsum.photos/id/342/200/300";

    public static final String MESSAGE_NOT_IMPLEMENTED_YET =
            "Photo command not implemented yet";

    public static final String MESSAGE_ARGUMENTS = "Index: %1$d, Photo: %2$s";

    public static final String MESSAGE_ADD_PHOTO_SUCCESS = "Added photo to Person: %1$s";
    public static final String MESSAGE_DELETE_PHOTO_SUCCESS = "Removed photo from Person: %1$s";

    private final Index index;
    private final Photo photo;

    /**
     * @param index of the person in the filtered person list to edit the photo
     * @param photo of the person to be updated to
     */
    public PhotoCommand(Index index, Photo photo) {
        requireAllNonNull(index, photo);

        this.index = index;
        this.photo = photo;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();

        if (index.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }

        Person personToEdit = lastShownList.get(index.getZeroBased());
        Person editedPerson = new Person(
                personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(), photo,
                personToEdit.getAddress(), personToEdit.getRemark(), personToEdit.getPerformance(),
                personToEdit.getTags());

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
        String message = !photo.photoFilePath.isEmpty() ? MESSAGE_ADD_PHOTO_SUCCESS : MESSAGE_DELETE_PHOTO_SUCCESS;
        return String.format(message, personToEdit);
    }

    @Override
    public boolean equals(Object other) {
        // short circuit if same object
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof PhotoCommand)) {
            return false;
        }

        // state check
        PhotoCommand e = (PhotoCommand) other;
        return index.equals(e.index)
                && photo.equals(e.photo);
    }
}
