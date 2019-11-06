
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

import java.util.LinkedList;

public class DVD extends Media {
    int checkoutLimit = 21;//subtract from current date based on expected date for if late


/*
     * Constructor.
     * Params: String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator
       super: title, description, author, subject, copies, genre, releaseYear, stars, comingSoon (calls from borrower)
     */

    public DVD(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, LinkedList<Ratings> ratings) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon, currentBorrowerID, waitListBorrowerIDs, ratings);
    }

    public DVD() {
        super();
    }

    /*
     converts objects into strings
     */
    public String toStringList() {
        return "DVD," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + ",";
    }

    @Override
    public int getCheckoutLimit() {
        return checkoutLimit;
    }

    public void setCheckoutLimit(int checkoutLimit) {
        this.checkoutLimit = checkoutLimit;
    }

    @Override
    /*
    Converts object to String.
     */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + " copies: " + copies;
    }


}