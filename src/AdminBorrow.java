import java.time.LocalDate;

public class AdminBorrow extends Borrower {
    /*
    Amount set for how many books an AdminBorrower can checkout
     */
    int borrowLimit = 500;

    /*
    Constructor for Admin Borrow
    Parameters:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin
    Super:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin (calls from Borrower)
    */
    public AdminBorrow(String name, Long iD, LocalDate birthday, int pn,
                       String str1, String cty, String st, int zp,
                       String em, String pw, boolean isAdmin, double fines) {
        super(name, iD, birthday, pn, str1, cty, st, zp, em, pw, isAdmin,fines);

    }

    /*
    returns the amount of variable borrowLimit
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
