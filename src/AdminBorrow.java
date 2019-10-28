import java.time.LocalDate;

public class AdminBorrow extends Borrower implements BorrowBehavior {
    int borrowLimit = 500;

    public AdminBorrow(String name, String iD, LocalDate birthday, int pn,
                       String str1, String cty, String st, int zp,
                       String em, String pw, int cn, boolean isAdmin) {
        super(name, iD, birthday, pn, str1, cty, st, zp, em, pw, cn, isAdmin);

    }

    public int getBorrowLimit() {
        return borrowLimit;
    }

    public String toStringList() {
        return borrowLimit + "," + getName() + "," + getID() + "," + getBirthday() + "," + getPassword() + "," + getStreet1() + "," + getCity() + "," + getState() + "," + getZip() + "," + getEmail() + "," + getPassword() + "," + getCardNum() + "," + isAdmin;
    }
}
