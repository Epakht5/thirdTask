package pages;

import Elements.BaseElement;
import Elements.Button;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import properties.SingletonDriver;
import java.time.Duration;
import org.apache.commons.lang3.RandomStringUtils;

public class AlertFrameWindowPage {

    private static final Logger logger = LoggerFactory.getLogger(AlertFrameWindowPage.class);
    private String alertsUniqueElement = "//span[contains(text(),'Click Button to see alert ')]";
    private String nestedUniqueElement = "//h1[contains(text(),'Nested Frames')]";
    private String browserWindowsElement = "//h1[contains(text(),'Browser Windows')]";
    private String alerts = "//span[contains(text(),'Alerts')]";
    private String alertButton = "//button[@id='alertButton']";
    private String confirmButton = "//button[@id='confirmButton']";
    private String promtButton = "//button[@id='promtButton']";
    private String confirmText = "//span[@id='confirmResult']";
    private String promtText = "//span[@id='promptResult']";
    private String nested = "//span[contains(text(),'Nested')]";
    private By parentFrame = By.xpath("//iframe[@id='frame1']");
    private By childFrame = By.xpath("//iframe");  // Generic iframe locator
    private String frames = "//span[contains(text(),'Frames')]";
    private By upperFrame = By.xpath("//iframe[@id='frame1']");
    private By lowerFrame = By.xpath("//iframe[@id='frame2']");
    private WebDriverWait wait;
    private String randomAlertText;

    public AlertFrameWindowPage(){
        wait = new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(10));
    }

    public boolean findUniqueAlertsElement(){
        logger.debug("Finding unique alerts element with xpath: {}", alertsUniqueElement);
        return new BasePage().uniqueElement(alertsUniqueElement);
    }

    public boolean findUniqueNestedElement(){
        logger.debug("Finding unique nested element with xpath: {}", nestedUniqueElement);
        return new BasePage().uniqueElement(nestedUniqueElement);
    }

    public boolean findUniqueBrowserWindowsElement(){
        logger.debug("Finding unique browser windows element with xpath: {}", browserWindowsElement);
        return new BasePage().uniqueElement(browserWindowsElement);
    }

    public void scrollDown() {
        logger.debug("Scrolling down the page slightly");
        JavascriptExecutor js = (JavascriptExecutor) SingletonDriver.getInstance().getDriver();
        js.executeScript("window.scrollBy(0,300)");
    }

    public void clickOnAlerts(){
        logger.debug("Clicking on Alerts with xpath: {}", alerts);
        new Button(alerts).click();
    }

    public void clickOnAlertButton(){
        logger.debug("Clicking on Alert Button with xpath: {}", alertButton);
        new Button(alertButton).click();
    }

    public void clickOnConfirmButton() {
        logger.debug("Clicking on Confirm Button with xpath: {}", confirmButton);
        new Button(confirmButton).click();
    }

    public void acceptAlert() {
        logger.debug("Accepting current alert");
        SingletonDriver.getInstance().getDriver().switchTo().alert().accept();
    }

    public void waitForAlertToDisappear() {
        logger.debug("Waiting for alert to disappear");
        new BaseElement().waitForAlertToDisappear();
    }

    public void clickOnPromtButton(){
        logger.debug("Clicking on Prompt Button with xpath: {}", promtButton);
        new Button(promtButton).click();
    }

    public String getRandomText(){
        logger.debug("Create random text for alert");
        if (randomAlertText == null) {
            randomAlertText = RandomStringUtils.randomAlphanumeric(15);
        }
        return randomAlertText;
    }

    public void sendKeysToAlert() {
        logger.debug("Sending keys to alert");
        SingletonDriver.getInstance().getDriver().switchTo().alert()
                .sendKeys(getRandomText());
    }

    public boolean isAlertWindowDisappear(){
        logger.debug("Checking if alert window has disappeared");
        try {
            SingletonDriver.getInstance().getDriver().switchTo().alert();
            return false;
        } catch (NoAlertPresentException e) {
            return true;
        }
    }

    public String getTextConfirmButton(){
        logger.debug("Getting text from Confirm Button with xpath: {}", confirmText);
        return new BaseElement().isLocated(confirmText).getText();
    }

    public String getAlertsText(){
        logger.debug("Getting text from current alert");
        return SingletonDriver.getInstance().getDriver().switchTo().alert().getText();
    }

    public String getTextPromtButton(){
        logger.debug("Getting text from Promt Button with xpath: {}", promtButton);
        return new BaseElement().isLocated(promtText).getText();
    }

    public void clickOnNestedFrames(){
        logger.debug("Clicking on Nested with xpath: {}", nested);
        new Button(nested).click();
    }

    public String getTextParentFrame() {
        logger.debug("Getting text in parent frame");
        WebElement parentFrame = wait.until(ExpectedConditions.presenceOfElementLocated(this.parentFrame));
        SingletonDriver.getInstance().getDriver().switchTo().frame(parentFrame);
        String text = SingletonDriver.getInstance().getDriver().findElement(By.tagName("body")).getText();
        SingletonDriver.getInstance().getDriver().switchTo().defaultContent();
        return text;
    }

    public String getTextChildFrame() {
        logger.debug("Getting text in child frame");
        WebElement parentFrame = wait.until(ExpectedConditions.presenceOfElementLocated(this.parentFrame));
        SingletonDriver.getInstance().getDriver().switchTo().frame(parentFrame);
        WebElement childFrame = wait.until(ExpectedConditions.presenceOfElementLocated(this.childFrame));
        SingletonDriver.getInstance().getDriver().switchTo().frame(childFrame);
        String text = SingletonDriver.getInstance().getDriver().findElement(By.tagName("body")).getText();
        SingletonDriver.getInstance().getDriver().switchTo().defaultContent();
        return text;
    }

    public void clickOnFrameButton(){
        logger.debug("Clicking on Frame Button with xpath: {}", frames);
        new Button(frames).click();
    }

    public String getHighFrame(){
        logger.debug("Getting text in Higher frame");
        WebElement upperFrame = wait.until(ExpectedConditions.presenceOfElementLocated(this.upperFrame));
        SingletonDriver.getInstance().getDriver().switchTo().frame(upperFrame);
        String text = SingletonDriver.getInstance().getDriver().findElement(By.id("sampleHeading")).getText();
        SingletonDriver.getInstance().getDriver().switchTo().defaultContent();
        return text;
    }

    public String getLowerFrame(){
        logger.debug("Getting text in Lower frame");
        WebElement lowerFrame = wait.until(ExpectedConditions.presenceOfElementLocated(this.lowerFrame));
        SingletonDriver.getInstance().getDriver().switchTo().frame(lowerFrame);
        String text = SingletonDriver.getInstance().getDriver().findElement(By.id("sampleHeading")).getText();
        SingletonDriver.getInstance().getDriver().switchTo().defaultContent();
        return text;
    }
}
