package tests.pageobjectmodel;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SimpleTest extends TestBase {
    @Test
    void fullFormTest() {
        Faker faker = new Faker();


        String userName = faker.name().fullName();
        String userEmail = faker.internet().emailAddress();
        String currentAddress = faker.address().fullAddress();
        String permanentAddress = faker.address().secondaryAddress();


        open("/text-box");


        $("#userName").setValue(userName);
        $("#userEmail").setValue(userEmail);
        $("#currentAddress").setValue(currentAddress);
        $("#permanentAddress").setValue(permanentAddress);


        $("#submit").pressEnter();


        $("#output").shouldHave(
                text(userName),
                text(userEmail),
                text(currentAddress),
                text(permanentAddress)
        );
    }
}

