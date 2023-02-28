package seedu.duke.command;

import seedu.duke.book.Book;
import seedu.duke.storage.Storage;

import java.io.File;
import java.util.ArrayList;

public class HelpCommand extends Command {
    /**
     * Shows the commands used in the Librarian application.
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
        System.out.println("--- THE LIBRARIAN COMMANDS ---\n\n" +
                "TERMINATING THE PROGRAM\n" +
                "   syntax: exit/\n" +
                "   shortcut: e/\n" +
                "\n" +
                "CHECKING THE COMMANDS\n" +
                "   syntax: help/\n" +
                "   shortcut: h/\n" +
                "\n" +
                "CHECKING THE LIBRARY\n" +
                "   syntax: list/library\n" +
                "   shortcut: l/l\n" +
                "\n" +
                "CHECKING YOUR ACCOUNT\n" +
                "   syntax: list/user\n" +
                "   shortcut: l/u\n" +
                "\n" +
                "BORROWING A BOOK\n" +
                "   syntax: borrow/<book_title>\n" +
                "   shortcut: b/<book_title>\n" +
                "   example: borrow/clean code\n" +
                "\n" +
                "RETURNING A BOOK\n" +
                "   syntax: return/<book_title>\n" +
                "   shortcut: r/<book_title>\n" +
                "   example: return/clean code\n" +
                "\n" +
                "SEARCHING BOOK(S) BY TITLE\n" +
                "   syntax: search/title/<keyword(s)>\n" +
                "   shortcut: s/t/<keyword(s)>\n" +
                "   example: search/title/work\n" +
                "\n" +
                "SEARCHING BOOK(S) BY AUTHOR\n" +
                "   syntax: search/author/<keyword(s)>\n" +
                "   shortcut: s/a/<keyword(s)>\n" +
                "   example: search/author/reddy\n" +
                "\n" +
                "SEARCHING BOOK(S) BY CATEGORY\n" +
                "   syntax: search/category/<keyword(s)>\n" +
                "   shortcut: s/c/<keyword(s)>\n" +
                "   example: search/category/programming");
    }

    @Override
    public boolean setIsExit() {
        return isExit = false;
    }
}
