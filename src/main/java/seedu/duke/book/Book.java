package seedu.duke.book;

import java.util.ArrayList;

/**
 * <code>Book</code> class represents all the information of a book including
 * its availability and who checks it out.
 */
public class Book {

    protected String title;
    protected String author;
    protected String edition;
    protected String published;
    protected String category;
    protected boolean onShelf;
    protected ArrayList<String> borrower;

    public Book(String title, String author, String edition,
                String published, String category, boolean onShelf, ArrayList<String> borrower) {
        this.title = title;
        this.author = author;
        this.edition = edition;
        this.published = published;
        this.category = category;
        this.onShelf = onShelf;
        this.borrower = borrower;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    }
    public String getCategory() {
        return category;
    }
    public boolean isOnShelf() {
        return onShelf;
    }
    public void setOnShelf(boolean onShelf) {
        this.onShelf = onShelf;
    }
    public ArrayList<String> getBorrower() {
        return borrower;
    }

    @Override
    public String toString() {
        return "Title: " + title + "\n" + "Author: " + author + "\n" +
                "Edition: " + edition + "\n" + "Published: " +
                published + "\n" + "Category: " + category + "\n" +
                "On-shelf: " + onShelf + "\n" + "Borrower: " + borrower;
    }
}

