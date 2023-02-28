package seedu.duke.storage;

import seedu.duke.book.Book;
import seedu.duke.exception.DukeException;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * <code>Storage</code> class handles the data transfer from the external txt file
 * to the resizeable <code>ArrayList</code> data structure, and vice-versa.
 */
public class Storage {
    private ArrayList<Book> bookList;

    public Storage(ArrayList<Book> bookList) {
        this.bookList = bookList;
    }

    public void loadFromLibrary(Path pathFile, ArrayList<Book> bookList) {
        try {
            File f = pathFile.toFile();
            Scanner s = new Scanner(f);
            StringBuilder input = new StringBuilder();
            boolean isEmpty = false;

            while (s.hasNext()) {
                isEmpty = true;
                String line = s.nextLine();

                if (line.length() == 0) {
                    addBook(input.toString());
                    input = new StringBuilder();
                } else {
                    input.append(line).append(" | ");
                }
            }

            if (isEmpty) {
                addBook(input.toString());

                System.out.println("There are " + bookList.size() +
                        " different book(s) in the library at the moment.\n");
            } else {
                System.out.println("There are no books available in the library at the moment.\n");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }

    public void addBook(String s) {
        String[] splitString = s.split(" \\| ");

        String title = splitString[0].substring(7);
        String author = splitString[1].substring(8);
        String edition = splitString[2].substring(9);
        String published = splitString[3].substring(11);
        String category = splitString[4].substring(10);
        boolean onShelf = Boolean.parseBoolean(splitString[5].substring(10));
        ArrayList<String> borrowers = loadBorrower(splitString[6].trim());

        bookList.add(new Book(title, author, edition, published, category, onShelf, borrowers));
    }

    public void updateLibrary(ArrayList<Book> bookList, File file) throws DukeException {
        try {
            PrintWriter pw = new PrintWriter(file);

            pw.print("");
            pw.close();

            for (int i = 0; i < bookList.size(); i++) {
                saveBookToLibrary(bookList.get(i), file);
            }
        } catch (IOException e) {
            throw new DukeException("Something went wrong: " + e.getMessage());
        }
    }

    public void saveBookToLibrary(Book book, File file) throws DukeException {
        try {
            Scanner s = new Scanner(file);
            FileWriter fw = new FileWriter(file, true);
            boolean taskFound = false;

            while (s.hasNext()) {
                if (s.nextLine().equals(book.toString())) {
                    taskFound = true;
                    break;
                }
            }

            if (!taskFound) {
                fw.write(book + "\n\n");
                fw.close();
            }
        } catch (IOException e) {
            throw new DukeException("Something went wrong: " + e.getMessage());
        }
    }

    public ArrayList<String> loadBorrower(String s) {
        ArrayList<String> borrowers = new ArrayList<>();
        String[] splitString = !s.substring(11, s.indexOf("]")).equals("") ?
                s.substring(11, s.indexOf("]")).trim().split(",") : new String[] {};

        for (int i = 0; i < splitString.length; i++) {
            borrowers.add(splitString[i].trim());
        }
        return borrowers;
    }
}
