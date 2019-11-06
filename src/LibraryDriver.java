import java.time.LocalDate;
import java.util.Scanner;

public class LibraryDriver {
    public static void main(String[] args) {
        Library currentLibrary = new Library();
        Scanner keyboard = new Scanner(System.in);

        currentLibrary.readInMedia();
        currentLibrary.readInAccounts();

        System.out.print("********** Welcome to CSCE 247 Library Project **********");

        boolean login = false;
        boolean exit = false;

        while (!exit) {

            while (!login) {
                /**
                 * String name = "admin";
                 *                 String iD = "9";
                 *                 LocalDate birthday = LocalDate.now();
                 *                 int pn = 999;
                 *                 String str1 = "str";
                 *                 String cty = "cty";
                 *                 String st = "st";
                 *                 int zp = 202;
                 *                 String em = "admin@admin";
                 *                 String pw = "admin";
                 *                 boolean isAdmin = true;
                 *                 double fines = 0;
                 *                 currentLibrary.addAdminAccount(name,iD,birthday,pn,str1,cty,st,zp,em,pw,isAdmin,fines);
                 */
                System.out.print("\n\nPlease login with your Library user email: ");

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
/**
 * Admin login
 */
            while (login  && currentLibrary.getCurrentUser().isAdmin()) {
                System.out.println("\n\nWelcome  Administrator "+ currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?\n");
                System.out.println("1: Add media\n2: See all accounts\n3: Search by title\n4: Search by genre" +
                        "\n5: Display all books\n6: Save to file\n7: Add an account");
                System.out.println("0: Logout");

                int input = keyboard.nextInt();
                String fix = keyboard.nextLine();
                if (input == 1) {
                    //&& currentLibrary.getCurrentUser().isAdmin
                    System.out.println("Which media type would you like to add?");
                    System.out.println("1: Book\n2: Audio Book\n3: DVD\n4: eBook");
                    input = keyboard.nextInt();
                    fix = keyboard.nextLine();
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
                    AdultBorrow borrower = new AdultBorrow();
                    currentLibrary.addAdultAccount(borrower);
                }
                if (input == 0) {
                    currentLibrary.saveAccountsToFile();
                    currentLibrary.saveMediaToFile();
                    login = false;
                }

                if (input == 8) {
                    System.out.println("Enter media title you wish to check out");
                    String title = keyboard.nextLine();
                    System.out.println("enter how many copies you wish to check out");
                    int copies = keyboard.nextInt();
                    Media currentMedia = currentLibrary.getBookFromTitle(title);
                    currentMedia.checkOutMedia(currentMedia, currentLibrary.getCurrentUser(), copies);
                }

                if (input == 9) {
                    System.out.println("Enter media title you wish to check in");
                    String title = keyboard.nextLine();
                    Media currentMedia = currentLibrary.getBookFromTitle(title);
                    System.out.println(currentMedia.getTitle());
                    System.out.println("Enter how many copies you wish to return");
                    int copies = keyboard.nextInt();
                    currentMedia.checkInMedia(currentMedia, currentLibrary.getCurrentUser().getID(), copies);
                }
            }
            /**
             * User login
             */
            while (login && !currentLibrary.getCurrentUser().isAdmin()) {
                System.out.println("\n\nWelcome User "+ currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?");
                System.out.println("1: Search Library\n0:Logout");
                int input = keyboard.nextInt();
                String fix = keyboard.nextLine();
                switch (input){
                    case 1:
                        search();
                        break;
                    case 0:
                        login = false;
                        break;
                    default:
                        break;
                }

            }
        }
    }
    public static void search(){
        System.out.println("Searching function to be added");
    }
}
