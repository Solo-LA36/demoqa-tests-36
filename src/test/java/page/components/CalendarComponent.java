package page.components;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;


public class CalendarComponent {
    private final SelenideElement monthSelect = $(".react-datepicker__month-select");
    private final SelenideElement yearSelect = $(".react-datepicker__year-select");
    private SelenideElement daySelect;

    public void setDate(String day, String month, String year) {
        SelenideElement daySelect = $(".react-datepicker__day--0" + day);

            monthSelect.selectOption(month);
            yearSelect.selectOption(year);
            daySelect.click();
        }




}
