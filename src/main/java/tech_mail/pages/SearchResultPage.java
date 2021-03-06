package tech_mail.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://go.mail.ru/search?q=1")
public class SearchResultPage extends PageObject {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(className = "sunrise__block")
    private WebElement sunRiseMixin;

    @FindBy(className = "sunrise__rise")
    private WebElement riseTime;

    @FindBy(className = "sunrise__set")
    private WebElement setTime;

    @FindBy(className = "sunrise__transit")
    private WebElement dayDuration;

    @FindBy(className = "sunrise__title")
    private WebElement mixinTitle;

    @FindBy(id = "calSelect")
    private WebElement calendarSelector;

    public WebElement getCalendarSelector() {
        return calendarSelector;
    }

    public WebElement getMixin() {
        return sunRiseMixin;
    }

    public String getSunRaiseTime() {
        return riseTime.getText();
    }

    public String getSunSetTime() {
        return setTime.getText();
    }

    public String getDayDurationTime() {
        return dayDuration.getText();
    }

    public String getMixinTitle() {
        return mixinTitle.getText();
    }

}
