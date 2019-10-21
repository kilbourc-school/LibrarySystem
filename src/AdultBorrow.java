
public class AdultBorrow extends Borrower implements BorrowBehavior {
    int borrowLimit =  10;
    public int getBorrowLimit() {
        return borrowLimit;
    }
}
