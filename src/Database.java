import java.util.ArrayList;

public class Database {
    /*
    /Holds all books.
     */
    private ArrayList<Medium> MediaDatabase = new ArrayList<>();
    /*
    /Holds all teachers.
     */
    private ArrayList<Borrower> AccountsDatabase = new ArrayList<>();

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
    public ArrayList<Medium> getMediaDatabase() {
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


}
