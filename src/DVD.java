
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

public class DVD extends Media{


    /*
     * Constructor.
     * Params: String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator
       super: title, description, author, subject, copies, genre, releaseYear, stars, comingSoon (calls from borrower)
     */
    public DVD(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon) {
        super(title, description, author,subject,copies, genre, releaseYear,stars, comingSoon);
    }

    public DVD(){
       super();
    }

    /*
     converts objects into strings
     */
    public String toStringList() {
        return "DVD," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + ",";
    }

    @Override
    /*
    Converts object to String.
     */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + " copies: " + copies;
    }


}