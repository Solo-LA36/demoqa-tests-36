package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        System.out.println("\n###  beforeAll()\n");
    }


        @Test
        void successfulSearchTest() {
            open("https://demoqa.com/automation-practice-form");
            $("#firstName").setValue("Alex");
            $("#lastName").setValue("Ivanov");
            $("#userEmail").setValue("AIvanov@mail.ru");
            $("").shouldHave(text(""));
        }
}