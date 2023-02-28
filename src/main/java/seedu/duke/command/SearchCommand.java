package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

/**
 * <code>SearchCommand</code> class provides end-users different ways to search
 * the library. Users searching provides keywords which target either the Title,
 * the Author or the Category of the book.
 */
public class SearchCommand extends Command {
    /**
     * Searches the library and prints out the book(s) which matches the
     * user-provided keywords.
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
        String by;
        String[] keywords;
        ArrayList<Book> relatedBooks = new ArrayList<>();

        try {
            by = userInput.split("/")[1].trim();
            keywords = userInput.split("/")[2].trim().split(",");

        } catch (ArrayIndexOutOfBoundsException e) {
            throw new DukeException("Refer to documentation for the command syntax: " + e.getMessage());
        }

        if (by.equalsIgnoreCase("Title") || by.equalsIgnoreCase("T")) {
            for (String keyword : keywords) {
                hasMatchingTitle(bookList, keyword.trim(), relatedBooks);
            }

            if (!relatedBooks.isEmpty()) {
                System.out.println("Here are the book(s) related to your keyword(s):");
                for (Book book : relatedBooks) {
                    System.out.println("\n" + book);
                }
            } else {
                throw new DukeException("No related books found. Try other keyword(s).");
            }
        } else if (by.equalsIgnoreCase("Author") || by.equalsIgnoreCase("A")) {
            for (String keyword : keywords) {
                hasMatchingAuthor(bookList, keyword.trim(), relatedBooks);
            }

            if (!relatedBooks.isEmpty()) {
                System.out.println("Here are the book(s) related to your keyword(s):");
                for (Book book : relatedBooks) {
                    System.out.println("\n" + book);
                }
            } else {
                throw new DukeException("No related books found. Try other keyword(s).");
            }
        } else if (by.equalsIgnoreCase("Category") || by.equalsIgnoreCase("C")) {
            for (String keyword : keywords) {
                hasMatchingCategory(bookList, keyword.trim(), relatedBooks);
            }

            if (!relatedBooks.isEmpty()) {
                System.out.println("Here are the book(s) related to your search keyword(s):");
                for (Book book : relatedBooks) {
                    System.out.println("\n" + book);
                }
            } else {
                throw new DukeException("No related books found. Try other keyword(s).");
            }
        }
    }

    /**
     * Populates book(s) related to keyword(s) by title.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     * @param relatedBooks a container for matching books.
     */
    public void hasMatchingTitle (ArrayList<Book> bookList, String keyword, ArrayList<Book> relatedBooks) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getTitle().toLowerCase().contains(keyword.toLowerCase()) &&
                    !relatedBooks.contains(bookList.get(i))) {
                relatedBooks.add(bookList.get(i));
            }
        }
    }

    /**
     * Populates book(s) related to keyword(s) by author.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     * @param relatedBooks a container for matching books.
     */
    public void hasMatchingAuthor (ArrayList<Book> bookList, String keyword, ArrayList<Book> relatedBooks) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getAuthor().toLowerCase().contains(keyword.toLowerCase()) &&
                    !relatedBooks.contains(bookList.get(i))) {
                relatedBooks.add(bookList.get(i));
            }
        }
    }

    /**
     * Populates book(s) related to keyword(s) by category.
     *
     * @param bookList <code>ArrayList</code> data structure of all the
     *                 books in the library.
     * @param keyword keyword provided by the end-user.
     * @param relatedBooks a container for matching books.
     */
    public void hasMatchingCategory (ArrayList<Book> bookList, String keyword, ArrayList<Book> relatedBooks) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getCategory().toLowerCase().contains(keyword.toLowerCase()) &&
                    !relatedBooks.contains(bookList.get(i))) {
                relatedBooks.add(bookList.get(i));
            }
        }
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
