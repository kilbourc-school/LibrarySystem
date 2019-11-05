import java.time.LocalDate;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Library currentLibrary = new Library();
        Scanner keyboard = new Scanner(System.in);
        currentLibrary.readInMedia();
        currentLibrary.readInAccounts();

        boolean login = false;
        while (!login) {
            System.out.println("Enter your username and password");
            currentLibrary.displayAllAccounts();
            String username = keyboard.nextLine();
            String password = keyboard.nextLine();
            if (currentLibrary.verifyAccount(username, password)) {
                login = true;
            } else {
                System.out.println("Sorry, that was an invalid input. please try again.");
            }
        }

        while (true) {
            System.out.println("What would you like to do?");
            System.out.println("1: Add media");
            System.out.println("2: See all accounts");
            System.out.println("3: Search by title");
            System.out.println("4: Search by genre");
            System.out.println("5: Display all books");
            System.out.println("6: Save to file");
            System.out.println("7: Add an account");
            int input = keyboard.nextInt();
            String fix = keyboard.nextLine();
            if (input == 1) {
                //&& currentLibrary.getCurrentUser().isAdmin
                System.out.println("Which media type would you like to add?");
                System.out.println("1: Book");
                System.out.println("2: Audio Book");
                System.out.println("3: DVD");
                System.out.println("4: eBook");
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
        }
    }
}
