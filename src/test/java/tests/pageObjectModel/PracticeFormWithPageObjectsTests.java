package tests.pageObjectModel;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.FindBy;
import page.PracticeFormPages;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormWithPageObjectsTests extends TestBase {

    PracticeFormPages practiceFormPages = new PracticeFormPages();

    String username = "Alex";
    String lastName = "Ivanov";
    String email = "AIvanov@mail.ru";
    String gender = "Male";
    String userNumber = "9601390099";
    String[] birthday = new String[] {"25", "August", "1982"};
    String hobbies = "Sports";
    String uploadFile = "Photo.png";
    String adress = "Some address 1";



    @Test
    void fillFormTest() {
        practiceFormPages.openPage()
                .removeAds()
                .setFirstName(username)
                .setLastName(lastName)
                .setEmail(email)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthday [0], birthday[1], birthday[2])
                .uploadPicture(uploadFile)
                .setAdress(adress)
                .setSubjects("Math")
                .setHobbies(hobbies);



 //       $("#subjectsInput").setValue("Math").pressEnter();
 //       $("#hobbiesWrapper").$(byText("Sports")).click();
 //       $("#uploadPicture").uploadFromClasspath("Photo.png");
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
