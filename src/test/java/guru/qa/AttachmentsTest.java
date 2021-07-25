package guru.qa;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class AttachmentsTest {

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void testAttachments() {
        open("https://github.com");
        step("Сделали скриншот с помощью аннотации", () -> {
            annotatedAttachment();
        });

        step("Сделали скриншот с помощью метода", () -> {
            String source = WebDriverRunner.getWebDriver().getPageSource();
            Allure.attachment("Исходный код страницы", source);
        });

    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] annotatedAttachment() {
        return Selenide.screenshot(OutputType.BYTES);
    }
}