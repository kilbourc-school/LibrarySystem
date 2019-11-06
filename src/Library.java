import java.time.LocalDate;

/**
 * This is the class that acts as the library, holding
 * the books and allowing interactions with the books
 * using methods to add, remove, borrow, return, and
 * browse the books.
 */

public class Library {
    Database libraryDatabase = new Database();
    private Borrower currentUser;

    public Library() {

    }

    public void saveAccountsToFile() {
        libraryDatabase.saveAccountsToFile();
    }

    public void saveMediaToFile() {
        libraryDatabase.saveMediaToFile();
    }

    public Borrower getCurrentUser() {
        return currentUser;
    }

    //Prints out the contents of the Library.
    public void displayBooks() {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            System.out.println(libraryDatabase.getMediaDatabase().get(i));
        }
    }

    //Prints out the teachers accounts
    public void displayTeachersAccounts() {

        for (Borrower account : libraryDatabase.getAccountsDatabase()) {
            if (account.getBorrowLimit() == 50)
                System.out.println(account);
        }
    }

    //Prints out the teachers accounts
    public void displayAdultAccounts() {

        for (Borrower account : libraryDatabase.getAccountsDatabase()) {
            if (account.getBorrowLimit() == 10)
                System.out.println(account);
        }
    }

    public Media getBookFromTitle(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            if (libraryDatabase.getMediaDatabase().get(i).getTitle().equals(title))
                return libraryDatabase.getMediaDatabase().get(i);
        }
        return null;
    }

    //Prints out the teachers accounts
    public void displayChildAccounts() {

        for (Borrower account : libraryDatabase.getAccountsDatabase()) {
            if (account.getBorrowLimit() == 3)
                System.out.println(account);
        }
    }

    public void displayAllAccounts() {

        for (Borrower account : libraryDatabase.getAccountsDatabase()) {
            System.out.println(account);
        }
    }


    public boolean verifyAccount(String email, String pass) {

        for (Borrower account : libraryDatabase.getAccountsDatabase()) {
            if (account.getEmail().equals(email) && account.getPassword().equals(pass)) {
                currentUser = account;
                return true;
            }
        }
        return false;
    }

    public void addBook() {
        Book book = new Book();
        libraryDatabase.getMediaDatabase().add(book);
    }

    public void addAudioBook() {
        AudioBook audioBook = new AudioBook();
        libraryDatabase.getMediaDatabase().add(audioBook);
    }

    public void addDVD() {
        DVD dvd = new DVD();
        libraryDatabase.getMediaDatabase().add(dvd);
    }

    public void addEBook() {
        EBook ebook = new EBook(); //null Book
        libraryDatabase.getMediaDatabase().add(ebook);
    }
    public void addMagazine(){
        Magazine magazine = new Magazine();
        libraryDatabase.getMediaDatabase().add(magazine);
    }

    /**
     * Method to determine if book in library is available.
     * Param: String with title or ISBN of book.
     * Return: String with status of book.
     */
    public void isAvailable(String input) {
        if (findMedia(input) != null) {
            if (findMedia(input).getAvailability())
                System.out.println(input + " is available.");
            else
                System.out.println(input + " is not available.");
        }
    }

    /**
     * Method to display all books of a genre in the library.
     * Param: String with the genre of a book.
     * Return: List of books in the same genre.
     */
    public void browseGenre(String genre) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String bookGenre = (libraryDatabase.getMediaDatabase().get(i)).getGenre();
            if (genre.equals(bookGenre)) {
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    public void browseTitle(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String bookTitle = (libraryDatabase.getMediaDatabase().get(i)).getTitle();

            if (bookTitle.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    public void addCopyByTitle(String title, int copies) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String bookTitle = (libraryDatabase.getMediaDatabase().get(i)).getTitle();
            if (title.equals(bookTitle)) {
                libraryDatabase.getMediaDatabase().get(i).setCopies(copies);
                break;
            } else {
                System.out.println("not found");
            }
        }
    }

    public void readInMedia() {
        libraryDatabase.readInMedia();
    }

    public void readInAccounts() {
        libraryDatabase.readInAccounts();
    }

    public void addTeacherAccount(Borrower borrower) { libraryDatabase.getAccountsDatabase().add(borrower); }

    public void addAdultAccount(Borrower borrower) {
        libraryDatabase.getAccountsDatabase().add(borrower);
    }

    public void addChildAccount(Borrower borrower) {
        libraryDatabase.getAccountsDatabase().add(borrower);
    }


    /**
     * Finds book object based on String. Basically converts
     * from String to Book.
     * Param: String containing title or ISBN
     * Return: Book object with a title or ISBN matching the input.
     */
    public Media findMedia(String input) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String str = (libraryDatabase.getMediaDatabase().get(i)).getTitle();     //Gets title of book at index.

            if (input.equals(str))
                return libraryDatabase.getMediaDatabase().get(i);
        }
        return null;
    }
}
