package seedu.address.logic.commands;

import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
public class getAllTags extends Command{
    public static final String COMMAND_WORD = "tags";
    public static final String MESSAGE_TAGS = "Getting all tags ...";
    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_TAGS, false, false);
    }

    public static void main(String[] args) {
//        console.log(UniquePersonList.getInternalList());
    }

}
