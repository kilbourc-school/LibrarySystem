import java.util.Scanner;

public class Scenario2 {
    public static void main(String[] args) {
        Library currentLibrary = new Library();
        Scanner keyboard = new Scanner(System.in);

        currentLibrary.readInMedia();
        currentLibrary.readInAccounts();

        System.out.println("********** Welcome to CSCE 247 Library Project **********");
        System.out.print("********** Scenario 2 **********");

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
System.out.println("portia@portia");
                String username = "portia@portia";
                if (username.equalsIgnoreCase("exit")) {
                    exit = true;
                    break; //exit program
                }
                System.out.print("Enter your password: ");
                stop = keyboard.nextLine();
                System.out.println("portia");
                String password = "portia";
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

                currentLibrary.displayCheckedOutBooks(currentLibrary.getCurrentUser());

                System.out.println("\n\nWelcome User " + currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?");
                System.out.println("1: Search Library\n2: Checkout media\n3: Checkin media\n4: Pay Fines\n0: Logout");
                String stop = keyboard.nextLine();
                System.out.println(2);
                int input = 2;



                        System.out.println("Enter media title you wish to check out");
                stop = keyboard.nextLine();
                        System.out.println("dante's peak");
                        String title = "dante's peak";
                        System.out.println("enter how many copies you wish to check out");
                stop = keyboard.nextLine();
                System.out.println(1);
                        int copies = 1;
                        Media currentMedia = currentLibrary.getBookFromTitle(title);
                        currentMedia.checkOutMedia(currentMedia,
                                currentLibrary.getCurrentUser(),
                                copies);


//next book
                currentLibrary.displayCheckedOutBooks(currentLibrary.getCurrentUser());

                System.out.println("\n\nWelcome User " + currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?");
                System.out.println("1: Search Library\n2: Checkout media\n3: Checkin media\n4: Pay Fines\n0: Logout");
                stop = keyboard.nextLine();
                System.out.println(2);
                input = 2;

                System.out.println("Enter media title you wish to check out");
                stop = keyboard.nextLine();
                System.out.println("popular machinics");
                title = "popular machinics";
                System.out.println("enter how many copies you wish to check out");
                stop = keyboard.nextLine();
                System.out.println(1);
                copies = 1;
                currentMedia = currentLibrary.getBookFromTitle(title);
                currentMedia.checkOutMedia(currentMedia, currentLibrary.getCurrentUser(), copies);

            }
        }
    }
}
