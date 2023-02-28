package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>ExitCommand</code> class is a class for terminating
 * the Librarian application.
 */
public class ExitCommand extends Command {
    /**
     * Terminates the Librarian application.
     *
     * @param user username (case-sensitive) of the current user.
     * @param userInput query typed in by the user.
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param storage class that ensures consistency of the record.
     * @param file represents the txt file that keeps the library record.
     */
    @Override
    public void execute(String user, String userInput,
                        ArrayList<Book> bookList, Storage storage,
                        File file) {
        System.out.println("Bye. Hope to see you again soon!");
    }

    @Override
    public boolean setIsExit() {
        return isExit = true;
    }
}
