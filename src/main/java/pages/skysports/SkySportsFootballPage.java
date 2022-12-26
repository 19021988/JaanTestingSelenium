package pages.skysports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class SkySportsFootballPage extends SkySportsPage{

    @FindBy(css = "span[class=\"swap-text__target\"]")
    private WebElement footballPageHeader;

    @FindBy(css = "[class=\"page-nav__frame\"] li")
    private List<WebElement> footballPageNavBar;

    public SkySportsFootballPage(RemoteWebDriver driver) {
        super(driver);
    }

    public SkySportsFootballNewsPage navToTab(String page) {
        for (WebElement element: footballPageNavBar) {
            if (Objects.equals(page, element.getText())) {
                clickOn(element);

                return new SkySportsFootballNewsPage(driver);
            }
        }
        return null;
    }
}
