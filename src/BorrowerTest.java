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
        int changePhone = 5;
        user.setPhoneNum(changePhone);
        assertEquals(user.getPhoneNum(), changePhone);
    }

    @Test
    void getStreet1() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getStreet1(), "Main Street");
    }
    @Test
    void setStreet1(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String changeStreet = "John Jacob Jingle Hemmer Schmidt";
        user.setStreet1(changeStreet);
        assertEquals(user.getStreet1(), changeStreet);
    }

    @Test
    void getCity() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getCity(), city);
    }
    @Test
    void setCity(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String changeCity = "John Jacob Jingle Hemmer Schmidt";
        user.setCity(changeCity);
        assertEquals(user.getCity(), changeCity);
    }

    @Test
    void getState() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getState(), state);
    }
    @Test
    void setState(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String changeState = "John Jacob Jingle Hemmer Schmidt";
        user.setState(changeState);
        assertEquals(user.getState(), changeState);
    }

    @Test
    void getZip() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getZip(), zip);
    }
    @Test
    void setZip(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        int changeZip = 5;
        user.setZip(changeZip);
        assertEquals(user.getZip(), changeZip);
    }

    @Test
    void isAdminTrue() {
        AdminBorrow user = new AdminBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, true, fines);
        assertEquals(true,user.isAdmin);
    }

    @Test
    void isAdminFalse() {
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
    assertNotEquals(true,user.isAdmin);
    }

    @Test
    void getEmail() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getEmail(), email);
    }
    @Test
    void setEmail(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String changeEmail = "John Jacob Jingle Hemmer Schmidt";
        user.setEmail(changeEmail);
        assertEquals(user.getEmail(), changeEmail);
    }

    @Test
    void getPassword() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getPassword(), password);
    }
    @Test
    void setPassword(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String changePassword = "John Jacob Jingle Hemmer Schmidt";
        user.setPassword(changePassword);
        assertEquals(user.getPassword(), changePassword);
    }

    @Test
    void getName() {
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        assertEquals(user.getName(), name);
    }
    @Test
    void setName(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        String changeName = "John Jacob Jingle Hemmer Schmidt";
        user.setName(changeName);
        assertEquals(user.getName(), changeName);
    }

    @Test
    void getFines() {
        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( user.getFines(), fines);
    }
    @Test
    void setFines(){
        AdultBorrow user = new AdultBorrow(name, ID, birthday, phoneNum, street1, city, state, zip, email, password, false, fines);
        double changeFine = 5.0;
        user.setFines(changeFine);
        assertEquals(user.getFines(), changeFine);
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