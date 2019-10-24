
import java.time.LocalDate;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args){
        Library currentLibrary = new Library();
      //  currentLibrary.readInAccounts();
        //currentLibrary.readInMedia();
        Scanner keyboard = new Scanner(System.in);

  /*      boolean login = false;
        while (!login){
        System.out.println("Enter your username and password");
        String username = keyboard.nextLine();
        String password = keyboard.nextLine();
      if (currentLibrary.verifyAccount(username,password)){
          login = true;
      } else {
                System.out.println("Sorry, that was an invalid input. please try again.");
            }
        }
        */
  while (true) {
      System.out.println("What would you like to do?");
      System.out.println("enter 1 to add media");
      System.out.println("enter 2 to see all accounts");
      System.out.println("enter 3 to search by title");
      System.out.println("enter 4 to search by genre");
      System.out.println("enter 5 to display all books");
      System.out.println("enter 6 to do the fix thingy");
      int input = keyboard.nextInt();
      if (input == 1) {
          //&& currentLibrary.getCurrentUser().isAdmin
          System.out.println("enter 1 to add a book");
          System.out.println("enter 2 to add a audiobook");
          System.out.println("enter 3 to add a dvd");
          System.out.println("enter 3 to add a ebook");
          input = keyboard.nextInt();
          if (input == 1) {
              currentLibrary.addBook();
          }
          if (input == 2) {
              currentLibrary.addAudioBook();
          }
          if (input == 3) {
              currentLibrary.addDVD();
          }
          if (input == 4) {
              currentLibrary.addEBook();
          }
      }
      if (input == 2) {
          currentLibrary.displayAllAccounts();
      }
      if (input == 3) {
          System.out.println("enter the book title");
          String title = keyboard.nextLine();
          currentLibrary.browseTitle(title);
      }
      if (input == 4) {
          System.out.println("enter the book genre");
          String genre = keyboard.nextLine();
          currentLibrary.browseGenre(genre);
      }
      if (input == 5) {
          currentLibrary.displayBooks();
      }
      if (input == 6) {
          String name = "user";
          String iD = "user";
          LocalDate birthday = null;
          int pn = 1;
          String str1 = "street";
          String cty = "city";
          String st = "state";
          int zp = 1;
          String em = "email@email";
          String pw = "pass";
          int cn = 1;
          boolean isAdmin = true;
          currentLibrary.addAdminAccount(name, iD, LocalDate.now(), pn, str1, cty, st, zp, em, pw, cn, isAdmin);
          currentLibrary.saveAccountsToFile();
          currentLibrary.saveMediaToFile();
      }
  }
    }
}
