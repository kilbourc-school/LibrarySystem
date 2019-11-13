import java.util.Scanner;

public class Scenario3 {
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

                String stop = keyboard.nextLine();
                System.out.println("admin@admin");
                String username = "admin@admin";

                if (username.equalsIgnoreCase("exit")) {
                    exit = true;
                    break; //exit program
                }
                System.out.print("Enter your password: ");
                stop = keyboard.nextLine();
                System.out.println("admin");
                String password = "admin";
                if (currentLibrary.verifyAccount(username, password)) {
                    login = true;
                } else {
                    System.out.println("Sorry, email and/or password were incorrect");
                }
            }

            /**
             * User login
             */
            while (login && currentLibrary.getCurrentUser().isAdmin()) {
                System.out.println("\n\nWelcome  Administrator " + currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?\n");
                System.out.println("1: Add media\n2: See all accounts\n3: Search by title\n4: Search by genre" +
                        "\n5: Display all books\n6: Save to file\n7: Add an account\n8:Checkout\n9:Checkin\n10:change copies");
                System.out.println("0: Logout");

                int input = 10;
                System.out.println(input);
                String fix = keyboard.nextLine();
                if (input == 1) {
                    //&& currentLibrary.getCurrentUser().isAdmin
                    System.out.println("Which media type would you like to add?");
                    System.out.println("1: Book\n2: Audio Book\n3: DVD\n4: eBook\n5:Magazine");
                    input = keyboard.nextInt();
                    fix = keyboard.nextLine();
                    if (input == 1) {
                        currentLibrary.addBook();
                    } else if (input == 2) {
                        currentLibrary.addAudioBook();
                    } else if (input == 3) {
                        currentLibrary.addDVD();
                    } else if (input == 4) {
                        currentLibrary.addEBook();
                    } else if (input == 5) {
                        currentLibrary.addMagazine();
                    }
                } else if (input == 2) {
                    currentLibrary.displayAllAccounts();
                } else if (input == 3) {
                    System.out.println("Enter the book title");
                    String title = keyboard.nextLine();
                    currentLibrary.browseTitle(title);
                } else if (input == 4) {
                    System.out.println("Enter the book genre");
                    String genre = keyboard.nextLine();
                    currentLibrary.browseGenre(genre);
                } else if (input == 5) {
                    currentLibrary.displayBooks();
                } else if (input == 6) {
                    currentLibrary.saveAccountsToFile();
                    currentLibrary.saveMediaToFile();
                } else if (input == 7) {
                    System.out.println("Which User Account would you like to add?");
                    System.out.println("1: Adult\n2: Child\n3: Teacher");
                    input = keyboard.nextInt();
                    fix = keyboard.nextLine();
                    if (input == 1) {
                        AdultBorrow borrower = new AdultBorrow();
                        currentLibrary.addAdultAccount(borrower);
                    } else if (input == 2) {
                        ChildBorrow borrower = new ChildBorrow();
                        currentLibrary.addChildAccount(borrower);
                    } else if (input == 3) {
                        TeacherBorrow borrower = new TeacherBorrow();
                        currentLibrary.addTeacherAccount(borrower);
                    } else {
                        System.out.println("Invalid Input");
                    }

                } else if (input == 10) {
                    System.out.println("Enter the book title");
                    String title = "To Kill a Mockingbird";
                    System.out.println(title);
                    System.out.println("Please enter the amount the copies changes by (+/-):");
                    int copies = 1;
                    System.out.println(copies);
                    fix = keyboard.nextLine();
                    currentLibrary.addCopyByTitle(title, copies);
                    login = false;
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
                    currentMedia.checkInMedia(currentMedia, currentLibrary.getCurrentUser().getID(), copies, currentMedia.getDueDate(currentMedia, currentLibrary.getCurrentUser()));
                }
            }
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

                String stop = keyboard.nextLine();
                System.out.println("user@user");
                String username = "user@user";

                if (username.equalsIgnoreCase("exit")) {
                    exit = true;
                    break; //exit program
                }
                System.out.print("Enter your password: ");
                stop = keyboard.nextLine();
                System.out.println("user");
                String password = "user";
                if (currentLibrary.verifyAccount(username, password)) {
                    login = true;
                } else {
                    System.out.println("Sorry, email and/or password were incorrect");
                }
            }
            while (login && !currentLibrary.getCurrentUser().isAdmin()) {
/**
 * insert waitinglist message here
 */
               login=false;
            }
            exit = false;
        }
    }
}
