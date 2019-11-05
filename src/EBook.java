import java.util.LinkedList;

public class EBook extends Book{

    EBook(){super();}
    public EBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, int ISBN) {
        super(title, description, author, subject, copies, genre, releaseYear, stars, comingSoon, currentBorrowerID, waitListBorrowerIDs, ISBN);
    }

    /*
        Returns ISBN Value
         */
    public int getISBN() {
        return ISBN;
    }

    /*
    Converts objects into strings
     */
    public String toStringList() {
        return "EBook," + title + "," + description + "," + author + "," + subject + "," + copies + "," + genre + "," + releaseYear + "," + stars + "," + comingSoon + "," + ISBN;
    }

    @Override
        /*
        /Converts object to String.
         */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
    }


}
