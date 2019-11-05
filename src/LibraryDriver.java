import java.time.LocalDate;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Library currentLibrary = new Library();
        Scanner keyboard = new Scanner(System.in);
        currentLibrary.readInMedia();
        currentLibrary.readInAccounts();

        boolean login = false;
        boolean exit = false;

        while (!exit) {
            while(!login) {
                currentLibrary.displayAllAccounts();
                System.out.print("\n\nEnter your user email: ");

                String username = keyboard.nextLine();
                if (username.equalsIgnoreCase("exit")) {
                    exit = true;
                    break; //exit program
                }
                System.out.print("Enter your password: ");
                String password = keyboard.nextLine();
                if (currentLibrary.verifyAccount(username, password)) {
                    login = true;
                } else {
                    System.out.println("Sorry, email and/or password were incorrect");
                }
            }

            while (login) {
                System.out.println("Welcome "+ currentLibrary.getCurrentUser().getName() +", what would you like to do?");
                System.out.println("1: Add media\n2: See all accounts\n3: Search by title\n4: Search by genre"+
                                    "\n5: Display all books\n6: Save to file\n7: Add an account");
                System.out.println("0: Logout");

                int input = keyboard.nextInt();
                String fix = keyboard.nextLine();
                if (input == 1) {
                    //&& currentLibrary.getCurrentUser().isAdmin
                    System.out.println("Which media type would you like to add?");
                    System.out.println("1: Book\n2: Audio Book\n3: DVD\n4: eBook");
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
                    System.out.println("Enter the book title");
                    String title = keyboard.nextLine();
                    currentLibrary.browseTitle(title);
                }
                if (input == 4) {
                    System.out.println("Enter the book genre");
                    String genre = keyboard.nextLine();
                    currentLibrary.browseGenre(genre);
                }
                if (input == 5) {
                    currentLibrary.displayBooks();
                }
                if (input == 6) {
                    currentLibrary.saveAccountsToFile();
                    currentLibrary.saveMediaToFile();
                }
                if (input == 7) {
                    currentLibrary.addAdminAccount("name", "id", LocalDate.now(), 803511, "street", "city", "state", 29045, "admin@admin", "admin", 1199, true);
                }
                if (input == 0) {
                    currentLibrary.saveAccountsToFile();
                    currentLibrary.saveMediaToFile();
                    login = false;
                }
            }

        }
    }
}
