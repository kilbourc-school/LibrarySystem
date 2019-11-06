import java.util.LinkedList;

public class EBook extends Book {

    EBook() {
        super();
    }

    public EBook(String title, String description, String author, String subject, int copies, String genre, int releaseYear, boolean comingSoon, LinkedList<iDandCopies> currentBorrowerID, LinkedList<iDandCopies> waitListBorrowerIDs, LinkedList<Ratings> ratings, String ISBN) {
        super(title, description, author, subject, copies, genre, releaseYear, comingSoon, currentBorrowerID, waitListBorrowerIDs, ratings, ISBN);
    }

    /*
            Returns ISBN Value
             */
    /*
    Converts objects into strings
     */
    public String toStringList() {
        return "EBook," +super.toStringList();
    }

    @Override
        /*
        /Converts object to String.
         */
    public String toString() {
        return title + " by: " + author + " genre: " + genre + " ISBN: " + ISBN + " copies: " + copies;
    }


}
