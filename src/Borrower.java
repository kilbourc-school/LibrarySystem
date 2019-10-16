
/*
 * 
 * This is an abstract class that will
 * be extended by teacher and student borrowers.
 */ 

public abstract class Borrower {
  private String name;
  private String ID;
  private int birthday;
  BorrowBehavior  borrowBehavior;
  
  //Constructor. Params for name and ID of user.
  public Borrower(String name, String iD, int birthday){
    name = name;
    ID = iD;
    birthday = birthday;
  }

  public String getName() {
    return name;
  }

  public String getID() {
    return ID;
  }

  public int getBirthday() {
    return birthday;
  }

  public void setBorrowBehavior(BorrowBehavior bb){
    borrowBehavior = bb;
  }


}
