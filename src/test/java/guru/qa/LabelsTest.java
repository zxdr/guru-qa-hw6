package guru.qa;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    @Test
    @Feature("Issues")
    @Story("Поиск по Issue")
    @Owner("QA man")
    @Severity(SeverityLevel.BLOCKER)
    @Link(name = "GitHub", url = "https://github.com")
    @Description(
            "Этот тест нужно бла-бла-бла..."
    )
    @DisplayName("Проверка работы поиска по Issues через Аннотации")
    public void testLabelsWithAnnotations() {

    }

    @Test
    @DisplayName("Проверка работы поиска по Issues через Методы")
    public void testLabelsWithMethods() {
        Allure.feature("Issues");
        Allure.story("Поиск по Issue");
        Allure.label("owner", "eroshenkoam");
        Allure.label("severity", SeverityLevel.BLOCKER.toString());
        Allure.link("GitHub", "https://github.com");
        Allure.description("Этот тест нужно бла-бла-бла...");
    }
}