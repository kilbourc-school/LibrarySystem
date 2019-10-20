
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

public class DVD extends Media implements Medium {


    /*
     * Constructor.
     * Params: Strings ISBN, title, author, genre.
     */
    public DVD(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon ){

        this.title = title;
        this.description = description;
        this.author = author;
        this.subject = subject;
        this.copies = copies;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.stars = stars;
        this.comingSoon = comingSoon;
    }




    public String toStringList(){
        return "book,"+ title + "," + description +  "," + author +  "," + subject +  "," + copies + "," + genre + "," + releaseYear + "," + stars + "," +comingSoon + ",";
    }

    @Override
    //Converts object to String.
    public String toString(){
        return title + " by: " + author + " genre: " + genre + " ISBN: " + " copies: " + copies;
    }


}