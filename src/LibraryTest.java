import org.junit.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @org.junit.jupiter.api.Test
    void getCurrentUser() {
       some way to make a user, also set.

        assertTrue(userObject,currentLibrary.getCurrentUser());
    }

    @Test
    void getMediaFromTitle() {
        Library currentLibrary = new Library();

    }

    @BeforeAll
    static void oneTimeSetUp() {

    }

    @BeforeEach
    void setUp() {
        Library currentLibrary = new Library();
    }


    @org.junit.jupiter.api.Test
    void TestCorrectVerifyAccount() {
        Library currentLibrary = new Library();
        currentLibrary.addAdultAccount();
        Boolean check = currentLibrary.verifyAccount(username, password);
        assertTrue(true,check);
    }
}