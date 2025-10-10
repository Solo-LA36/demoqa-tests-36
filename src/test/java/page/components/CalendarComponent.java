package page.components;


import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {


public void setDate(String day, String month, String year) {
    $(".react-datepicker__month-select").selectOption("August");
    $(".react-datepicker__year-select").selectOption("1982");
    $(".react-datepicker__day--025:not(.react-datepicker__day--outside-month)").click();
}


}
