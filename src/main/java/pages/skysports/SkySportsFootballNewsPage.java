package pages.skysports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SkySportsFootballNewsPage extends SkySportsFootballPage{

    @FindBy(css = "h3[class=\"page-filters__title\"]")
    private WebElement footballNewsHeader;

    @FindBy(css = "#widgetLite-10 [class*=\"news-list__item\"] h4 a")
    private List<WebElement> latestNews ;

    public SkySportsFootballNewsPage(RemoteWebDriver driver) {
        super(driver);
    }

    public Boolean footballNewsHeaderText() {
        waitUntilElementIsLoaded(footballNewsHeader);

        return footballNewsHeader.isDisplayed();
    }
}
