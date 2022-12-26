package pages.google;

import pages.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

public class GooglePage extends AbstractPage {

    @FindBy(css = "#hplogo")
    private WebElement googleLogo;

    @FindBy(css = "#L2AGLb")
    private WebElement acceptCookiesButton;

    @FindBy(css = "[title=Search]")
    private WebElement searchInputField;

    public GooglePage(RemoteWebDriver driver) {
        super(driver);
    }

    public Boolean isGoogleLogoDisplayed() {
        return googleLogo.isDisplayed();
    }

    public GooglePage acceptCookies() {
        clickOn(acceptCookiesButton);

        return this;
    }

    public GoogleSearchResultPage searchGoogle(String string) {
        waitUntilElementIsLoaded(searchInputField);
        searchInputField.clear();
        searchInputField.sendKeys(string);
        searchInputField.submit();

        return new GoogleSearchResultPage(driver);
    }
}
