
/*
 *
 * This is an abstract class that will
 * be extended by teacher and student borrowers.
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public abstract class Borrower {
    Scanner keyboard = new Scanner(System.in);
    boolean isAdmin;

    //Use interface to modify borrow limits
    /*
    Variables for class created
     */
    private String name;
    private LocalDate birthday;
    private Long ID;
    private int phoneNum;
    private String email;
    private String password;
    private String street1, city, state;
    private int zip;
    private double fines;


    //Default builds an empty borrower
    public Borrower() {
        setName();
        setBirthday();
        setID();
        setPhoneNum();
        setEmail();
        setPassword();
        setAddress();
    }

    //Constructor. Params for name and ID of user.
    public Borrower(String name, Long iD, LocalDate birthday, int pn,
                    String str1, String cty, String st, int zp,
                    String em, String pw, boolean isAdmin, double fines) {
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
        this.isAdmin = isAdmin;
        this.fines = fines;

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

    public double getFines() {
        return fines;
    }
    /**
     * Borrower Setters
     */

    public void setName(){
        System.out.print("Name: ");
        this.setName(keyboard.nextLine());
    }
    public void setBirthday(){
        System.out.print("Birthday Month (1-12): ");
        int month = keyboard.nextInt();
        System.out.print("Birthday date: ");
        int day = keyboard.nextInt();
        System.out.print("Birthday year: ");
        int year = keyboard.nextInt();
        String fix = keyboard.nextLine();
        this.birthday= LocalDate.of(year,month,day);
    }

    public void setID(){
        System.out.print("Drivers License Number (just numbers): ");
        this.setID(keyboard.nextLong());
        String fix = keyboard.nextLine();
    }
    public void setPhoneNum(){
        System.out.print("PhoneNum (no spaces or characters): ");
        phoneNum = keyboard.nextInt();
        String fix = keyboard.nextLine();
    }
    public void setEmail(){
        System.out.print("Email: ");
        this.setEmail(keyboard.nextLine());
    }
    public void setPassword(){
        System.out.print("Password: ");
        this.setPassword(keyboard.nextLine());
    }

    public void setAddress(){
        System.out.print("Street: ");
        this.setStreet1(keyboard.nextLine());
        System.out.print("City: ");
        this.setCity(keyboard.nextLine());
        System.out.print("State: ");
        this.setState(keyboard.nextLine());
        System.out.print("Zip:  ");
        this.setZip(keyboard.nextInt());
    }


    public void setFines(double fines) {
        this.fines = fines;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Name= " + name + " Email= " + getEmail() + " ID= " + getID();
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
    public String toStringList(){
      return  "," + getName() + "," + getID() + "," + getBirthday() + "," + getPhoneNum() + "," + getStreet1() + "," + getCity() + "," + getState() + "," + getZip() + "," + getEmail() + "," + getPassword() + "," + isAdmin+ ","+getFines();
    }
}

