import java.util.Scanner;

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



    public Media getBookFromTitle(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String bookTitle = (libraryDatabase.getMediaDatabase().get(i)).getTitle();

            if (bookTitle.toLowerCase().equals(title.toLowerCase())) {
                return libraryDatabase.getMediaDatabase().get(i);
            }
        }
        return null;
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

    public void addMagazine() {
        Magazine magazine = new Magazine();
        libraryDatabase.getMediaDatabase().add(magazine);
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

            if (bookTitle.equalsIgnoreCase(title)){
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }
    public void browseAuthor(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String bookTitle = (libraryDatabase.getMediaDatabase().get(i)).getAuthor();

            if (bookTitle.equalsIgnoreCase(title)){
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }
    public void browseKeyword (String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String bookTitle = (libraryDatabase.getMediaDatabase().get(i)).toString();

            if (bookTitle.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    public void displayRatings(String title){
        Media currentMedia = getBookFromTitle(title);
        for(int i=0;i<currentMedia.ratings.size();i++)
        System.out.println(currentMedia.ratings.get(i));
    }
    public void giveRating(String title){
        Scanner keyboard = new Scanner(System.in);
        Media currentMedia = getBookFromTitle(title);
        currentMedia.showRatings();
        int stars;
        do{
        System.out.print("Type in amount of stars (1-5): ");
        stars = keyboard.nextInt();
        }while(stars<0 || stars>5);
        String fix = keyboard.nextLine();
        System.out.print("Type in your comment: ");
        String comment = keyboard.nextLine();
        currentMedia.addRating(stars, comment);
    }

    public void addCopyByTitle(String title, int copies) {
        Media media = getBookFromTitle(title);
        if (media == null)
            System.out.println("not found");
        else media.setCopies((media.getCopies() + copies));

    }

    public void displayCheckedOutBooks(Borrower currentUser){
        for (int i = 0; i<libraryDatabase.getMediaDatabase().size();i++)
            for (int j = 0; j< libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().size();j++)
        if(libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().get(j).getiD().equals(currentUser.getID())){
            System.out.println("Title: "+libraryDatabase.getMediaDatabase().get(i).getTitle()+" Due Date: "+libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().get(j).getDueDate());
        }
    }

    public void readInMedia() {
        libraryDatabase.readInMedia();
    }

    public void readInAccounts() {
        libraryDatabase.readInAccounts();
    }

    public void addTeacherAccount(Borrower borrower) {
        libraryDatabase.getAccountsDatabase().add(borrower);
    }

    public void addAdultAccount(Borrower borrower) {
        libraryDatabase.getAccountsDatabase().add(borrower);
    }

    public void addChildAccount(Borrower borrower) {
        libraryDatabase.getAccountsDatabase().add(borrower);
    }
}
