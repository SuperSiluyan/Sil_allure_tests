import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;



public class LambdaTest {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "Issue_created_to_test_allure_reports";

    @Test
    public void withLambdaTest() {

        SelenideLogger.addListener("allure", new AllureSelenide());

        step("Открываем главную страницу" + " " + URL, () -> {
            open(URL);
        });
        step("Ищем репозиторий"  + " " + REPOSITORY, () -> {
            $(".search-input").click();
            $("#query-builder-test").sendKeys(REPOSITORY);
            $("#query-builder-test").pressEnter();
        });
        step("Наименование задачи соответствует"  + " " + ISSUE_NAME, () -> {
            $(linkText(REPOSITORY)).click();
            $("#issues-tab").click();
            $(withText(ISSUE_NAME)).should(Condition.exist);
        });
            }
}
