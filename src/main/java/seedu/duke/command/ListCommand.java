package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>ListCommand</code> allows the user to see all the books in the Library.
 * It includes the details specific to the book and its current availability.
 */
public class ListCommand extends Command {
    /**
     * Prints out all the books in the library to the CLI. If the library.txt
     * is empty, a <code>DukeException</code> is thrown.
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
                        File file) throws DukeException {
        if (bookList.isEmpty()) {
            throw new DukeException("There are no books available " +
                    "in the library at the moment.");
        } else {
            System.out.println("Here are the book(s) in the library:");
            for (int i = 0; i < bookList.size(); i++) {
                System.out.println("\n" + bookList.get(i));
            }
        }
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
