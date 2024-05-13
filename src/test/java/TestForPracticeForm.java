import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestForPracticeForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void fillFormTest() {
        open("/automation-practice-form");
        $("#firstName").setValue("Dmitrii");
        $("#lastName").setValue("Borovkov");
        $("#userEmail").setValue("test@test.com");
        $("#genterWrapper .custom-control-label").click();
        $("#userNumber").setValue("79998887700");

        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1987");
        $(".react-datepicker__month-select").selectOptionByValue("1");
        $(".react-datepicker__day--026").click();

        $("#subjectsInput").setValue("Maths").pressEnter();

        $("label[for=hobbies-checkbox-1]").click();
        $("label[for=hobbies-checkbox-3]").click();

        $("#uploadPicture").uploadFromClasspath("rr.png");

        $("#currentAddress").setValue("My Adress");
        $("#react-select-3-input").setValue("NCR").pressEnter();
        $("#react-select-4-input").setValue("Delhi").pressEnter();

        $("#submit").click();

        $(".table-dark tbody tr", 0).shouldHave(text("Dmitrii Borovkov"));
        $(".table-dark tbody tr", 1).shouldHave(text("test@test.com"));
        $(".table-dark tbody tr", 2).shouldHave(text("Male"));
        $(".table-dark tbody tr", 3).shouldHave(text("7999888770"));
        $(".table-dark tbody tr", 4).shouldHave(text("26 February,1987"));
        $(".table-dark tbody tr", 5).shouldHave(text("Maths"));
        $(".table-dark tbody tr", 6).shouldHave(text("Sports, Music"));
        $(".table-dark tbody tr", 7).shouldHave(text("rr.png"));
        $(".table-dark tbody tr", 8).shouldHave(text("My Adress"));
        $(".table-dark tbody tr", 9).shouldHave(text("NCR Delhi"));




    }
}
