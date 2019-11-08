/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

import java.time.LocalDate;
import java.util.LinkedList;

public class AudioBook extends Media {
    String narrator;


    int checkoutLimit = 21;//subtract from current date based on expected date for if late

    /*
     * Constructor.
     * Params: String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int iSBN){
    title, description, author, subject, copies, genre, releaseYear, stars, comingSoon
     */

    public AudioBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, LinkedList<Ratings> ratings, String narrator) {
        super(title, description, author, subject, copies, genre, releaseYear, comingSoon, currentBorrowerID, waitListBorrowerIDs, ratings);
        this.narrator = narrator;
    }


    public AudioBook() {
        super();
        setNarrator();
    }

    @Override
    public int getCheckoutLimit() {
        return checkoutLimit;
    }

    public void setCheckoutLimit(int checkoutLimit) {
        this.checkoutLimit = checkoutLimit;
    }

    /*
    Converts objects to strings
    */
    public String toStringList() {
        return "AudioBook," + super.toStringList()+"," + narrator;
    }

    public void setNarrator() {
        System.out.print("ISBN: ");
        this.setNarrator(keyboard.nextLine());
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String nar) {
        this.narrator = nar;
    }

    @Override
        /*
        /Converts object to String.
         */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " narrator: " + narrator + " copies: " + copies;
    }
}

