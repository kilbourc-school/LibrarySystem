import org.junit.jupiter.api.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BorrowerTest {

    String name = "Sarah";
    LocalDate birthday = LocalDate.of(1959, 1, 1);
    Long ID=234564L;
    int phoneNum=2341564;
    String email="user@user";
    String password="user";
    String street1="Main Street", city="Anytown", state="SC";
    int zip=29210;
    double fines=0.0;

    @BeforeAll
    public static void oneTimeSetUp() {
    }

    @BeforeEach
    void setUp() {
    }

    @AfterAll
    static void oneTimeTearDown() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getPhoneNum() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( phoneNum , user.getPhoneNum());
    }
    @Test
    void setPhoneNum(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        int change = 5;
        user.setPhoneNum(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getStreet1() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getStreet1(), "Main Street");
    }
    @Test
    void setStreet1(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String change = "John Jacob Jingle Hemmer Schmidt";
        user.setStreet1(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getCity() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getCity(), city);
    }
    @Test
    void setCity(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String change = "John Jacob Jingle Hemmer Schmidt";
        user.setCity(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getState() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getState(), state);
    }
    @Test
    void setState(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String change = "John Jacob Jingle Hemmer Schmidt";
        user.setState(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getZip() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getZip(), zip);
    }
    @Test
    void setZip(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        int change = 5;
        user.setZip(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void isAdmin() {
    }

    @Test
    void getEmail() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getEmail(), email);
    }
    @Test
    void setEmail(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String change = "John Jacob Jingle Hemmer Schmidt";
        user.setEmail(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getPassword() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getPassword(), password);
    }
    @Test
    void setPassword(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String change = "John Jacob Jingle Hemmer Schmidt";
        user.setPassword(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getName() {
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        assertEquals(user.getName(), name);
    }
    @Test
    void setName(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String change = "John Jacob Jingle Hemmer Schmidt";
        user.setName(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getFines() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getFines(), fines;
    }
    @Test
    void setFines(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        double change = 5.0;
        user.setFines(change);
        assertEquals(user.getName(), change);
    }

    @Test
    void getBirthday() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getBirthday(), birthday);
    }


    @Test
    void testToString() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.toString(), "Name= " + name + " Email= " + email + " ID= " + ID);
    }

    @Test
    void getBorrowLimit() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getBorrowLimit(), 10);
    }

    @Test
    void toStringList() {
        //tested in database junit testing
    }


}