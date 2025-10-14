package tests.pageObjectModel;

import org.junit.jupiter.api.Test;
import page.NegativeMinFormPage;

public class NegativeMinFormTest extends TestBase{

    @Test
    public void negativeMinFormTest() {
        new NegativeMinFormPage()
                .openPage()
                .removeAds()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setGender()
                .setNumber("")
                .submitForm()
                .verifyErrorModalDisplayed();
    }
}