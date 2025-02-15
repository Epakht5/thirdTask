package properties;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.ConfigReader;

public class SingletonDriver {

    private static SingletonDriver instance = null;
    private static WebDriver driver;

    private SingletonDriver() {
        String browserType = ConfigReader.configReader().getBrowserType();
        if ("chrome".equalsIgnoreCase(browserType)) {
            initializeChromeDriver();
        } else if ("firefox".equalsIgnoreCase(browserType)) {
            initializeFirefoxDriver();
        } else {
            throw new IllegalArgumentException("Unsupported browser type: " + browserType);
        }
    }

    private void initializeChromeDriver() {
        ChromeOptions options = new ChromeOptions();
        String browserMode = ConfigReader.configReader().getBrowserMode();
        options.addArguments(browserMode);
        options.addArguments("--start-maximized");
        options.addArguments("--lang=" + ConfigReader.configReader().getLanguage());
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
    }

    private void initializeFirefoxDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--start-maximized");
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new FirefoxDriver(options);
    }

    public static SingletonDriver getInstance() {
        if (instance == null) {
            instance = new SingletonDriver();
        }
        return instance;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
            instance = null;
        }
    }
}
