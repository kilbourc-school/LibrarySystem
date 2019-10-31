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
            System.out.println("enter 1 to add media");
            System.out.println("enter 2 to see all accounts");
            System.out.println("enter 3 to search by title");
            System.out.println("enter 4 to search by genre");
            System.out.println("enter 5 to display all books");
            System.out.println("enter 6 save to file");
            System.out.println("enter 7 to add a account");
            int input = keyboard.nextInt();
            String fix = keyboard.nextLine();
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
                currentLibrary.saveAccountsToFile();
                currentLibrary.saveMediaToFile();
            }
            if (input == 7) {
                currentLibrary.addAdminAccount("name", "id", LocalDate.now(), 803511, "street", "city", "state", 29045, "admin@admin", "admin", 1199, true);
            }
            if (input == 8) {
                System.out.println("Enter book title you wish to check out");
                String title = keyboard.nextLine();
                System.out.println("enter how many copies you wish to check out");
                int copies = keyboard.nextInt();

            }
        }
    }
}
