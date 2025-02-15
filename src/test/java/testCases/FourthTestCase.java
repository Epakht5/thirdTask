package testCases;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AlertFrameWindowPage;
import pages.ElementsPage;
import pages.MainPage;

public class FourthTestCase extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(FourthTestCase.class);
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private AlertFrameWindowPage alertFrameWindowPage;

    @Before
    public void initializePageObjects() {
        logger.info("Initializing page objects for FourthTestCase");
        mainPage = new MainPage();
        elementsPage = new ElementsPage();
        alertFrameWindowPage = new AlertFrameWindowPage();
    }

    @Test
    public void test() {
        logger.info("Starting FourthTestCase");

        mainPage.clickOnMainPage();
        Assert.assertTrue("Unique element was not found on the main page", mainPage.findUniqueMainPageElement());

        mainPage.clickOnAlertsFrameWindows();

        elementsPage.clickOnBrowserWindows();
        Assert.assertTrue("Browser window page was not open", alertFrameWindowPage.findUniqueBrowserWindowsElement());

        elementsPage.clickOnNewTab();

        elementsPage.closeCurrentTab();
        Assert.assertTrue("Current tab was not close", alertFrameWindowPage.findUniqueBrowserWindowsElement());

        elementsPage.clickOnLinks();
        Assert.assertTrue("Links page was not open", elementsPage.findUniqueLinksElement());

        elementsPage.clickOnHomeLink();

        elementsPage.switchOnPreviousTab();
        Assert.assertTrue("Links page was not open", elementsPage.findUniqueLinksElement());

        logger.info("FourthTestCase completed successfully");
    }
}
