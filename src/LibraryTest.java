import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {


    @org.junit.jupiter.api.Test
    void getMediaFromTitle() {
        Library currentLibrary = new Library();
        currentLibrary.readInMedia();
        Media testMedia = currentLibrary.getMediaFromTitle("The Cat in the Hat");
        assertEquals(testMedia.getTitle(), "The Cat in the Hat");
    }

    @org.junit.jupiter.api.Test
    void getMediaFromTitleNotInLibrary() {
        Library currentLibrary = new Library();
        currentLibrary.readInMedia();
        Media testMedia = currentLibrary.getMediaFromTitle("The Cat in the Hat");
        assertNotEquals("The Cat in the Hat but not correct", testMedia.getTitle());
    }

    @org.junit.jupiter.api.Test
    void TestCorrectVerifyAccount() {
        Library currentLibrary = new Library();
        AdultBorrow adultAcc = new AdultBorrow("name", 1L, LocalDate.now(), 1, "str", "cty", "st", 29229,
                "e@e", "pw", false, 0.0);
        currentLibrary.addAdultAccount(adultAcc);
        Boolean checkVerify = currentLibrary.verifyAccount(adultAcc.getEmail(), adultAcc.getPassword());
        assertEquals(true, checkVerify);
    }

    @org.junit.jupiter.api.Test
    void TestFalseVerifyAccount() {
        Library currentLibrary = new Library();
        AdultBorrow adultAcc = new AdultBorrow("name", 1L, LocalDate.now(), 1, "str", "cty", "st", 29229,
                "e@e", "pw", false, 0.0);
        currentLibrary.addAdultAccount(adultAcc);
        Boolean checkVerify = currentLibrary.verifyAccount(adultAcc.getEmail() + "wrong email", adultAcc.getPassword());
        assertNotEquals(true, checkVerify);
    }

    @org.junit.jupiter.api.Test
    void getCurrentUser() {
        Library currentLibrary = new Library();
        AdultBorrow adultAcc = new AdultBorrow("name", 1L, LocalDate.now(), 1, "str", "cty", "st", 29229,
                "e@e", "pw", false, 0.0);
        currentLibrary.addAdultAccount(adultAcc);
        currentLibrary.verifyAccount(adultAcc.getEmail(), adultAcc.getPassword());
        assertEquals(adultAcc, currentLibrary.getCurrentUser());
    }

}