import java.time.LocalDate;
import java.util.Scanner;

/**
 * This is the class that acts as the library, holding
 * the medias and allowing interactions with the medias
 * using methods to add, remove, borrow, return, and
 * browse the medias.
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
    public void displayMedias() {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            System.out.println(libraryDatabase.getMediaDatabase().get(i));
        }
    }



    public Media getMediaFromTitle(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).getTitle();

            if (MediaTitle.toLowerCase().equals(title.toLowerCase())) {
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
     * Method to display all Medias of a genre in the library.
     * Param: String with the genre of a Media.
     * Return: List of Medias in the same genre.
     */

    public void browseGenre(String genre) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaGenre = (libraryDatabase.getMediaDatabase().get(i)).getGenre();
            if (genre.equals(MediaGenre)) {
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    public void browseTitle(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).getTitle();

            if (MediaTitle.equalsIgnoreCase(title)){
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }
    public void browseAuthor(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).getAuthor();

            if (MediaTitle.equalsIgnoreCase(title)){
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }
    public void browseKeyword (String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).toString();

            if (MediaTitle.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    public void displayRatings(String title){
        Media currentMedia = getMediaFromTitle(title);
        if (currentMedia.ratings.size() == 0){
            System.out.println("No Existing reviews for "+ currentMedia.getTitle());
        }
        for(int i=0;i<currentMedia.ratings.size();i++)
        System.out.println(currentMedia.ratings.get(i));
    }


    public void autoRating(){
        Media currentMedia = getMediaFromTitle("Hitchhiker's Guide to the Galaxy");
        currentMedia.addRating(5, "best book ever");
        currentMedia.addRating(5, "no book can compete");
        currentMedia.addRating(5, "SUPER AMAZING");
    }

    public void giveRating(String title){
        Scanner keyboard = new Scanner(System.in);
        Media currentMedia = getMediaFromTitle(title);
        currentMedia.showRatings();
        int stars;
        do{
        System.out.print("Type in amount of stars (1-5): ");
        try {
            stars = keyboard.nextInt();
        }catch (Exception e){stars = 99;}
        }while(stars<0 || stars>5);
        String fix = keyboard.nextLine();
        System.out.print("Type in your comment: ");
        String comment = keyboard.nextLine();
        currentMedia.addRating(stars, comment);
    }

    public void addCopyByTitle(String title, int copies) {
        Media media = getMediaFromTitle(title);
        if (media == null)
            System.out.println("not found");
        else media.setCopies((media.getCopies() + copies));

    }

    public void displayCheckedOutMedias(Borrower currentUser){
        System.out.println("********** Current Checked Out Media **********");
        for (int i = 0; i<libraryDatabase.getMediaDatabase().size();i++)
            for (int j = 0; j< libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().size();j++)
        if(libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().get(j).getiD().equals(currentUser.getID())){
            System.out.println("Title: "+libraryDatabase.getMediaDatabase().get(i).getTitle()+" Due Date: "+libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().get(j).getDueDate());
        }
    }


    public void assignToWaitList(Media media){
        media.waitListBorrowerIDs.add(new iDandCopies(Long. parseLong("234564"),1, LocalDate.now()));
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
