package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.interactions.Actions;
import page.components.CalendarComponent;
import page.components.RegistrationResultsModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPages {
    private final SelenideElement firstNameInput = $("#firstName");
                  SelenideElement lastNameInput = $("#lastName");
                  SelenideElement userEmailInput = $("#userEmail");
                  SelenideElement genderWrapper = $("#genterWrapper");
                  SelenideElement userNumberInput = $("#userNumber");
                  SelenideElement calendarInput = $("#dateOfBirthInput");

    CalendarComponent calendarComponent = new CalendarComponent();
    RegistrationResultsModal registrationResultsModal = new RegistrationResultsModal();




    public PracticeFormPages openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }


    public PracticeFormPages setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public PracticeFormPages setEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPages setGender(String value) {
            genderWrapper.$(byText(value)).click();

        return this;
    }

    public PracticeFormPages setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }


    public PracticeFormPages setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        calendarComponent.setDate(day, month, year);


        return this;
    }

    public PracticeFormPages removeAds() {
        executeJavaScript("$('footer').remove();");
        executeJavaScript("$('#fixedban').remove();");

        return this;
    }

    public PracticeFormPages verifyResultsModalAppears() {
        registrationResultsModal.verifyModalAppears();

        return this;
    }

    public PracticeFormPages verifyResult(String key, String value) {
        registrationResultsModal.verifyResult(key, value);

        return this;
    }

    public PracticeFormPages verifyResultsModalAppearsNeg() {
        registrationResultsModal.verifyModalAppearsNegativ();

        return this;
    }

    public PracticeFormPages checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));

        return this;
    }

    public void setNumber(String s) {

    }
}