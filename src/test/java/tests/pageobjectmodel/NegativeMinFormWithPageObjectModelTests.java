package tests.pageobjectmodel;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import page.NegativeMinFormPage;



public class NegativeMinFormWithPageObjectModelTests extends TestBase {

    private final Faker faker = new Faker();

    @Test
    public void negativeMinFormTest() {

        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String emptyPhoneNumber = "";


        new NegativeMinFormPage()
                .openPage()
                .removeAds()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setGender()
                .setNumber(emptyPhoneNumber)
                .submitForm()
                .verifyPhoneFieldValidationError();
    }
}