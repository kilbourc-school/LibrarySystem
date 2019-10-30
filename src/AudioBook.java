/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

public class AudioBook extends Media implements Medium {
    String narrator;

    /*
     * Constructor.
     * Params: String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int iSBN){
    title, description, author, subject, copies, genre, releaseYear, stars, comingSoon
     */
    public AudioBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int iSBN) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon);
        this.narrator = narrator;
    }
    public AudioBook(Media media){
        this.title = media.getTitle();
        this.description = media.getDescription();
        this.author = media.getAuthor();
        this.subject = media.getSubject();
        this.copies = media.getCopies();
        this.genre = media.getGenre();
        this.releaseYear = media.getReleaseYear();
        this.stars = media.getStars();
        this.comingSoon = media.isComingSoon();
    }
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
    Returns ISBN Value
     */
    public int getISBN() {
        return ISBN;
    }

    /*
    Converts objects to strings
    */
    public String toStringList() {
        return "AudioBook," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + narrator;
    }
    public String getNarrator() {
        return narrator;
    }
    @Override
        /*
        /Converts object to String.
         */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
    }
}

