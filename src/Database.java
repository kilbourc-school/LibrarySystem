import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Database {
    /*
    /Holds all books.
     */
    ArrayList<Media> MediaDatabase = new ArrayList<>();
    /*
    /Holds all teachers.
     */
    ArrayList<Borrower> AccountsDatabase = new ArrayList<>();

    /*
    /Prints out the contents of the Library.
     */
    public void displayBooks() {
        for (int i = 0; i < MediaDatabase.size(); i++) {
            System.out.println(MediaDatabase.get(i));
        }
    }

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

    /*
    /Prints out the teachers accounts
     */
    public void displayTeachersAccounts() {

        for (Borrower account : AccountsDatabase) {
            if (account.getBorrowLimit() == 50)
                System.out.println(account);
        }
    }

    /*
    /Prints out the teachers accounts
     */
    public void displayAdultAccounts() {

        for (Borrower account : AccountsDatabase) {
            if (account.getBorrowLimit() == 10)
                System.out.println(account);
        }
    }

    //Prints out the teachers accounts
    public void displayChildAccounts() {

        for (Borrower account : AccountsDatabase) {
            if (account.getBorrowLimit() == 3)
                System.out.println(account);
        }
    }

    /*
    prints out all accounts
     */
    public void displayAllAccounts() {

        for (Borrower account : AccountsDatabase) {
            System.out.println(account);
        }
    }


    public void readInMedia() {
        File file = new File("media.txt");
        Scanner scan;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                LinkedList<iDandCopies> current = new LinkedList<>();
                LinkedList<iDandCopies> wait = new LinkedList<>();
                String line = scan.nextLine();
                String[] lineArray = line.split(",");
                String[] currentCheckOut = lineArray[10].split(".");
                String[] waitCheckOut = lineArray[11].split(".");

                for (int i = 0; i < currentCheckOut.length; i++) {
                    String[] splitCurrentCheckout = currentCheckOut[i].split("/");
                    current.add(new iDandCopies(Long.parseLong(splitCurrentCheckout[0]), Integer.parseInt(splitCurrentCheckout[0])));
                }

                for (int i = 0; i < waitCheckOut.length; i++) {
                    String[] splitWaitCheckout = waitCheckOut[i].split("/");
                    current.add(new iDandCopies(Long.parseLong(splitWaitCheckout[0]), Integer.parseInt(splitWaitCheckout[0])));
                }
                if (lineArray[0].equals("Book")) {

                    getMediaDatabase().add(new Book(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]), Integer.parseInt(lineArray[8]), Boolean.parseBoolean(lineArray[9]), current, wait, Integer.parseInt(lineArray[12])));
                } else if (lineArray[0].equals("AudioBook")) {
                    getMediaDatabase().add(new AudioBook(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]), Integer.parseInt(lineArray[8]), Boolean.parseBoolean(lineArray[9]), current, wait, lineArray[12]));
                } else if (lineArray[0].equals("DVD")) {
                    getMediaDatabase().add(new DVD(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]), Integer.parseInt(lineArray[8]), Boolean.parseBoolean(lineArray[9]), current, wait));
                } else if (lineArray[0].equals("EBook")) {
                    getMediaDatabase().add(new EBook(lineArray[1], lineArray[2], lineArray[3], lineArray[4], Integer.parseInt(lineArray[5]), lineArray[6], Integer.parseInt(lineArray[7]), Integer.parseInt(lineArray[8]), Boolean.parseBoolean(lineArray[9]), current, wait, Integer.parseInt(lineArray[12])));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }

    }

    public void readInAccounts() {
        File file = new File("account.txt");
        Scanner scan;
        try {
            scan = new Scanner(file);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                String[] lineArray = line.split(",");
                if (Integer.parseInt(lineArray[0]) == 3) {
                    getAccountsDatabase().add(new ChildBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                } else if (Integer.parseInt(lineArray[0]) == 10) {
                    getAccountsDatabase().add(new AdultBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                } else if (Integer.parseInt(lineArray[0]) == 50) {
                    getAccountsDatabase().add(new TeacherBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                } else if (Boolean.parseBoolean(lineArray[12])) {
                    getAccountsDatabase().add(new AdminBorrow(lineArray[1], Long.parseLong(lineArray[2]), LocalDate.parse(lineArray[3]), Integer.parseInt(lineArray[4]), lineArray[5], lineArray[6], lineArray[7], Integer.parseInt(lineArray[8]), lineArray[9], lineArray[10], Boolean.parseBoolean(lineArray[11]), Double.parseDouble(lineArray[12])));
                }

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addAdminAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, boolean isAdmin, double fines) {
        getAccountsDatabase().add(new AdminBorrow(name, Long.parseLong(iD), birthday, pn, str1, cty, st, zp, em, pw, isAdmin, fines));
    }

    public void addTeacherAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, boolean isAdmin, double fines) {
        getAccountsDatabase().add(new TeacherBorrow(name, Long.parseLong(iD), birthday, pn, str1, cty, st, zp, em, pw, isAdmin, fines));
    }

    public void addAdultAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, boolean isAdmin, double fines) {
        getAccountsDatabase().add(new AdultBorrow(name, Long.parseLong(iD), birthday, pn, str1, cty, st, zp, em, pw, isAdmin, fines));
    }

    public void addChildAccount(String name, String iD, LocalDate birthday, int pn, String str1, String cty, String st, int zp, String em, String pw, boolean isAdmin, double fines) {
        getAccountsDatabase().add(new ChildBorrow(name, Long.parseLong(iD), birthday, pn, str1, cty, st, zp, em, pw, isAdmin, fines));
    }

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
