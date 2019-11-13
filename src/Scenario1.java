import java.util.Scanner;

public class Scenario1 {
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

            /**
             * User login
             */
            while (login && !currentLibrary.getCurrentUser().isAdmin()) {
                System.out.println("\n\nWelcome User " + currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?");
                System.out.println("1: Search Library\n2: Checkout media\n3: Checkin media\n4: Pay Fines\n0: Logout");
                String stop = keyboard.nextLine();

                int input = 2;
                System.out.println(input);
                String fix = keyboard.nextLine();

                //insert all current checked out books
                currentLibrary.displayCheckedOutBooks(currentLibrary.getCurrentUser());


                switch (input) {
                    case 1:
                        System.out.println("How would you like to search?\n1: Title\n2: Author\n3: Keyword");
                        input = keyboard.nextInt();
                        fix = keyboard.nextLine();

                        if (input == 1){
                            System.out.println("Enter the book title:");
                            String title = keyboard.nextLine();
                            currentLibrary.browseTitle(title);
                        }
                        else if (input == 2){System.out.println("Enter Author: ");
                            String title = keyboard.nextLine();
                            currentLibrary.browseAuthor(title);
                        }
                        else if (input == 3){System.out.println("Enter Keyword: ");
                            String title = keyboard.nextLine();
                            currentLibrary.browseKeyword(title);
                        }
                        else {System.out.println("Invalid input");
                        }
                        break;
                    case 2:
                        System.out.println("Enter media title you wish to check out");
                        stop = keyboard.nextLine();
                        String title = "The Cat in the Hat";
                        System.out.println(title);
                        System.out.println("enter how many copies you wish to check out");
                        stop = keyboard.nextLine();
                        int copies = 1;
                        System.out.println(copies);
                        Media currentMedia = currentLibrary.getBookFromTitle(title);
                        currentMedia.checkOutMedia(currentMedia,
                                currentLibrary.getCurrentUser(),
                                copies);

                        System.out.println("Enter media title you wish to check out");
                        title = "Hitchhikers Guide to the Galaxy";
                        System.out.println("enter how many copies you wish to check out");
                        copies = 1;
                        Media currentMedia1 = currentLibrary.getBookFromTitle(title);
                        currentMedia1.checkOutMedia(currentMedia1,
                                currentLibrary.getCurrentUser(),
                                copies);
                        
                        System.out.println("Enter media title you wish to check out");
                        title = "To Kill a Mockingbird";
                        System.out.println("enter how many copies you wish to check out");
                        copies = 1;
                        Media currentMedia2 = currentLibrary.getBookFromTitle(title);
                        currentMedia2.checkOutMedia(currentMedia2,
                                currentLibrary.getCurrentUser(),
                                copies);
                        break;
                    case 3:
                        System.out.println("Enter media title you wish to check in");
                        title = keyboard.nextLine();
                        currentMedia = currentLibrary.getBookFromTitle(title);
                        System.out.println(currentMedia.getTitle());
                        System.out.println("Enter how many copies you wish to return");
                        copies = keyboard.nextInt();
                        currentMedia.checkInMedia(currentMedia, currentLibrary.getCurrentUser().getID(), copies, currentMedia.getDueDate(currentMedia, currentLibrary.getCurrentUser()));
                        break;
                    case 4:
                        System.out.println("Fines have been paid.");
                        currentLibrary.getCurrentUser().setFines(0);
                        break;
                    case 5:
                        System.out.println("Enter the title of the book you want to review");
                        title = keyboard.nextLine();
                        currentLibrary.giveRating(title);

                    case 0:
                        currentLibrary.saveAccountsToFile();
                        currentLibrary.saveMediaToFile();
                        login = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
