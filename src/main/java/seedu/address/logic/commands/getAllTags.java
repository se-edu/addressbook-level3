package seedu.address.logic.commands;

import javafx.collections.ObservableList;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.person.UniquePersonList;
import java.io.Console;
import java.util.HashSet;

public class getAllTags extends Command{
    public static final String COMMAND_WORD = "tags";
    public static final String MESSAGE_TAGS = "Getting all tags ...";
    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(MESSAGE_TAGS, false, false);
    }

    public static void main(String[] args) {
        UniquePersonList uniqueList = new UniquePersonList();
        HashSet<String> hashSet = new HashSet<String>();

        uniqueList.internalList.forEach(person ->  person.getTags().forEach(tag-> hashSet.add(tag.tagName)));
        System.out.print(hashSet);
        System.out.print(1);
//        console.log(UniquePersonList.getInternalList());
    }

}
