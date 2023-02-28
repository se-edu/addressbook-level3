package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>ReserveCommand</code> class reserves the requested book to the
 * user by adding its username to the list of borrowers.
 */
public class ReserveCommand extends Command {
    /**
     * Reserves the requested book to the user.
     *
     * @param user username (case-sensitive) of the current user.
     * @param userInput query typed in by the user.
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param storage class that ensures consistency of the record.
     * @param file represents the txt file that keeps the library record.
     */
    @Override
    public void execute(String user, String userInput, ArrayList<Book> bookList, Storage storage,
                        File file) throws DukeException {
        String title = userInput.split("/")[1].trim();
        int bookIndex = 0;

        if (isInLibrary(bookList, title)) {
            for (int i = 0; i < bookList.size(); i++) {
                if (title.equalsIgnoreCase(bookList.get(i).getTitle())) {
                    bookIndex = i;
                }
            }

            if (!bookList.get(bookIndex).isOnShelf()) {

                bookList.get(bookIndex).getBorrower().add(user);
                bookList.get(bookIndex).setOnShelf(false);
                storage.updateLibrary(bookList, file);

                System.out.println("The book has been reserved to your account!");
            } else {
                throw new DukeException("The book is available on-shelf! You can borrow it instead.");
            }
        } else {
            throw new DukeException("We do not carry this book in the Library! Please try other books.");
        }
    }

    /**
     * Checks if the requested book is available in the library.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param title title of the book that is being requested or borrowed.
     */
    public boolean isInLibrary(ArrayList<Book> bookList, String title) {
        for (int i = 0; i < bookList.size(); i++) {
            if (title.equalsIgnoreCase(bookList.get(i).getTitle())) {
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

