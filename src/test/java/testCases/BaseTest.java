package testCases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.SingletonDriver;
import utilities.TestDataReader;

abstract class BaseTest {

    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    protected WebDriver driver;

    @Before
    public void setUp(){
        logger.info("Setting up WebDriver");
        driver = SingletonDriver.getInstance().getDriver();
        driver.get(TestDataReader.readTestData().getUrlMainPage());
        logger.debug("WebDriver initialized and navigated to main page");
    }

    @After
    public void tearDown(){
        logger.info("Closing WebDriver");
        SingletonDriver.quitDriver();
        logger.debug("WebDriver successfully closed");
    }
}
