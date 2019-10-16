package csce247.LibraryCatalogSystem;
/*
 * 
 * This class regulates teachers borrowing books. Restrictions
 * include a one book limit and a three week limit on borrowed
 * material.
 */ 

public class TeacherBorrower extends Borrower {
  private int borrowLimit = 50;    //Two book limit.


  public TeacherBorrower(String name, String ID, int birthday) {
    super(name, ID, birthday);

  }

  /*
   * Teachers can only borrow 2 books at a time, for
   * 14 days each. If either of these conditions is
   * exceeded, the teacher cannot borrow books.
   * Params: Time the book has been borrowed for and
   * the number of books borrowed.
   */
  public Boolean allowBorrow() {
    if(borrowLimit < 1)
      return false;
    else
      return true;
  }

}