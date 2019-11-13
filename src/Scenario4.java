import java.util.Scanner;

public class Scenario4 {
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

                System.out.print("\n\nPlease login with your Library user email ('exit' to logout): ");

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

                //insert all current checked out books
                currentLibrary.displayCheckedOutMedias(currentLibrary.getCurrentUser());

currentLibrary.autoRating();
                System.out.println("\n\nWelcome User " + currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?");
                System.out.println("1: Search Library\n2: Checkout media\n3: Checkin media\n4: Pay Fines"+
                        "\n5: Give Media a Rating\n6: Read Reviews for a Media\n0: Logout");

                String stop = keyboard.nextLine();
                System.out.println(5);

                        System.out.println("Enter the title of the book you want to review: ");
                        stop = keyboard.nextLine();
                        String title = "Hitchhiker's Guide to the Galaxy";
                        currentLibrary.giveRating(title);

                }
            }
        }
    }
