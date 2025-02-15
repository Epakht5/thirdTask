package Elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import properties.SingletonDriver;
import utilities.ConfigReader;

import java.time.Duration;

public class BaseElement {
    private final int timeOutInSeconds = ConfigReader.configReader().getExplicitWait();

    public BaseElement(){
    }

    public WebElement isVisible(String xpath){
         return new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                 .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
    }

    public WebElement isLocated(String xpath){
        return new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public void waitForAlertToDisappear() {
        new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(timeOutInSeconds))
                .until(ExpectedConditions.not(ExpectedConditions.alertIsPresent()));
    }

    public WebElement getElement(String xpath) {
        return SingletonDriver.getInstance().getDriver().findElement(By.xpath(xpath));
    }
}
