import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {



    @org.junit.jupiter.api.Test
    void getMediaFromTitle() {
        Library currentLibrary = new Library();
currentLibrary.readInMedia();
Media test = currentLibrary.getMediaFromTitle("The Cat in the Hat");
assertEquals( test.getTitle(),"The Cat in the Hat");
    }

    @org.junit.jupiter.api.Test
    void TestCorrectVerifyAccount() {
        Library currentLibrary = new Library();
        AdultBorrow adultAcc = new AdultBorrow("name",1L, LocalDate.now(),1,"str", "cty","st",29229,
                "e@e","pw", false,0.0);
        currentLibrary.addAdultAccount(adultAcc);
        Boolean check = currentLibrary.verifyAccount(adultAcc.getEmail(), adultAcc.getPassword());
        assertEquals(true,check);
    }
    @org.junit.jupiter.api.Test
    void getCurrentUser() {
        Library currentLibrary = new Library();
        AdultBorrow adultAcc = new AdultBorrow("name",1L, LocalDate.now(),1,"str", "cty","st",29229,
                "e@e","pw", false,0.0);
        currentLibrary.addAdultAccount(adultAcc);
        Boolean check = currentLibrary.verifyAccount(adultAcc.getEmail(), adultAcc.getPassword());
        if(adultAcc.equals(currentLibrary.getCurrentUser())) assertTrue(true);
    assertEquals(adultAcc,currentLibrary.getCurrentUser());
    }

}