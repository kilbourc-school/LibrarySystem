import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {

    @org.junit.jupiter.api.Test
    void getCurrentUser() {
        Library currentLibrary = new Library();
       some way to make a user, also set.

        assertTrue(userObject,currentLibrary.getCurrentUser());
    }

    @Test
    void getMediaFromTitle() {
        Library currentLibrary = new Library();

    }

    @org.junit.jupiter.api.Test
    void verifyAccount() {
        Library currentLibrary = new Library();
        currentLibrary.addAdultAccount();
        Boolean check = currentLibrary.verifyAccount(username, password);
        assertTrue(true,check);
    }
}