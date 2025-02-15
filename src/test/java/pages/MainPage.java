package pages;

import Elements.Button;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainPage{

    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);
    private String uniqueElement = "//div[@class='category-cards']";
    private String mainPageLogo = "//header/a";
    private String alertsFrameWindows = "//*[contains(text(),'Alerts, Frame & Windows')]/ancestor::div[@class='card mt-4 top-card']";
    private String elementsFrame = "//*[contains(text(),'Elements')]/ancestor::div[@class='card mt-4 top-card']";

    public MainPage() {
    }

    public boolean findUniqueMainPageElement() {
        return new BasePage().uniqueElement(uniqueElement);
    }

    public void clickOnMainPage() {
        logger.debug("Clicking on main page logo with xpath: {}", mainPageLogo);
        new Button(mainPageLogo).click();
    }

    public void clickOnAlertsFrameWindows() {
        logger.debug("Clicking on Alerts, Frame & Windows with xpath: {}", alertsFrameWindows);
        new Button(alertsFrameWindows).click();
    }

    public void clickOnElements() {
        logger.debug("Clicking on Elements with xpath: {}", elementsFrame);
        new Button(elementsFrame).click();
    }
}
