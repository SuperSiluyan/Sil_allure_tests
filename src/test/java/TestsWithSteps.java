import org.junit.jupiter.api.Test;

public class TestsWithSteps {

    private static final String URL = "https://github.com";
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE_NAME = "Issue_created_to_test_allure_reports";


    @Test
    public void webTestWithSteps() {

        WebSteps steps = new WebSteps();

        steps.openMainPage(URL);
        steps.searchForRepository(REPOSITORY);
        steps.clickOnIssues();
        steps.verifyIssueName(ISSUE_NAME);
    }
}
