package tech_mail.steps;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.junit.Assert;
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

    @Step
    public void should_see_times(String sunRiseTime, String sunSetTime, String dayDurationTime) {
        Assert.assertEquals("некорректное значение времени восхода", sunRiseTime, searchResultPage.getSunRaiseTime());
        Assert.assertEquals("некорректное значение времени заката", sunSetTime, searchResultPage.getSunSetTime());
        Assert.assertEquals("некорректное значение продолжительности дня", dayDurationTime, searchResultPage.getDayDurationTime());
    }

    @Step
    public void should_see_result_for_specific_location(String location) {
        Assert.assertTrue("Некорректный город", searchResultPage.getMixinTitle().toLowerCase().contains(location.toLowerCase()));
    }

    @Step
    public void should_see_specific_date(String date) {
        Assert.assertTrue("Неверная дата", searchResultPage.getCalendarSelector().getText().contains(date));
    }
}