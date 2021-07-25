package guru.qa;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void testRepositoryIssue() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com");
        $("input[name=q]").setValue("eroshenkoam/allure-example").pressEnter();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $("#issues-tab").click();
        $("#issue_68").shouldHave(Condition.text("Listeners NamedBy"));
    }
}