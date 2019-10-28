import java.time.LocalDate;

public class AdminBorrow extends Borrower implements BorrowBehavior {
    /*
    Amount set for how many books an AdminBorrower can checkout
     */
    int borrowLimit = 500;

    /*
    Constructor for Admin Borrow
    Parameters:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin
    Super:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin (calls from Borrower)
    */
    public AdminBorrow(String name, String iD, LocalDate birthday, int pn,
                       String str1, String cty, String st, int zp,
                       String em, String pw, int cn, boolean isAdmin) {
        super(name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin);

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
        return borrowLimit + "," + getName() + "," + getID() + "," + getBirthday() + "," + getPhoneNum() + "," + getStreet1() + "," + getCity() + "," + getState() + "," + getZip() + "," + getEmail() + "," + getPassword() + "," + getCardNum() + "," + isAdmin;
    }
}
