package testCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.AlertFrameWindowPage;
import pages.MainPage;

public class FirstTestCase extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(FirstTestCase.class);
    private MainPage mainPage;
    private AlertFrameWindowPage alertFrameWindowPage;

    @Before
    public void initializePageObjects() {
        logger.info("Initializing page objects for FirstTestCase");
        mainPage = new MainPage();
        alertFrameWindowPage = new AlertFrameWindowPage();
    }

    @Test
    public void test() {
        logger.info("Starting FirstTestCase");

        mainPage.clickOnMainPage();
        Assert.assertTrue("Main page is not open", mainPage.findUniqueMainPageElement());

        mainPage.clickOnAlertsFrameWindows();
        alertFrameWindowPage.clickOnAlerts();
        Assert.assertTrue("Alerts page is not open", alertFrameWindowPage.findUniqueAlertsElement());

        alertFrameWindowPage.clickOnAlertButton();
        String alertText = alertFrameWindowPage.getAlertsText();
        logger.info("Alert text: {}", alertText);
        Assert.assertEquals("Texts are not equals", alertText, "You clicked a button");

        alertFrameWindowPage.acceptAlert();
        alertFrameWindowPage.waitForAlertToDisappear();

        alertFrameWindowPage.clickOnConfirmButton();
        String confirmAlertText = alertFrameWindowPage.getAlertsText();
        logger.info("Confirm alert text: {}", confirmAlertText);
        Assert.assertEquals("Texts are not equals", confirmAlertText, "Do you confirm action?");

        alertFrameWindowPage.acceptAlert();
        alertFrameWindowPage.waitForAlertToDisappear();
        Assert.assertTrue("Alert should disappear", alertFrameWindowPage.isAlertWindowDisappear());
        Assert.assertEquals("Texts are not equal", alertFrameWindowPage.getTextConfirmButton(), "You selected Ok");

        alertFrameWindowPage.clickOnPromtButton();
        String promptAlertText = alertFrameWindowPage.getAlertsText();
        logger.info("Prompt alert text: {}", promptAlertText);
        Assert.assertEquals("Prompt alert text should not be null", promptAlertText, "Please enter your name");

        alertFrameWindowPage.sendKeysToAlert();
        alertFrameWindowPage.acceptAlert();
        alertFrameWindowPage.waitForAlertToDisappear();
        Assert.assertTrue("Alert should disappear", alertFrameWindowPage.isAlertWindowDisappear());

        Assert.assertEquals("Texts are not equal",
            alertFrameWindowPage.getTextPromtButton(), "You entered " + alertFrameWindowPage.getRandomText());

        logger.info("FirstTestCase completed successfully");
    }
}
