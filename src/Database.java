import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
    /*
    /Holds all medias.
     */
    ArrayList<Media> MediaDatabase = new ArrayList<>();
    /*
    /Holds all accounts.
     */
    ArrayList<Borrower> AccountsDatabase = new ArrayList<>();


    /*
     Returns mediaDatabase values
     */
    public ArrayList<Media> getMediaDatabase() {
        return MediaDatabase;
    }

    /*
     returns AccountsDatabase Values
     */
    public ArrayList<Borrower> getAccountsDatabase() {
        return AccountsDatabase;
    }

    /**
     * takes in a file, adds all objects found to the media database
     */
    public void readInMedia() {
        File file = new File("media.txt");
        Scanner scan;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                LinkedList<iDandCopies> current = new LinkedList<>();
                LinkedList<iDandCopies> wait = new LinkedList<>();
                LinkedList<Ratings> rating = new LinkedList<>();
                String line = scan.nextLine();
                String[] lineArray = line.split(",");
                String[] currentCheckOut = lineArray[9].split(".");
                String[] waitCheckOut = lineArray[10].split(".");
                String[] ratingsplit = lineArray[11].split(".");



                for (int i = 0; i < currentCheckOut.length; i++) {
                    String[] splitCurrentCheckout = currentCheckOut[i].split("/");
                    current.add(new iDandCopies(Long.parseLong(splitCurrentCheckout[0]), Integer.parseInt(splitCurrentCheckout[1]), LocalDate.parse(splitCurrentCheckout[2])));
                }

                //creates the LinkedList for wait list
                for (int i = 0; i < waitCheckOut.length; i++) {
                    String[] splitWaitCheckout = waitCheckOut[i].split("/");
                    wait.add(new iDandCopies(Long.parseLong(splitWaitCheckout[0]), Integer.parseInt(splitWaitCheckout[1]), LocalDate.parse(splitWaitCheckout[2])));
                }

                //creates the LinkedList for ratings
                for (int i = 0; i < ratingsplit.length; i++) {
                    String[] splitRatingSplit = ratingsplit[i].split("/");
                    System.out.println(ratingsplit[i]);
                    rating.add(new Ratings(Integer.parseInt(splitRatingSplit[0]),splitRatingSplit[1]));
                }

                /**
                 * adds the objects to the database
                 */
                if (lineArray[0].equals("Book")) {
                    getMediaDatabase().add(new Book(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]),Boolean.parseBoolean(lineArray[8]), current, wait, rating, lineArray[12]));
                } else if (lineArray[0].equals("AudioBook")) {
                    getMediaDatabase().add(new AudioBook(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]),Boolean.parseBoolean(lineArray[8]), current, wait, rating, lineArray[12]));
                } else if (lineArray[0].equals("DVD")) {
                    getMediaDatabase().add(new DVD(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]), Boolean.parseBoolean(lineArray[8]), current, wait, rating));
                } else if (lineArray[0].equals("EBook")) {
                    getMediaDatabase().add(new EBook(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]), Boolean.parseBoolean(lineArray[8]), current, wait, rating, lineArray[12]));
                } else if (lineArray[0].equals("Magazine")) {
                    getMediaDatabase().add(new Magazine(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]), Boolean.parseBoolean(lineArray[8]), current, wait,rating, Integer.parseInt(lineArray[12]),Integer.parseInt(lineArray[13])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    /**
     * reads in accounts, adds all objects found to accounts database
     */
    public void readInAccounts() {
        File file = new File("account.txt");
        Scanner scan;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] lineArray = line.split(",");

                //adds objects to database
                if (Integer.parseInt(lineArray[0]) == 3) {
                    getAccountsDatabase().add(new ChildBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                } else if (Integer.parseInt(lineArray[0]) == 10) {
                    getAccountsDatabase().add(new AdultBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                } else if (Integer.parseInt(lineArray[0]) == 50) {
                    getAccountsDatabase().add(new TeacherBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                } else if (Boolean.parseBoolean(lineArray[11])) {
                    getAccountsDatabase().add(new AdminBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * writes the current account database to file
     */
    public void saveAccountsToFile() {
        try {
            PrintWriter writer = new PrintWriter("account.txt");
            for (Borrower borrower : getAccountsDatabase()) {
                writer.println(borrower.toStringList());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }

    /**
     * writes the current media database to file
     */
    public void saveMediaToFile() {
        try {
            PrintWriter writer = new PrintWriter("media.txt");
            for (Media media : getMediaDatabase()) {
                writer.println(media.toStringList());
            }
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

    }

}
