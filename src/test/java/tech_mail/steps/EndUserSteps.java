package tech_mail.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import tech_mail.pages.GoFrontPage;
import tech_mail.pages.SearchResultPage;

import static org.junit.Assert.assertTrue;

public class EndUserSteps extends ScenarioSteps {

    GoFrontPage goFrontPage;
    SearchResultPage searchResultPage;

    @Step
    public void enters(String keyword) {
        goFrontPage.inputSearchCondition(keyword);
    }

    @Step
    public void starts_search() {
        searchResultPage = goFrontPage.submitSearchRequest();
    }

    @Step
    public void should_see_mixin() {
        assertTrue(searchResultPage.getMixin().isDisplayed());
    }

    @Step
    public void is_the_home_page() {
        goFrontPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }
}