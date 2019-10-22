
/*
 * 
 * This is an abstract class that will
 * be extended by teacher and student borrowers.
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public abstract class Borrower {
  private String name;
  private  LocalDate birthday;
  private String ID;
  private int phoneNum;
  private String email;
  private String password;
  private int cardNum;
  private String street1,city,state;
  private int zip;

    //Use interface to modify borrow limits
  BorrowBehavior  borrowBehavior;

  //Default builds an empty borrower
  public Borrower(){ }

  //Constructor. Params for name and ID of user.
  public Borrower(String name, String iD, LocalDate birthday, int pn,
                  String str1, String cty, String st, int zp,
                  String em, String pw, int cn){
    this.name = name;
    ID = iD;
    this.birthday = birthday;
    this.phoneNum = pn;
    street1 =str1; city=cty; state=st; zip = zp;
    email = em; password = pw; cardNum =cn;

  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public String getName() {
    return name;
  }

  public String getID() {
    return ID;
  }

  public String getBirthday() {
    return birthday.toString();
  }

  public void setBorrowBehavior(BorrowBehavior bb){
    borrowBehavior = bb;
  }

  @Override
  public String toString() {
    return
            "name=" + name + " ID=" + ID;
  }
  // check age vs current time for child age
  // boolean or int years return, not sure which to use
  public boolean checkAge(){
      LocalDate today = LocalDate.now();
      return (Period.between(birthday,today).getYears()>13);

  }
  public int checkAgeYear (){
    LocalDate today = LocalDate.now();
    return Period.between(birthday,today).getYears();
  }


  public abstract int getBorrowLimit();
}
