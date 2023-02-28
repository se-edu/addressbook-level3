package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>Command</code> class is an abstract class for different functionality
 * of the Librarian application. A <code>Command</code> object may be substituted
 * with a specific command class such as <code>ListCommand</code>,
 * <code>BorrowCommand</code> or more.
 */
public abstract class Command {
    public static boolean isExit = false;

    /**
     * Refer to the individual command for <code>execute</code>> specific function.
     *
     * @param user username (case-sensitive) of the current user.
     * @param userInput query typed in by the user.
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param storage class that ensures consistency of the record.
     * @param file represents the txt file that keeps the library record.
     */
    public abstract void execute(String user, String userInput,
                                 ArrayList<Book> bookList, Storage storage,
                                 File file) throws DukeException;

    public abstract boolean setIsExit();
}

