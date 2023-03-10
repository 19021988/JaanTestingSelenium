package tests;

import baseTest.AbstractSeleniumTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
import org.openqa.selenium.JavascriptExecutor;
import pages.google.GooglePage;
import pages.skysports.SkySportsFootballNewsPage;
import pages.skysports.SkySportsPage;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SkySportsTestCase extends AbstractSeleniumTest {

    private final static String SEARCH_TEXT = "skysports";
    private final static String SPORTS = "Sports";
    private final static String FOOTBALL = "Football";
    private final static String NEWS = "News";
    private GooglePage googlePage;
    private SkySportsPage skySportsPage;
    @Override
    protected void doSetup() {
        super.doSetup();
        googlePage = new GooglePage(driver);
    }

    @Test
    @Description("Google opens - accept cookies")
    @Order(1)
    void googlePageOpensSuccessfully() {
        googlePage
                .acceptCookies();

        Assertions.assertTrue(googlePage.isGoogleLogoDisplayed());
    }

    @Test
    @Description("Google search and navigate through result link to page and accept cookies")
    @Order(2)
    void skySportsPageOpenSuccessfully() {
        navigateToSkySportsPage();

        Assertions.assertTrue(skySportsPage.isSkySportsLogoDisplayed());
    }

    @Test
    @Description("Navigates 2 skySports football news page and gets 3 latest news headlines")
    @Order(3)
    void skySportsFootballNewsPageOpenSuccessfully() {
        SkySportsFootballNewsPage newsPage =
        navigateToSkySportsPage()
                .navBarMenu(SPORTS)
                        .navToPage(FOOTBALL)
                        .navToTab(NEWS);

        for (int i = 0; i < 3; i++) {
            System.out.println(newsPage.latestNews.get(i).getText());
        }

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");

        Assertions.assertTrue(newsPage.footballNewsHeaderText());
        Assertions.assertTrue(newsPage.latestNews.size() > 0);
    }

    private SkySportsPage navigateToSkySportsPage() {
        skySportsPage =
                googlePage
                        .acceptCookies()
                        .searchGoogle(SEARCH_TEXT)
                        .clickTheCorrectResult(SEARCH_TEXT)
                        .acceptSkySportsCookies();

        return this.skySportsPage;
    }
}
