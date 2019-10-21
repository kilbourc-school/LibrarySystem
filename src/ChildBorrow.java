
public class ChildBorrow extends Borrower implements BorrowBehavior{
    int borrowLimit =  3;

    public int getBorrowLimit() {
        return borrowLimit;
    }
}
