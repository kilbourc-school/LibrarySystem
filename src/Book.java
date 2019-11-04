
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

import java.util.LinkedList;

public class Book extends Media implements Medium {
    int ISBN;


    /*
     * Constructor.
     * Params: Strings ISBN, title, author, genre.
     */
    public Book(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int ISBN) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon);
        this.ISBN = ISBN;
    }

    public Book(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, int ISBN) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon, currentBorrowerID, waitListBorrowerIDs);
        this.ISBN = ISBN;
    }

    public Book(Media media) {
        this.title = media.getTitle();
        this.description = media.getDescription();
        this.author = media.getAuthor();
        this.subject = media.getSubject();
        this.copies = media.getCopies();
        this.genre = media.getGenre();
        this.releaseYear = media.getReleaseYear();
        this.stars = media.getStars();
        this.comingSoon = media.isComingSoon();
        this.currentBorrowerID = new LinkedList<>();
        this.waitListBorrowerIDs = new LinkedList<>();
        currentBorrowerID.add(new iDandCopies((long) 0,0));
        waitListBorrowerIDs.add((new iDandCopies((long) 0,0)));
    }

    public Book() {
        super();
    }

    /*
    returns isbn value
     */
    public int getISBN() {
        return ISBN;
    }

    /*
     sets isbn
     */
    public void setISBN(String ISBN) {
        int x = 0;
        try {
            x = Integer.parseInt(ISBN);
        } catch (Exception e) {
            System.out.println("Input not of type int, ISBN set to 0");
        }
        this.ISBN = x;
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
