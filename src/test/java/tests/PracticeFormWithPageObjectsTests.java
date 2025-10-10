package tests;

import org.junit.jupiter.api.Test;
import page.PracticeFormPages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectsTests extends TestBase {

    PracticeFormPages practiceFormPages = new PracticeFormPages();


    @Test
    void fillFormTest() {
        practiceFormPages.openPage()
                .setFirstName("Alex")
                .setLastName("Ivanov")
                .setEmail("AIvanov@mail.ru")
                .setGender("Male")
                .setUserNumber("9601390099")
                .setDateOfBirth("25", "August", "1982");


        $("#subjectsInput").setValue("Math").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#uploadPicture").uploadFromClasspath("Photo.png");
        $("#currentAddress").setValue("Some address 1");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("NCR")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Delhi")).click();
        $("#submit").click();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldHave(text("Alex"), text("Ivanov"),
                text("AIvanov@mail.ru"), text("9601390099"));
        practiceFormPages.checkResult("Student Name", "Alex Ivanov")
                .checkResult("Student Email", "AIvanov@mail.ru");
    }
}
