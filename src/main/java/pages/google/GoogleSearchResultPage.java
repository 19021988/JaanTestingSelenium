package pages.google;

import pages.skysports.SkySportsPage;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

public class GoogleSearchResultPage extends GooglePage{

    @FindBy(css = "#search #rso a [role=text]")
    private List<WebElement> results;

    public GoogleSearchResultPage(RemoteWebDriver driver) {
        super(driver);
    }

    public SkySportsPage clickTheCorrectResult(String str) {
        for (WebElement element : results) {
            if (Objects.equals("https://www."+str+".com", StringUtils.substringBefore(element.getText(), " "))) {
                clickOn(element);
                return new SkySportsPage(driver);
            }
        }
        return null;
    }
}
