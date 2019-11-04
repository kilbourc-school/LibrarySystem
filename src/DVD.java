
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

import java.util.LinkedList;

public class DVD extends Media implements Medium {


    /*
     * Constructor.
     * Params: String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator
       super: title, description, author, subject, copies, genre, releaseYear, stars, comingSoon (calls from borrower)
     */
    public DVD(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon);
    }

    public DVD(Media media) {
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
        waitListBorrowerIDs.add((new iDandCopies((long) 0,0)));    }

    /*
     converts objects into strings
     */
    public String toStringList() {
        return "DVD," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + ",";
    }

    public DVD(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon, currentBorrowerID, waitListBorrowerIDs);
    }

    @Override
    /*
    Converts object to String.
     */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + " copies: " + copies;
    }


}