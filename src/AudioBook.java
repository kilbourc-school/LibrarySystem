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
    public AudioBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator) {
        this.title = title;
        this.description=description;
        this.author=author;
        this.subject=subject;
        this.copies=copies;
        this.genre=genre;
        this.releaseYear=releaseYear;
        this.stars=stars;
        this.comingSoon=comingSoon;
        this.narrator = narrator;
    }
    public AudioBook(){
        setTitle();
        setDescription();
        setAuthor();
        setSubject();
        setCopies();
        setGenre();
        setReleaseYear();
        setStars();
        comingSoon = true;
        setNarrator();
    }

    /*
    Converts objects to strings
    */
    public String toStringList() {
        return "AudioBook," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + narrator;
    }

    @Override
    public boolean isComingSoon() {
        return false;
    }

    public void setNarrator(String nar){
        this.narrator = nar;
    }

    public void setNarrator(){
        System.out.print("ISBN: ");
        this.setNarrator(keyboard.nextLine());
    }

    public String getNarrator() {
        return narrator;
    }
    @Override
        /*
        /Converts object to String.
         */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " narrator: " + narrator + " copies: " + copies;
    }
}

