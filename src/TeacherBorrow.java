public class TeacherBorrow extends Borrower implements BorrowBehavior {
    int borrowLimit =  50;

    public int getBorrowLimit() {
        return borrowLimit;
    }
}
