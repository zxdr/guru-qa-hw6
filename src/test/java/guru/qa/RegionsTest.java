package guru.qa;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static io.qameta.allure.Allure.parameter;
import static io.qameta.allure.Allure.step;

public class RegionsTest {

    @ParameterizedTest(name = "Проверка сайта в регионах")
    @CsvSource({
            "Москва,Московская область",
            "Санкт-Петербург,Ленингадская область",
            "Череповец,Вологодская область"
    })

    public void testRegions(String city, String state) {
        parameter("Область", state);
        parameter("Город", city);

        step("Открываем сайт в регионе " + state);
        step("Проверяем что город определился как " + city);
    }
}