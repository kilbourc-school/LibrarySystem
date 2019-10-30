
/*
 *
 * This is an abstract class that will
 * be extended by teacher and student borrowers.
 */

import java.time.LocalDate;
import java.time.Period;

public abstract class Borrower {
    boolean isAdmin;
    //Use interface to modify borrow limits
    BorrowBehavior borrowBehavior;
    /*
    Variables for class created
     */
    private String name;
    private LocalDate birthday;
    private String ID;
    private int phoneNum;
    private String email;
    private String password;
    private int cardNum;
    private String street1, city, state;
    private int zip;

    //Default builds an empty borrower
    public Borrower() {
    }

    //Constructor. Params for name and ID of user.
    public Borrower(String name, String iD, LocalDate birthday, int pn,
                    String str1, String cty, String st, int zp,
                    String em, String pw, int cn, boolean isAdmin) {
        this.name = name;
        ID = iD;
        this.birthday = birthday;
        this.phoneNum = pn;
        street1 = str1;
        city = cty;
        state = st;
        zip = zp;
        email = em;
        password = pw;
        cardNum = cn;
        this.isAdmin = isAdmin;

    }
    /*
      Getters
     */
    public int getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(int phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getCardNum() {
        return cardNum;
    }

    public void setCardNum(int cardNum) {
        this.cardNum = cardNum;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    /**
     * getters
     *
     * @return
     */


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    /**
     * Borrower Setters
     */

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getBirthday() {
        return birthday.toString();
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public void setBorrowBehavior(BorrowBehavior bb) {
        borrowBehavior = bb;
    }

    @Override
    public String toString() {
        return "Name= " + name + " Email= " + getEmail() + "ID= " + getID();
    }

    // check age vs current time for child age
    // boolean or int years return, not sure which to use
    public boolean checkAge() {
        LocalDate today = LocalDate.now();
        return (Period.between(birthday, today).getYears() > 13);

    }
    /*
     checks age year for child age
     */
    public int checkAgeYear() {
        LocalDate today = LocalDate.now();
        return Period.between(birthday, today).getYears();
    }
    /*
     getBorrowedlimit  method from medium interface
     */
    public abstract int getBorrowLimit();
     /*
     toString method from medium interface
      */
    public abstract String toStringList();
}
