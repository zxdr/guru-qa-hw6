package guru.qa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class AnnotatedStepTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "Listeners NamedBy";

    private WebSteps steps = new WebSteps();

    @BeforeAll
    static void setup() {
        Configuration.startMaximized = true;
    }

    @Test
    public void shouldHaveTextInIssue() {
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.goToRepository(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldHaveTextOfIssue(ISSUE_NAME);
    }
}