package testCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AlertFrameWindowPage;
import pages.MainPage;


public class SecondTestCase extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(SecondTestCase.class);
    private MainPage mainPage;
    private AlertFrameWindowPage alertFrameWindowPage;

    @Before
    public void initializePageObjects() {
        logger.info("Initializing page objects for SecondTestCase");
        mainPage = new MainPage();
        alertFrameWindowPage = new AlertFrameWindowPage();
    }

    @Test
    public void test(){
        logger.info("Starting SecondTestCase");

        mainPage.clickOnMainPage();
        Assert.assertTrue("Main page is not open", mainPage.findUniqueMainPageElement());

        mainPage.clickOnAlertsFrameWindows();

        alertFrameWindowPage.scrollDown();
        alertFrameWindowPage.clickOnNestedFrames();
        Assert.assertTrue("Nested page was not open", alertFrameWindowPage.findUniqueNestedElement());
        Assert.assertEquals("Elements are not equal", alertFrameWindowPage.getTextParentFrame(), "Parent frame");
        Assert.assertEquals("Elements are not equal", alertFrameWindowPage.getTextChildFrame(), "Child Iframe");

        alertFrameWindowPage.clickOnFrameButton();
        Assert.assertEquals("Elements are not equal", alertFrameWindowPage.getHighFrame(), alertFrameWindowPage.getLowerFrame());

        logger.info("SecondTestCase completed successfully");
    }
}
