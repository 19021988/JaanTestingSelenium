package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {

    protected RemoteWebDriver driver;

    protected AbstractPage(RemoteWebDriver driver){
        this.driver = driver;

        initElements();
    }

    private void initElements() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
    }

    protected AbstractPage microSleep(Integer milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (Throwable e) {
            String error = String.format("Unable to put thread to sleep (requested %d milliseconds).", milliseconds);

            throw new RuntimeException(error, e);
        }

        return this;
    }
    protected void waitUntilElementIsLoaded(WebElement element) {
        while (!element.isEnabled()) {
            microSleep(100);
        }
    }

    protected void clickOn(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(element)).click();
    }
}
