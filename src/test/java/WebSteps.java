import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;

public class WebSteps {

    @Step ("Открываем главную страницу")
    public void openMainPage (String link) {
        open(link);
    }

    @Step ("Ищем и переходим в репозиторий")
    public void searchForRepository(String repo) {
        $(".search-input").click();
        $("#query-builder-test").sendKeys(repo);
        $("#query-builder-test").pressEnter();
        $(linkText(repo)).click();
    }

    @Step ("Кликаем на таб 'Задачи'")
   public void  clickOnIssues() {
        $("#issues-tab").click();
    }

    @Step ("Проверяем название задачи")
    public void verifyIssueName (String issueName) {
        $(withText(issueName)).should(Condition.exist);

    }

}
