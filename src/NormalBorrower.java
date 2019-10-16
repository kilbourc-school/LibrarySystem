package csce247.LibraryCatalogSystem;
import java.lang.String;

/*
 * 
 * This class regulates students borrowing books. Restrictions
 * include a two book limit and a two week limit on borrowed
 * material.
 */ 

public class NormalBorrower extends Borrower {
  //Fields for each borrower's info.
  private int borrowLimit = 10;    //Two book limit.

  //Constructor.
  public NormalBorrower(String ID, String n, int b) {
    super(n, ID, b);
  }

  /*
   * Students can only borrow 2 books at a time, for
   * 14 days each. If either of these conditions is
   * exceeded, the student cannot borrow books.
   * Params: Time the book has been borrowed for and
   * the number of books borrowed.
   */
  public Boolean allowBorrow(int borrowTime, int bookCount) {
    if (borrowTime >= 14 || bookCount >= 2)
      return false;
    else
      return true;
  }

}

