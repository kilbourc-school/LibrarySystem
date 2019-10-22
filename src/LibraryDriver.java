import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args){
        Library currentLibrary = new Library();
        Scanner keyboard = new Scanner(System.in);
        boolean login = false;
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








    }
}
