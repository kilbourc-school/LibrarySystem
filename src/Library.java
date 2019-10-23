
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.nio.file.*;
import java.util.StringJoiner;

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

  public Library(){
  }

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
  public void displayAllAccounts(){

    for (Borrower account : accounts) {
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
    genre = keyboard.nextLine();
    int releaseYear = keyboard.nextInt();
    int stars = keyboard.nextInt();
    boolean comingSoon = keyboard.nextBoolean();
    int ISBN = keyboard.nextInt();

    database.add(new Book(title,description,author,subject,copies,genre,releaseYear,stars,comingSoon,ISBN));
   displayBooks();
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
    genre = keyboard.nextLine();
    int releaseYear = keyboard.nextInt();
    int stars = keyboard.nextInt();
    boolean comingSoon = keyboard.nextBoolean();
    int ISBN = keyboard.nextInt();

    database.add(new AudioBook(title,description,author,subject,copies,genre,releaseYear,stars,comingSoon,ISBN));
  }
  public void addDVD(){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon");
    String title = keyboard.nextLine();
    String description = keyboard.nextLine();
    String author = keyboard.nextLine();
    String subject = keyboard.nextLine();
    int copies = keyboard.nextInt();
    String genre = keyboard.nextLine();
    genre = keyboard.nextLine();
    int releaseYear = keyboard.nextInt();
    int stars = keyboard.nextInt();
    boolean comingSoon = keyboard.nextBoolean();


    database.add(new DVD(title,description,author,subject,copies,genre,releaseYear,stars,comingSoon));
  }

  public void addEBook(){
    Scanner keyboard = new Scanner(System.in);
    System.out.println("String title, String description, String author, String subject, int copies, String genre, int releaseYear, int stars, boolean comingSoon, String narrator");
    String title = keyboard.nextLine();
    String description = keyboard.nextLine();
    String author = keyboard.nextLine();
    String subject = keyboard.nextLine();
    int copies = keyboard.nextInt();
    String genre = keyboard.nextLine();
    int releaseYear = keyboard.nextInt();
    int stars = keyboard.nextInt();
    boolean comingSoon = keyboard.nextBoolean();
    String narrator = keyboard.nextLine();

    database.add(new EBook(title,description,author,subject,copies,genre,releaseYear,stars,comingSoon,narrator));
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

  public void addCopyByTitle(String title, int copies){
    for(int i = 0; i < database.size(); i++){
      String bookTitle = (database.get(i)).getTitle();
      if(title.equals(bookTitle)){
        database.get(i).setCopies(copies);
        break;
      }
      else{
        System.out.println("not found");
      }
    }
  }
 public void readInMedia(){
     File file = new File("media.txt");
     Scanner scan;
     try {
       scan = new Scanner(file);
       while (scan.hasNextLine()) {
         String line = scan.nextLine();
         String[] lineArray = line.split(",");
       if(lineArray[0].equals("Book")){
         database.add(new Book(lineArray[1],lineArray[2],lineArray[3],lineArray[4],Integer.parseInt(lineArray[5]),lineArray[6],Integer.parseInt(lineArray[7]),Integer.parseInt(lineArray[8]),Boolean.parseBoolean(lineArray[9]),Integer.parseInt(lineArray[10])));
       }
       else if(lineArray[0].equals("AudioBook")){
         database.add(new AudioBook(lineArray[1],lineArray[2],lineArray[3],lineArray[4],Integer.parseInt(lineArray[5]),lineArray[6],Integer.parseInt(lineArray[7]),Integer.parseInt(lineArray[8]),Boolean.parseBoolean(lineArray[9]),Integer.parseInt(lineArray[10])));
         }
       else if(lineArray[0].equals("DVD")){
         database.add(new DVD(lineArray[1],lineArray[2],lineArray[3],lineArray[4],Integer.parseInt(lineArray[5]),lineArray[6],Integer.parseInt(lineArray[7]),Integer.parseInt(lineArray[8]),Boolean.parseBoolean(lineArray[9])));
         }
       else if(lineArray[0].equals("EBook")){
         database.add(new EBook(lineArray[1],lineArray[2],lineArray[3],lineArray[4],Integer.parseInt(lineArray[5]),lineArray[6],Integer.parseInt(lineArray[7]),Integer.parseInt(lineArray[8]),Boolean.parseBoolean(lineArray[9]),lineArray[10]));
         }
       }
       } catch (FileNotFoundException e) {
       e.printStackTrace();

     }

 }
 public void readInAccounts() {
   File file = new File("account.txt");
   Scanner scan;
   try {
     scan = new Scanner(file);
     while (scan.hasNextLine()) {
       String line = scan.nextLine();
       String[] lineArray = line.split(",");
       if (Integer.parseInt(lineArray[0]) == 3) {
         accounts.add(new ChildBorrow(lineArray[1],lineArray[2], LocalDate.parse(lineArray[3]),Integer.parseInt(lineArray[4]),lineArray[5],lineArray[6],lineArray[7],Integer.parseInt(lineArray[8]),lineArray[9],lineArray[10],Integer.parseInt(lineArray[11]),Boolean.parseBoolean(lineArray[12])));
       }
       else if (Integer.parseInt(lineArray[0]) == 10) {
         accounts.add(new AdultBorrow(lineArray[1],lineArray[2], LocalDate.parse(lineArray[3]),Integer.parseInt(lineArray[4]),lineArray[5],lineArray[6],lineArray[7],Integer.parseInt(lineArray[8]),lineArray[9],lineArray[10],Integer.parseInt(lineArray[11]),Boolean.parseBoolean(lineArray[12])));
       }
       else if (Integer.parseInt(lineArray[0]) == 50) {
         accounts.add(new TeacherBorrow(lineArray[1],lineArray[2], LocalDate.parse(lineArray[3]),Integer.parseInt(lineArray[4]),lineArray[5],lineArray[6],lineArray[7],Integer.parseInt(lineArray[8]),lineArray[9],lineArray[10],Integer.parseInt(lineArray[11]),Boolean.parseBoolean(lineArray[12])));
       }
       else if (Boolean.parseBoolean(lineArray[12])) {
         accounts.add(new AdminBorrow(lineArray[1],lineArray[2], LocalDate.parse(lineArray[3]),Integer.parseInt(lineArray[4]),lineArray[5],lineArray[6],lineArray[7],Integer.parseInt(lineArray[8]),lineArray[9],lineArray[10],Integer.parseInt(lineArray[11]),Boolean.parseBoolean(lineArray[12])));
       }

     }
   } catch (FileNotFoundException e) {
     e.printStackTrace();
   }
 }

  public void saveAccountsToFile(){
      try{
        PrintWriter writer = new PrintWriter("account.txt");
        for (Borrower borrower : accounts){
          writer.println(borrower.toStringList());
        }
        writer.close();
      } catch (FileNotFoundException e){
        System.out.println("File not found.");
      }
    }
  public void saveMediaToFile(){
    try{
      PrintWriter writer = new PrintWriter("media.txt");
      for (Media media : database){
        writer.println(media.toStringList());
      }
      writer.close();
    } catch (FileNotFoundException e){
      System.out.println("File not found.");
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
