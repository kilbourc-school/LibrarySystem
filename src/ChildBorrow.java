import java.time.LocalDate;

public class ChildBorrow extends Borrower {
    /*
   Amount set for how many books an ChildBorrower can checkout
    */
    int borrowLimit = 3;
   // Borrower parent;

    /*
    Constructor for Child Borrow
    Parameters:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin
    Super:name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin (calls from Borrower)
    */
    public ChildBorrow(String name, Long iD, LocalDate birthday, int pn,
                       String str1, String cty, String st, int zp,
                       String em, String pw, boolean isAdmin, double fines) {
        super(name, iD, birthday, pn, str1, cty, st, zp, em, pw, isAdmin,fines);

    }
    //could initialize all variables to parent
    public ChildBorrow(Borrower parent){
        super();
        isAdmin = false;
//        this.parent= parent;
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
    public String toStringList() {
        return borrowLimit + super.toStringList();
    }
}
