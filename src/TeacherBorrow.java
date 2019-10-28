import java.time.LocalDate;

public class TeacherBorrow extends Borrower implements BorrowBehavior {
    /*
    Amount set for how many books an TeacherBorrower can checkout
     */
    int borrowLimit = 50;

    /*
   Constructor for Teacher Borrow
   Parameters:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin
   Super:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin (calls from Borrower)
   */
    public TeacherBorrow(String name, String iD, LocalDate birthday, int pn,
                         String str1, String cty, String st, int zp,
                         String em, String pw, int cn, boolean isAdmin) {
        super(name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin);

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
        return borrowLimit + getName() + "," + getID() + "," + getBirthday() + "," + getPhoneNum() + "," + getStreet1() + "," + getCity() + "," + getState() + "," + getZip() + "," + getEmail() + "," + getPassword() + "," + getCardNum() + "," + isAdmin;
    }
}
