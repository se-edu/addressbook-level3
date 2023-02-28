package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>ListUserCommand</code> allows the user to see all the books that he
 * currently borrowed.
 */
public class ListUserCommand extends Command {
    /**
     * Prints out all the books in the library to the CLI. These books are
     * currently borrowed by and specific to the user.
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
        if (didUserBorrow(bookList, user)) {
            System.out.println("Here are the borrowed books in your account:");

            for (int i = 0; i < bookList.size(); i++) {
                if (!bookList.get(i).getBorrower().isEmpty() && user.equals(bookList.get(i).getBorrower().get(0))) {
                    System.out.println("\n" + bookList.get(i));
                }
            }

        } else {
            throw new DukeException("Your account is cleared from any borrowed book(s).");
        }
    }

    /**
     * Checks whether the user borrow at least 1 book.
     *
     * @param user username (case-sensitive) of the current user.
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     */
    public boolean didUserBorrow (ArrayList<Book> bookList, String user) {
        for (int i = 0; i < bookList.size(); i++) {
            if (!bookList.get(i).getBorrower().isEmpty() && user.equals(bookList.get(i).getBorrower().get(0))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
