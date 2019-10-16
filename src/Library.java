
import java.util.ArrayList;

/*
 * 
 * This is the class that acts as the library, holding
 * the books and allowing interactions with the books
 * using methods to add, remove, borrow, return, and
 * browse the books.
 */

public class Library{
  
  private ArrayList<Book> database = new ArrayList<>();                 //Holds all books.
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
      System.out.println(teachers.get(i));
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
    if(findBook(input) != null){
      if(findBook(input).getAvailability())
        System.out.println(input + " is available.");
      else
        System.out.println(input + " is not available.");
    }
  }
  
  /* 
   * Method to mark a book as borrowed if it is available.
   * Params: Title or ISBN of a book and the name of the user.
   */ 
  public void borrowBook(String book, String borrower){
    if(findBook(book) != null){
      (findBook(book)).makeBorrowed();
      String fileName = (findBook(book)).getTitle() + "Log.txt";
      String content = "Borrowed by:" + borrower;
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

  public void browseISBN(int ISBN){
    for(int i = 0; i < database.size(); i++){
      int bookISBN = (database.get(i)).getISBN();
      if(ISBN == bookISBN){
        System.out.println(database.get(i));
      }
    }
  }
  
  /* 
   * Finds book object based on String. Basically converts
   * from String to Book.
   * Param: String containing title or ISBN
   * Return: Book object with a title or ISBN matching the input.
   */ 
  public Book findBook(String input){
    for(int i = 0; i < database.size(); i++){
      String str = (database.get(i)).getTitle();     //Gets title of book at index.
      int ISBN = (database.get(i)).getISBN();     //Gets ISBN of book at index.
      if(input.equals(str) || input.equals(ISBN))
        return database.get(i);
    }
    return null;
  }
}
