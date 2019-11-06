
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

import java.util.LinkedList;

public class Book extends Media {
    String ISBN;
    int checkOutLimit = 21;//subtract from current date based on expected date for if late


    /*
     * Constructor.
     * Params: Strings ISBN, title, author, genre.
     */
    public Book(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, LinkedList<Ratings> ratings, String ISBN) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon, currentBorrowerID, waitListBorrowerIDs, ratings);
        this.ISBN = ISBN;
    }

    public Book() {
        super();
        setISBN();
    }


    public int getCheckoutLimit() {
        return checkOutLimit;
    }

    public void setCheckOutLimit(int checkOutLimit) {
        this.checkOutLimit = checkOutLimit;
    }

    /*
        returns isbn value
         */
    public String getISBN() {
        return ISBN;
    }

    /*
     sets isbn
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setISBN() {
        System.out.print("ISBN: ");
        this.setISBN(keyboard.nextLine());
    }

    /*
     converts objects into strings
      */
    public String toStringList() {
        return "Book," + super.toStringList() + "," + ISBN;
    }

    @Override
    //Converts object to String.
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
    }


}
