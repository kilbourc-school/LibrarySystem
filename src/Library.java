
import java.util.ArrayList;
import java.util.Scanner;

/*
 * 
 * This is the class that acts as the library, holding
 * the books and allowing interactions with the books
 * using methods to add, remove, borrow, return, and
 * browse the books.
 */

public class Library{
  private Borrower currentUser;
  private ArrayList<Media> database = new ArrayList<>();//Holds all books.
  private ArrayList<Borrower> accounts = new ArrayList<>();     //Holds all teachers.

  public Borrower getCurrentUser() {
    return currentUser;
  }

  //Prints out the contents of the Library.
  public void displayBooks(){
    for(int i = 0; i < database.size(); i++){
      System.out.println(database.get(i));
    }
  }

  //Prints out the teachers accounts
  public void displayTeachersAccounts(){

    for (Borrower account : accounts) {
      if (account.getBorrowLimit() == 50)
        System.out.println(account);
    }
  }

  //Prints out the teachers accounts
  public void displayAdultAccounts(){

    for (Borrower account : accounts) {
      if (account.getBorrowLimit() == 10)
        System.out.println(account);
    }
  }

  //Prints out the teachers accounts
  public void displayChildAccounts(){

    for (Borrower account : accounts) {
      if (account.getBorrowLimit() == 3)
        System.out.println(account);
    }
  }

  public boolean verifyAccount(String email, String pass){

    for (Borrower account : accounts) {
      if(account.getEmail().equals(email) && account.getPassword().equals(pass)) {
        currentUser = account;
        return true;
      }
    }
    return false;
  }


  
  //Modifier method to add a books to database.
  public void addBook(){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int ISBN");
    String title = keyboard.nextLine();
    String description = keyboard.nextLine();
    String author = keyboard.nextLine();
    String subject = keyboard.nextLine();
    int copies = keyboard.nextInt();
    String genre = keyboard.nextLine();
    int releaseYear = keyboard.nextInt();
    int stars = keyboard.nextInt();
    boolean comingSoon = keyboard.nextBoolean();
    int ISBN = keyboard.nextInt();

    database.add(new Book(title,description,author,subject,copies,genre,releaseYear,stars,comingSoon,ISBN));
  }
  public void addAudioBook(){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int ISBN");
    String title = keyboard.nextLine();
    String description = keyboard.nextLine();
    String author = keyboard.nextLine();
    String subject = keyboard.nextLine();
    int copies = keyboard.nextInt();
    String genre = keyboard.nextLine();
    int releaseYear = keyboard.nextInt();
    int stars = keyboard.nextInt();
    boolean comingSoon = keyboard.nextBoolean();
    int ISBN = keyboard.nextInt();

    database.add(new Book(title,description,author,subject,copies,genre,releaseYear,stars,comingSoon,ISBN));
  }
  public void addDVD(){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, int ISBN");
    String title = keyboard.nextLine();
    String description = keyboard.nextLine();
    String author = keyboard.nextLine();
    String subject = keyboard.nextLine();
    int copies = keyboard.nextInt();
    String genre = keyboard.nextLine();
    int releaseYear = keyboard.nextInt();
    int stars = keyboard.nextInt();
    boolean comingSoon = keyboard.nextBoolean();
    int ISBN = keyboard.nextInt();

    database.add(new Book(title,description,author,subject,copies,genre,releaseYear,stars,comingSoon,ISBN));
  }
  
  /*
   * Method to determine if book in library is available.
   * Param: String with title or ISBN of book.
   * Return: String with status of book.
   */ 
  public void isAvailable(String input){
    if(findMedia(input) != null){
      if(findMedia(input).getAvailability())
        System.out.println(input + " is available.");
      else
        System.out.println(input + " is not available.");
    }
  }
  
  /* 
   * Method to mark a book as borrowed if it is available.
   * Params: Title of a book and the name of the user.
   */ 
  public void borrowBook(String Media, String borrower){
    if(findMedia(Media) != null){
      (findMedia(Media)).makeBorrowed();
      String fileName = (findMedia(Media)).getTitle() + "Log.txt";
      String content = "Borrowed by:" + borrower;

      //add a way to check it out
    }
  }

  
  /*
   * Method to display all books of a genre in the library.
   * Param: String with the genre of a book.
   * Return: List of books in the same genre.
   */ 
  public void browseGenre(String genre){
    for(int i = 0; i < database.size(); i++){
      String bookGenre = (database.get(i)).getGenre();
      if(genre.equals(bookGenre)){
        System.out.println(database.get(i));
      }
    }
  }

  public void browseTitle(String title){
    for(int i = 0; i < database.size(); i++){
      String bookTitle = (database.get(i)).getTitle();
      if(title.equals(bookTitle)){
        System.out.println(database.get(i));
      }
    }
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
  public Media findMedia(String input){
    for(int i = 0; i < database.size(); i++){
      String str = (database.get(i)).getTitle();     //Gets title of book at index.

      if(input.equals(str))
        return database.get(i);
    }
    return null;
  }
}
