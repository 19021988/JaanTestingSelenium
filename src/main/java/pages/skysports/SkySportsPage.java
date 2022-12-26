package pages.skysports;

import pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class SkySportsPage extends AbstractPage {

    @FindBy(css = "[class=site-nav-desktop__body] li")
    private List<WebElement> navBar;

    @FindBy(css = "img[alt=\"Sky Sports\"]")
    private WebElement skySportsLogo;

    public SkySportsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public boolean isSkySportsLogoDisplayed() {
        waitUntilElementIsLoaded(skySportsLogo);

        return skySportsLogo.isDisplayed();
    }

    public SkySportsSportsDropDownMenu navBarMenu(String str) {
        for (WebElement element: navBar) {
            if (Objects.equals(str, element.getText())) {
                clickOn(element);

                return new SkySportsSportsDropDownMenu(driver);
            }
        }
        return null;
    }

    public SkySportsPage acceptSkySportsCookies() {
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe[id=sp_message_iframe_734511]")));
        clickOn(driver.findElement(By.cssSelector("button[title=\"Accept all\"]")));

        return this;
    }
}
