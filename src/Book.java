
/*
 * This is a class for book objects, which have unique
 * attributes like titles, authors, physical states,
 * and availibility.
 */

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
    public Book(Media){
        this.title = Media.getTitle();
        this.description = Media.getDescription();
        this.author = Media.getAuthor();
        this.subject = Media.getSubject();
        this.copies = Media.getCopies();
        this.genre = Media.getGenre();
        this.releaseYear = Media.getReleaseYear();
        this.stars = Media.getStars();
        this.comingSoon = Media.isComingSoon();
    }

    public Book() {
    }

    public int getISBN() {
        return ISBN;
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
     converts objects into strings
      */
    public String toStringList() {
        return "Book," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + ISBN;
    }

    @Override
    //Converts object to String.
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
    }


}
