import org.junit.jupiter.api.*;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BorrowerTest {


    @BeforeAll
    static void oneTimeSetUp() {


    }

    @BeforeEach
    void setUp() {
        String name = "Sarah";
         LocalDate birthday = LocalDate.of(1959, 1, 1);
         Long ID=234564L;
         int phoneNum=2341564;
       String email="user@user";
         String password="user";
         String street1="Main Street", city="Anytown", state="SC";
         int zip=29210;
         double fines=0.0;

        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
    }

    @AfterAll
    static void oneTimeTearDown() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void getPhoneNum() {
        String name = "Sarah";
        LocalDate birthday = LocalDate.of(1959, 1, 1);
        Long ID=234564L;
        int phoneNum = 2341564;
        String email="user@user";
        String password="user";
        String street1="Main Street", city="Anytown", state="SC";
        int zip=29210;
        double fines=0.0;

        AdultBorrow user = new AdultBorrow(name,ID,birthday,phoneNum,street1,city,state,zip,email,password,false,fines);
        assertEquals( phoneNum , user.getPhoneNum());
    }

    @Test
    void getStreet1() {
    }

    @Test
    void getCity() {
    }

    @Test
    void getState() {
    }

    @Test
    void getZip() {
    }

    @Test
    void isAdmin() {
    }

    @Test
    void getEmail() {
    }

    @Test
    void getPassword() {
    }

    @Test
    void getName() {
    }

    @Test
    void getFines() {
    }

    @Test
    void getBirthday() {
    }

    @Test
    void testToString() {
    }

    @Test
    void checkAge() {
    }

    @Test
    void checkAgeYear() {
    }

    @Test
    void getBorrowLimit() {
    }

    @Test
    void toStringList() {
    }
}