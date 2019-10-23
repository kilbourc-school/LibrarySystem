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

System.out.println("What would you like to do?");
        System.out.println("enter 1 to add media");
        System.out.println("enter 2 to do some other stuff man");
        int input = keyboard.nextInt();
        if (input == 1){
            System.out.println("enter 1 to add a book");
            System.out.println("enter 2 to add a audiobook");
            System.out.println("enter 3 to add a dvd");
            input = keyboard.nextInt();
            if(input == 1) {
                currentLibrary.addBook();
            }
            if(input == 2){
                currentLibrary.addAudioBook();
            }
                if(input == 3){
                    currentLibrary.addDVD();
                }
        }






    }
}
