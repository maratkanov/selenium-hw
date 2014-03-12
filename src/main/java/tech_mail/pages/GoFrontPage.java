package tech_mail.pages;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.findby.FindBy;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@DefaultUrl("http://go.mail.ru/")
public class GoFrontPage extends PageObject {

    public GoFrontPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "q")
    private WebElement searchForm;

    public void inputSearchCondition(String text) {
        searchForm.sendKeys(text);
    }

    public SearchResultPage submitSearchRequest() {
        searchForm.submit();
        return new SearchResultPage(getDriver());
    }
}
