import java.time.LocalDate;
import java.util.Scanner;

/*
 *
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

    private static Media adminAddMedia(Media media) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Title: ");
        media.setTitle(keyboard.nextLine());
        System.out.print("Author: ");
        media.setAuthor(keyboard.nextLine());
        System.out.print("Description: ");
        media.setDescription(keyboard.nextLine());
        System.out.print("Subject: ");
        media.setSubject(keyboard.nextLine());
        System.out.print("Genre: ");
        media.setGenre(keyboard.nextLine());
        System.out.print("Number of Copies: ");
        media.setCopies(keyboard.nextLine());
        System.out.print("Release Year: ");
        media.setReleaseYear(keyboard.nextLine());
        System.out.print("Rating: ");
        media.setStars(keyboard.nextLine());
        return media;
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
public Media getBookFromTitle(String title){
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

    public String[] addMediaBase() {
        Scanner keyboard = new Scanner(System.in);
        String[] media = new String[9];
        media[0] = keyboard.nextLine(); //title
        media[1] = keyboard.nextLine();  //description
        media[2] = keyboard.nextLine(); //author
        media[3] = keyboard.nextLine(); //subject
        media[4] = keyboard.nextLine(); //copies
        media[5] = keyboard.nextLine(); //genre
        media[6] = keyboard.nextLine(); //releaseYear
        media[7] = keyboard.nextLine(); //stars
        media[8] = keyboard.nextLine(); //comingSoon
        return media;
    }

    public void addBook() {
        Scanner keyboard = new Scanner(System.in);
        Media media = new Media();
        Library.adminAddMedia(media);
        Book book = new Book(media);

        System.out.print("ISBN: ");
        book.setISBN(keyboard.nextLine());

        libraryDatabase.getMediaDatabase().add(book);
    }

    public void addAudioBook() {
        Scanner keyboard = new Scanner(System.in);
        Media media = new Media();
        Library.adminAddMedia(media);
        AudioBook audioBook = new AudioBook(media);

        System.out.print("ISBN: ");
        audioBook.setNarrator(keyboard.nextLine());

        libraryDatabase.getMediaDatabase().add(audioBook);
    }

    public void addDVD() {
        Scanner keyboard = new Scanner(System.in);
        Media media = new Media();
        Library.adminAddMedia(media);
        DVD dvd = new DVD(media);//null Book

        libraryDatabase.getMediaDatabase().add(dvd);
    }

    public void addEBook() {
        Scanner keyboard = new Scanner(System.in);
        Media media = new Media();
        Library.adminAddMedia(media);
        EBook ebook = new EBook(media); //null Book

        System.out.print("ISBN: ");
        ebook.setISBN(keyboard.nextLine());

        libraryDatabase.getMediaDatabase().add(ebook);
    }

    /*
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

    /*
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
            if (title.equals(bookTitle)) {
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

    public void addAdminAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, int cn, boolean isAdmin) {
        libraryDatabase.addAdminAccount(name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin);
    }

    public void addTeacherAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, int cn, boolean isAdmin) {
        libraryDatabase.addTeacherAccount(name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin);
    }

    public void addAdultAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, int cn, boolean isAdmin) {
        libraryDatabase.getAccountsDatabase().add(new AdultBorrow(name, Long.parseLong(iD), birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin));
    }

    public void addChildAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, int cn, boolean isAdmin) {
        libraryDatabase.getAccountsDatabase().add(new ChildBorrow(name, Long.parseLong(iD), birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin));
    }

  /*

  public void browseISBN(int ISBN){
    for(int i = 0; i < database.size(); i++){
      int bookISBN = (database.get(i)).getISBN();
      if(ISBN == bookISBN){
        System.out.println(database.get(i));
      }
    }
  }
  */


    /*
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
