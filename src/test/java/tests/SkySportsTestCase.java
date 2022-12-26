package tests;

import baseTest.AbstractSeleniumTest;
import io.qameta.allure.Description;
import org.junit.jupiter.api.*;
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
    @Description("Navigates 2 skySports football news page and looks for 3 latest news")
    @Order(3)
    void skySportsFootballNewsPageOpenSuccessfully() {
        SkySportsFootballNewsPage newsPage =
        navigateToSkySportsPage()
                .navBarMenu(SPORTS)
                        .navToPage(FOOTBALL)
                        .navToTab(NEWS);

        Assertions.assertTrue(newsPage.footballNewsHeaderText());
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
