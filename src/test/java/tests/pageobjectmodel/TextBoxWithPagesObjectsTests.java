package tests.pageobjectmodel;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import page.TextBoxPages;

public class TextBoxWithPagesObjectsTests extends TestBase {
    TextBoxPages textBoxPages = new TextBoxPages();
    Faker faker = new Faker();


    String userName = faker.name().fullName();
    String email = faker.internet().emailAddress();
    String currentAddress = faker.address().fullAddress();
    String permanentAddress = faker.address().secondaryAddress();

    @Test
    void successfulTextBoxTest() {
        textBoxPages.openPage()
                .removeAds()
                .setUserName(userName)
                .setEmail(email)
                .setCurrentAddress(currentAddress)
                .setPermanentAddress(permanentAddress)
                .submitForm();

        textBoxPages
                .verifyResult("Name:", userName)
                .verifyResult("Email:", email)
                .verifyResult("Current Address :", currentAddress)
                .verifyResult("Permananet Address :", permanentAddress);
    }
}
