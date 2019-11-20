import org.junit.jupiter.api.*;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

class MediaTest {
    String title = "The Cat in the Hat";
    String description = "cats wear hats";
    String author = "seuss";
    String subject = "kiddie";
    int copies = 3;
    String genre = "kiddo";
    int releaseYear = 1974;
    boolean comingSoon = false;
    LinkedList<iDandCopies> currentBorrowerID;
    LinkedList<iDandCopies> waitListBorrowerIDs;
    LinkedList<Ratings> ratings;
    String ISBN = "1927345";
    @AfterAll
    static void oneTimeTearDown() {
    }

    @AfterEach
    void tearDown() {
    }

    @BeforeAll
    static void oneTimeSetUp() {
    }

    @BeforeEach
    void setUp() {

        Book book = new Book(title,description,author,subject,copies,genre,releaseYear, comingSoon, currentBorrowerID,waitListBorrowerIDs,ratings, ISBN);
    }

    @Test
    void getDueDate() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book (title,description,author,subject,copies,genre,releaseYear,comingSoon,ISBN);
        assertEqual(book.getDueDate(),localDate.now );
    }

    @Test
    void checkOutMedia() {
    }

    @Test
    void getCheckoutLimit() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book (title,  description,  author,  subject,  copies,  genre,  releaseYear, comingSoon,ISBN);
        assertEqual();
    }

    @Test
    void getCurrentBorrowerID() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book (title,description,author,subject,copies,genre,releaseYear,comingSoon,ISBN);
        assertEqual(book.getCurrentBorrowerID(),);
    }

    @Test
    void checkInMedia() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book ( title,  description,  author,  subject,  copies,  genre,  releaseYear, comingSoon,ISBN);
    }

    @Test
    void getTitle() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book ( title,  description,  author,  subject,  copies,  genre,  releaseYear, comingSoon,ISBN);
        assertEqual(book.getTitle(),"The Cat in the Hat");
    }

    @Test
    void getAuthor() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book ( title,  description,  author,  subject,  copies,  genre,  releaseYear, comingSoon,ISBN);
        assertEqual(book.getTitle(),"seuss");
    }

    @Test
    void getCopies() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book ( title,  description,  author,  subject,  copies,  genre,  releaseYear, comingSoon,ISBN);
        assertEqual(book.getCopies(),3);
    }

    @Test
    void getGenre() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book ( title,  description,  author,  subject,  copies,  genre,  releaseYear, comingSoon,ISBN);
        assertEqual(book.getGenre(),"kiddo");
    }

    @Test
    void getAvailability() {
        LinkedList<iDandCopies> currentBorrowerID = new LinkedList<iDandCopies>();
        LinkedList<iDandCopies> waitListBorrowerIDs = new LinkedList<iDandCopies>();
        LinkedList<Ratings> ratings = new LinkedList<Ratings>();
        Book book = new Book ( title,  description,  author,  subject,  copies,  genre,  releaseYear, comingSoon,ISBN);
        assertEqual(book.getAvailability(),);
    }

    @Test
    void toStringList() {
    }
}