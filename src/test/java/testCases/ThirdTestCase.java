package testCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pages.MainPage;
import pages.ElementsPage;
import utilities.TestDataReader;

public class ThirdTestCase extends BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(ThirdTestCase.class);
    private MainPage mainPage;
    private ElementsPage elementsPage;
    private TestDataReader testDataReader;

    @Before
    public void initializePageObjects() {
        logger.info("Initializing page objects for ThirdTestCase");
        mainPage = new MainPage();
        elementsPage = new ElementsPage();
        testDataReader = TestDataReader.readTestData();
    }

    @Test
    public void test() {
        logger.info("Starting ThirdTestCase - Web Tables Interaction");

        mainPage.clickOnMainPage();
        Assert.assertTrue("Unique element was not found on the main page", mainPage.findUniqueMainPageElement());

        mainPage.clickOnElements();

        elementsPage.clickOnWebTables();
        Assert.assertTrue("Page was not open", elementsPage.findUniqueWebTablesElement());

        elementsPage.clickAddButton();
        Assert.assertTrue("Registration Form was not appear", elementsPage.isRegistrationFormOpen());

        String[] userData = testDataReader.getWebTablesTestData(0);

        elementsPage.fillRegistrationForm(userData);
        elementsPage.clickOnSubmitButton();
        Assert.assertTrue("Registration form was not close", elementsPage.isRegistrationFormClosed());

        elementsPage.scrollDown();

        elementsPage.deleteUserByName(userData[0]);
        Assert.assertTrue("User was not deleted from the table", !elementsPage.isUserInTable(userData[0], userData[1]));

        logger.info("ThirdTestCase completed successfully");
    }
}
