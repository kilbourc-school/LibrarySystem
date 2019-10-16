
/*
 * 
 * This is an abstract class that will
 * be extended by teacher and student borrowers.
 */

import java.util.*;

public abstract class Borrower {
  private String name;
  private Date birthday; 
  private String ID;
  private int phoneNum;
  private String email;
  private String password;
  private int cardNum;

  //Use interface to modify borrow limits
  BorrowBehavior  borrowBehavior;

  private String street1,city,state;
  private int zip;

  //Default builds an empty borrower
  public Borrower(){ }

  //Constructor. Params for name and ID of user.
  public Borrower(String name, String iD, Date birthday, int pn,
                  String str1, String cty, String st, int zp,
                  String em, String pw, int cn){
    name = name;
    ID = iD;
    birthday = birthday;
    phoneNum = pn;
    street1 =str1; city=cty; state=st; zip = zp;
    email = em; password = pw; cardNum =cn;

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
