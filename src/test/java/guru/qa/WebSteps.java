package guru.qa;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Открываем главную страницу")
    public void openMainPage() {
        open("https://github.com");
    }

    @Step("Ищем репозиторий {repository}")
    public void searchForRepository(String repository) {
        $("input[name=q]").setValue(repository).pressEnter();
    }

    @Step("Переходим в репозиторий {repository}")
    public void goToRepository(String repository) {
        $(By.linkText(repository)).click();
    }

    @Step("Переходим в раздел Issues")
    public void openIssuesTab() {
        $("#issues-tab").click();
    }

    @Step("Проверяем, что название issue равно {name}")
    public void shouldHaveTextOfIssue(String name) {
        $("#issue_68").shouldHave(Condition.text(name));
    }
}