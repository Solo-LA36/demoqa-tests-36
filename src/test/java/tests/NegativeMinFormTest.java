package tests;

import org.junit.jupiter.api.Test;
import page.PracticeFormPages;

public class NegativeMinFormTest {

    PracticeFormPages practiceFormPages = new PracticeFormPages();

    @Test
    public void negativeMinFormTest() {

        String userName = "Alex";
        String lastName = "Ivanov";
        String gender = "Male";



        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(userName)
                .setLastName(lastName)
                .setGender(gender)
                .setNumber("");

        practiceFormPages.verifyResultsModalAppearsNeg();
    }
}