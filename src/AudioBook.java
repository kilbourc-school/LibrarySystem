/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

import java.util.LinkedList;

public class AudioBook extends Media {
    String narrator;

    /*
     * Constructor.
     * Params: String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int iSBN){
    title, description, author, subject, copies, genre, releaseYear, stars, comingSoon
     */
    public AudioBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon);
        this.narrator = narrator;
    }

    public AudioBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, String narrator) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon, currentBorrowerID, waitListBorrowerIDs);
        this.narrator = narrator;
    }

    public AudioBook(Media media) {
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
        currentBorrowerID.add(new iDandCopies((long) 0, 0));
        waitListBorrowerIDs.add((new iDandCopies((long) 0, 0)));
    }

    public AudioBook() {
        super();
        setNarrator();
    }

    /*
    Converts objects to strings
    */
    public String toStringList() {
        return "AudioBook," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + narrator;
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

