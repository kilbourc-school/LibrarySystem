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

    /**
     *database save for accounts
     */
    public void saveAccountsToFile() {
        libraryDatabase.saveAccountsToFile();
    }

    /**
     *database save for media
     */
    public void saveMediaToFile() {
        libraryDatabase.saveMediaToFile();
    }

    /**
     * returns current user
     */
    public Borrower getCurrentUser() {
        return currentUser;
    }

    /**
     * prints out all media
     */
    public void displayMedias() {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            System.out.println(libraryDatabase.getMediaDatabase().get(i));
        }
    }


    /**
     * @param title of media
     * @return media found from title given
     */
    public Media getMediaFromTitle(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).getTitle();

            if (MediaTitle.toLowerCase().equals(title.toLowerCase())) {
                return libraryDatabase.getMediaDatabase().get(i);
            }
        }
        return null;
    }


    /**
     * prints out all accounts
     */
    public void displayAllAccounts() {

        for (Borrower account : libraryDatabase.getAccountsDatabase()) {
            System.out.println(account);
        }
    }


    /**
     * @param email - of potential account
     * @param pass - of potential account
     * @return true or false, if account is in database
     */
    public boolean verifyAccount(String email, String pass) {

        for (Borrower account : libraryDatabase.getAccountsDatabase()) {
            if (account.getEmail().equals(email) && account.getPassword().equals(pass)) {
                currentUser = account;
                return true;
            }
        }
        return false;
    }

    /**
     * add Book to library database
     */
    public void addBook() {
        Book book = new Book();
        libraryDatabase.getMediaDatabase().add(book);
    }

    /**
     * add AudioBook to library database
     */
    public void addAudioBook() {
        AudioBook audioBook = new AudioBook();
        libraryDatabase.getMediaDatabase().add(audioBook);
    }

    /**
     * add DVD to library database
     */
    public void addDVD() {
        DVD dvd = new DVD();
        libraryDatabase.getMediaDatabase().add(dvd);
    }

    /**
     * add EBook to library database
     */
    public void addEBook() {
        EBook ebook = new EBook(); //null Book
        libraryDatabase.getMediaDatabase().add(ebook);
    }

    /**
     * add Magazine to library database
     */
    public void addMagazine() {
        Magazine magazine = new Magazine();
        libraryDatabase.getMediaDatabase().add(magazine);
    }



    /**
     * Method to display all Medias of a specified genre in the library.
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

    /**
     * Method to display all Medias of a specified title in the library.
     * Param: String with the title of a Media.
     * Return: List of Medias in the same title.
     */
    public void browseTitle(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).getTitle();

            if (MediaTitle.equalsIgnoreCase(title)){
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    /**
     * Method to display all Medias of a specified author in the library.
     * Param: String with the author of a Media.
     * Return: List of Medias in the same author.
     */
    public void browseAuthor(String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).getAuthor();

            if (MediaTitle.equalsIgnoreCase(title)){
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    /**
     * Method to display all Medias of a specified keyword in the library.
     * Param: String with the keyword of a Media.
     * Return: List of Medias in the same keyword.
     */
    public void browseKeyword (String title) {
        for (int i = 0; i < libraryDatabase.getMediaDatabase().size(); i++) {
            String MediaTitle = (libraryDatabase.getMediaDatabase().get(i)).toString();

            if (MediaTitle.toLowerCase().contains(title.toLowerCase())) {
                System.out.println(libraryDatabase.getMediaDatabase().get(i));
            }
        }
    }

    /**
     * @param title - of specified media
     * prints out all ratings of a given media
     */
    public void displayRatings(String title){
        Media currentMedia = getMediaFromTitle(title);
        if (currentMedia.ratings.size() == 0){
            System.out.println("No Existing reviews for "+ currentMedia.getTitle());
        }
        for(int i=0;i<currentMedia.ratings.size();i++)
        System.out.println(currentMedia.ratings.get(i));
    }

    /**
     * helper method for scenarios
     * adds ratings
     */
    public void autoRating(){
        Media currentMedia = getMediaFromTitle("Hitchhikers Guide to the Galaxy");
        currentMedia.addRating(5, "best book ever");
        currentMedia.addRating(5, "no book can compete");
        currentMedia.addRating(5, "SUPER AMAZING");
    }

    /**
     *
     * @param title - of specified media
     * assigns rating to a book
     */
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

    /**
     *
     * @param title - of given media
     * @param copies - copies being added to the library
     *  adds copies amount to the given media
     */
    public void addCopyByTitle(String title, int copies) {
        Media media = getMediaFromTitle(title);
        if (media == null)
            System.out.println("not found");
        else media.setCopies((media.getCopies() + copies));

    }

    /**
     * @param currentUser
     * displays all media checked out to current User
     */
    public void displayCheckedOutMedias(Borrower currentUser){
        System.out.println("********** Current Checked Out Media **********");
        for (int i = 0; i<libraryDatabase.getMediaDatabase().size();i++)
            for (int j = 0; j< libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().size();j++)
        if(libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().get(j).getiD().equals(currentUser.getID())){
            System.out.println("Title: "+libraryDatabase.getMediaDatabase().get(i).getTitle()+" Due Date: "+libraryDatabase.getMediaDatabase().get(i).getCurrentBorrowerID().get(j).getDueDate());
        }
    }

    /**
     * helper method for scenarios
     * @param media - media tht is being added to wait list
     */
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
