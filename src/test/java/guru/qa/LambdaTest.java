package guru.qa;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class LambdaTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "Listeners NamedBy";

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void testRepositoryIssue() {
        step("Открываем главную страницу", () -> {
            open("https://github.com/");
        });

        step("Ищем репозиторий " + REPOSITORY, () -> {
            $("input[name=q]").setValue(REPOSITORY).pressEnter();
        });

        step("Переходим в репозиторий", () -> {
            $(By.linkText(REPOSITORY)).click();
        });

        step("Переходим в раздел Issues", () -> {
            $("#issues-tab").click();
        });

        step("Проверяем, что название issue равно " + ISSUE_NAME, () -> {
            $("#issue_68").shouldHave(Condition.text(ISSUE_NAME));
        });
    }
}