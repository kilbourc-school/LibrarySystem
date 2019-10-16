
import java.util.ArrayList;

/*
 * 
 * This is the class that acts as the library, holding
 * the books and allowing interactions with the books
 * using methods to add, remove, borrow, return, and
 * browse the books.
 */

public class Library{
  
  private ArrayList<Media> database = new ArrayList<>();//Holds all books.
  private ArrayList<Borrower> accounts = new ArrayList<>();     //Holds all teachers.

  private ArrayList<TeacherBorrow> teachers = new ArrayList<>();     //Holds all teachers.
  private ArrayList<ChildBorrow> children = new ArrayList<>();     //Holds all students.
  private ArrayList<AdultBorrow> adults = new ArrayList<>();     //Holds all students.
  

  //Prints out the contents of the Library.
  public void displayBooks(){
    for(int i = 0; i < database.size(); i++){
      System.out.println(database.get(i));
    }
  }
  
  //Prints out the teachers accounts
  public void displayTeachers(){
    for(int i = 0; i < teachers.size(); i++){
      System.out.println(teachers.get(i).borrowLimit);
    }
  }

  //Prints out the teachers accounts
  public void displayTeachersAccounts(){

    for(int i = 0; i < accounts.size(); i++){
      if (accounts.get(i).getBorrowLimit() == 50)
      System.out.println(accounts.get(i));
    }
  }

  
  //Prints out the adult accounts
  public void displayAdults(){
    for(int i = 0; i < adults.size(); i++){
      System.out.println(adults.get(i));
    }
  }

  //Prints out the children accounts
  public void displayChildren(){
    for(int i = 0; i < children.size(); i++){
      System.out.println(children.get(i));
    }
  }
  
  //Modifier method to add a books to database.
  public void addBook(Book book){
    database.add(book);
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
