package tech_mail.stories.negative;

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

@Story(Application.Search.SearchSunRaiseTimeSpecifiedTest.class)
@RunWith(ThucydidesRunner.class)
public class SearchSunRaiseTimeSpecifiedTest {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages
    public Pages pages;

    @Steps
    public EndUserSteps endUser;

    @Test
    public void search_for_sun_raise_in_moscow_some_day() {
        endUser.is_the_home_page();
        endUser.looks_for("vjcrdf восход 12 марта");
        endUser.should_see_mixin();
        endUser.should_see_times("7:53", "19:26", "11:33");
    }

}
