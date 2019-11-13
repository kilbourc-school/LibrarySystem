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
                System.out.print("\n\nPlease login with your Library user email ('exit' to logout): ");

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
 * Admin login- has access to functions that a user would not, like adding users and media
 */
            while (login && currentLibrary.getCurrentUser().isAdmin()) {
                int input;
                System.out.println("\n\nAdministrator " + currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?\n");
                System.out.println("1: Add media\n2: See all accounts\n3: Search by title\n4: Search by genre" +
                        "\n5: Display all books\n6: Save to file\n7: Add an account\n8:Checkout\n9:Checkin\n10:change copies");
                System.out.println("0: Logout");

                try {
                    input = keyboard.nextInt();
                } catch (Exception e){
                    System.out.println("Invalid input");
                    input = 99;
                }
                String fix = keyboard.nextLine();

                if (input == 1) {
                    System.out.println("Which media type would you like to add?");
                    System.out.println("1: Book\n2: Audio Book\n3: DVD\n4: eBook\n5:Magazine");
                    try {
                        input = keyboard.nextInt();
                    }catch(Exception e){
                        System.out.println("Invalid input, please enter an Integer.");
                        input = 99;
                        System.out.println("\n\nPress Enter key to continue.");
                        fix = keyboard.nextLine();
                    }
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
                    } else {
                        System.out.println(input + " not within the bounds of available options");
                        System.out.println("\n\nPress Enter key to continue.");
                        fix = keyboard.nextLine();
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
                    currentLibrary.displayMedias();
                    System.out.println("\n\nPress Enter key to continue.");
                    fix = keyboard.nextLine();
                } else if (input == 6) {
                    currentLibrary.saveAccountsToFile();
                    System.out.println("Accounts saved");
                    currentLibrary.saveMediaToFile();
                    System.out.println("Library saved");
                    System.out.println("\n\nPress Enter key to continue.");
                    fix = keyboard.nextLine();

                } else if (input == 7) {
                    /**
                     * We add accounts this way due to the Borrower class being abstracted.
                     */
                    System.out.println("Which User Account would you like to add?");
                    System.out.println("1: Adult\n2: Child\n3: Teacher");
                    try {
                        input = keyboard.nextInt();
                    }catch(Exception e) {
                        input = 0;
                    }
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
                    String title = keyboard.nextLine();
                    System.out.println("Please enter the amount the copies changes by (+/-):");
                    int copies = keyboard.nextInt();
                    fix = keyboard.nextLine();
                    try {
                        currentLibrary.addCopyByTitle(title, copies);
                    }catch (Exception e){
                        System.out.println("Title not found");
                    }
                }


                if (input == 0) {
                    currentLibrary.saveAccountsToFile();
                    currentLibrary.saveMediaToFile();
                    System.out.println("\n\nYou have successfully logged out\nPress Enter key to continue.");
                    fix = keyboard.nextLine();
                    login = false;
                }

                if (input == 8) {
                    System.out.println("Enter media title you wish to check out");
                    String title = keyboard.nextLine();
                    System.out.println("enter how many copies you wish to check out");
                    int copies = keyboard.nextInt();
                    Media currentMedia = currentLibrary.getMediaFromTitle(title);
                    currentMedia.checkOutMedia(currentMedia, currentLibrary.getCurrentUser(), copies);
                }

                if (input == 9) {
                    System.out.println("Enter media title you wish to check in");
                    String title = keyboard.nextLine();
                    Media currentMedia = currentLibrary.getMediaFromTitle(title);
                    System.out.println(currentMedia.getTitle());
                    System.out.println("Enter how many copies you wish to return");
                    int copies = keyboard.nextInt();
                    currentMedia.checkInMedia(currentMedia, currentLibrary.getCurrentUser().getID(), copies, currentMedia.getDueDate(currentMedia, currentLibrary.getCurrentUser()));
                }
            }
             /**
             * User login
             */
            while (login && !currentLibrary.getCurrentUser().isAdmin()) {

                //insert all current checked out books
                currentLibrary.displayCheckedOutMedias(currentLibrary.getCurrentUser());


                System.out.println("\n\nWelcome User " + currentLibrary.getCurrentUser().getName() + ",\nWhat would you like to do?");
                System.out.println("1: Search Library\n2: Checkout media\n3: Checkin media\n4: Pay Fines"+
                        "\n5: Give Media a Rating\n6: Read Reviews for a Media\n0: Logout");
                int input = keyboard.nextInt();
                String fix = keyboard.nextLine();




                switch (input) {
                    case 1:
                        System.out.println("How would you like to search?\n1: Title\n2: Author\n3: Keyword");
                        try {
                            input = keyboard.nextInt();
                        }catch(Exception e ) {
                            System.out.println("Invalid input");
                            input = 99;
                        }
                        fix = keyboard.nextLine();

                        if (input == 1){
                            System.out.println("Enter the book title:");
                            String title = keyboard.nextLine();
                            currentLibrary.browseTitle(title);
                        }
                        else if (input == 2){
                            System.out.println("Enter Author: ");
                            String title = keyboard.nextLine();
                            currentLibrary.browseAuthor(title);
                        }
                        else if (input == 3){System.out.println("Enter Keyword: ");
                            String title = keyboard.nextLine();
                            currentLibrary.browseKeyword(title);
                        }
                        else {
                            System.out.println("Invalid input");
                        }
                        break;
                    case 2:
                        System.out.println("Enter media title you wish to check out");
                        String title = keyboard.nextLine();
                        Media currentMedia = currentLibrary.getMediaFromTitle(title);
                        if (currentMedia != null) {
                            System.out.println("enter how many copies you wish to check out");
                            int copies;
                            try {
                                copies = keyboard.nextInt();
                            }catch (Exception e){
                                System.out.println("Please enter an integer next time");
                                break;
                            }
                            currentMedia.checkOutMedia(currentMedia,
                                    currentLibrary.getCurrentUser(),
                                    copies);

                        }else{System.out.println("Title not found, Please type exact title");}


                        break;
                    case 3:
                        System.out.println("Enter media title you wish to check in");
                        title = keyboard.nextLine();
                        try {
                            currentMedia= currentLibrary.getMediaFromTitle(title);
                        }catch(Exception e){
                            System.out.println("Title not found");
                            break;
                        }
                        if(currentMedia != null) {
                            int copies;
                            System.out.println(currentMedia.getTitle());
                            System.out.println("Enter how many copies you wish to return");
                            try {
                                copies = keyboard.nextInt();
                            } catch (Exception e) {
                                System.out.println("Please enter an integer, Return Failed, Please try again");
                                System.out.println("\n\nPress Enter key to continue.");
                                fix = keyboard.nextLine();
                                copies = 0;
                            }
                            if (copies > 0) {
                                currentMedia.checkInMedia(currentMedia, currentLibrary.getCurrentUser().getID(), copies, currentMedia.getDueDate(currentMedia, currentLibrary.getCurrentUser()));

                            }
                        }
                        break;
                    case 4:
                        System.out.println("Fines have been paid.");
                        currentLibrary.getCurrentUser().setFines(0);
                        break;
                    case 5:
                        System.out.println("Enter the title of the book you want to review: ");
                        title = keyboard.nextLine();
                        try {
                            currentLibrary.giveRating(title);
                        }catch(Exception e){
                            System.out.println("Title not found");
                        }
                        break;
                    case 6:
                        System.out.println("Enter the title of the book you want to read reviews: ");
                        title = keyboard.nextLine();
                        try {
                            currentLibrary.displayRatings(title);
                        }catch(Exception e){System.out.println("Title not found");
                            System.out.println("\nPress Enter key to continue.");
                            fix = keyboard.nextLine();}
                            break;

                    case 0:
                        currentLibrary.saveAccountsToFile();
                        currentLibrary.saveMediaToFile();
                        login = false;
                        System.out.println("\n\nYou have successfully logged out\nPress Enter key to continue.");
                        fix = keyboard.nextLine();
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
