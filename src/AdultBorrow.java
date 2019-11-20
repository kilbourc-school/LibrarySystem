import java.time.LocalDate;

public class AdultBorrow extends Borrower {
    /*
    Amount set for how many medias an AdultBorrower can checkout
     */
    int borrowLimit = 10;

    /*
     Constructor for Adult Borrow
     Parameters:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin
     Super:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin (calls from Borrower)
    */
    public AdultBorrow(String name, Long iD, LocalDate birthday, int pn,
                       String str1, String cty, String st, int zp,
                       String em, String pw, boolean isAdmin, double fines) {
        super(name, iD, birthday, pn, str1, cty, st, zp, em, pw, isAdmin, fines);

    }

    public AdultBorrow() {
        super();
        isAdmin = false;
    }



    /*
    returns borrowLimit value
     */
    public int getBorrowLimit() {
        return borrowLimit;
    }

    /*
    Converts objects into strings
     */
    public String toStringList() {
        return borrowLimit + super.toStringList();
    }
}
