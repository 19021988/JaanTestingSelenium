package pages.skysports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class SkySportsSportsDropDownMenu extends SkySportsPage{

    @FindBy(css = "#site-nav-desktop-sports-more-nav li")
    private List<WebElement> sportDropDownMenu;

    public SkySportsSportsDropDownMenu(RemoteWebDriver driver) {
        super(driver);
    }

    public SkySportsFootballPage navToPage(String page) {
        for (WebElement element: sportDropDownMenu) {
            if (Objects.equals(page, element.getText())) {
                clickOn(element);

                return new SkySportsFootballPage(driver);
            }
        }
        return null;
    }
}
