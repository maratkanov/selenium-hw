package tech_mail.stories.positive;

import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.runners.ThucydidesRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import tech_mail.requirements.Application;
import tech_mail.steps.EndUserSteps;

@Story(Application.Search.SearchSunRaiseCorrectInputTest.class)
@RunWith(ThucydidesRunner.class)
public class SearchSunRaiseCorrectInputTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    public void search_for_sun_raise_in_moscow() {
        endUser.is_the_home_page();
        endUser.looks_for("москва восход 12 марта 2014 года");
        endUser.should_see_mixin();
        endUser.should_see_result_for_specific_location("Москва");
        endUser.should_see_times("7:53", "19:26", "11:33");
        endUser.should_see_specific_date("12 марта 2014, среда");
    }

    @Test
    public void search_for_sun_raise_in_hometown() {
        endUser.is_the_home_page();
        endUser.looks_for("Крымск восход Солнца");
        endUser.should_see_mixin();
        endUser.should_see_result_for_specific_location("Крымск");
        endUser.should_see_times("7:47", "19:30", "11:43");
        endUser.should_see_specific_date("12 марта 2014, среда");
    }

}