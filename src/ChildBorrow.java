import java.time.LocalDate;

public class ChildBorrow extends Borrower implements BorrowBehavior{
    /*
   Amount set for how many books an ChildBorrower can checkout
    */
    int borrowLimit =  3;
    /*
    Constructor for Child Borrow
    Parameters:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin
    Super:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin (calls from Borrower)
    */
    public ChildBorrow(String name, String iD, LocalDate birthday, int pn,
                         String str1, String cty, String st, int zp,
                         String em, String pw, int cn, boolean isAdmin){
        super(name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin);

    }
    /*
    returns the amount of variable borrowLimit
     */
    public int getBorrowLimit() {
        return borrowLimit;
    }
    /*
    Converts objects to strings
    */
    public String toStringList(){
        return borrowLimit+getName()+","+getID()+","+getBirthday()+","+getPassword()+","+getStreet1()+","+getCity()+","+getState()+","+getZip()+","+getEmail()+","+getPassword()+","+getCardNum()+","+isAdmin;
    }
}
