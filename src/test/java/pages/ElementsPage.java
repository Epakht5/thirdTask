package pages;

import Elements.Button;
import Elements.Input;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import properties.SingletonDriver;
import java.time.Duration;
import java.util.*;

public class ElementsPage{

    private String webTables = "//span[contains(text(),'Web Tables')]";
    private String add = "//button[@id='addNewRecordButton']";
    private String registrationForm = "//div[@role='dialog']";
    private String firstNameInput = "//input[@id='firstName']";
    private String lastNameInput = "//input[@id='lastName']";
    private String emailInput = "//input[@id='userEmail']";
    private String ageInput = "//input[@id='age']";
    private String salaryInput = "//input[@id='salary']";
    private String departmentInput = "//input[@id='department']";
    private String submitButton = "//button[@id='submit']";
    private String tableRows = "//div[@role='row']";
    private WebDriverWait wait;
    private String browserWindows = "//span[contains(text(),'Browser Windows')]";
    private String newTabButton = "//button[@id='tabButton']";
    private String ElementsCategory = "//*[contains(text(),'Elements')]/ancestor::div[@class='element-group']";
    private String links = "//*[@id='item-5']/child::span[contains(text(),'Links')]";
    private String linkHome = "//a[@id='simpleLink']";
    private String webTablesUniqueElement = "//div[@class='ReactTable -striped -highlight']";
    private String linksUniqueElement = "//h1[contains(text(),'Links')]";
    private Logger logger;

    public ElementsPage() {
        wait = new WebDriverWait(SingletonDriver.getInstance().getDriver(), Duration.ofSeconds(10));
    }

    public boolean findUniqueWebTablesElement() {
        return new BasePage().uniqueElement(webTablesUniqueElement);
    }

    public boolean findUniqueLinksElement(){
        return new BasePage().uniqueElement(linksUniqueElement);
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) SingletonDriver.getInstance().getDriver();
        js.executeScript("window.scrollBy(0,300)");
    }

    public void clickOnWebTables() {
        new Button(webTables).click();
    }

    public void clickAddButton() {
        new Button(add).click();
    }

    public boolean isRegistrationFormOpen() {
        try {
            WebElement form = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(registrationForm)));
            return form.isDisplayed();
        } catch (Exception e) {
            System.out.println("Registration form not found: " + e.getMessage());
            return false;
        }
    }

    public void fillRegistrationForm(String[] userData) {
        new Input(firstNameInput).sendKeys(userData[0]);
        new Input(lastNameInput).sendKeys(userData[1]);
        new Input(emailInput).sendKeys(userData[2]);
        new Input(ageInput).sendKeys(userData[3]);
        new Input(salaryInput).sendKeys(userData[4]);
        new Input(departmentInput).sendKeys(userData[5]);
    }

    public void clickOnSubmitButton() {
        new Button(submitButton).click();
    }

    public boolean isRegistrationFormClosed() {
        try {
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(registrationForm)));
            return true;
        } catch (Exception e) {
            System.out.println("Registration form did not close: " + e.getMessage());
            return false;
        }
    }

    public void deleteUserByName(String firstName) {
        String deleteUserButtonLocator = "//*[contains(text(),'" + firstName + "')]//following-sibling::div//span[@title='Delete']";
        new Button(deleteUserButtonLocator).click();
    }

    public boolean isUserInTable(String firstName, String lastName) {
        try {
            List<WebElement> rows = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(tableRows)));
            for (WebElement row : rows) {
                if (row.getText().contains(firstName) && row.getText().contains(lastName)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error checking user in table: " + e.getMessage());
            return false;
        }
    }

    public void clickOnBrowserWindows(){
        new Button(browserWindows).click();
    }

    public void clickOnNewTab(){
        new Button(newTabButton).click();
    }

    public void closeCurrentTab(){
        Set<String> handles = SingletonDriver.getInstance().getDriver().getWindowHandles();
        String currentHandle = SingletonDriver.getInstance().getDriver().getWindowHandle();

        for (String handle : handles) {
            if (!handle.equals(currentHandle)) {
                SingletonDriver.getInstance().getDriver().switchTo().window(handle);
                break;
            }
        }

        SingletonDriver.getInstance().getDriver().close();
        handles = SingletonDriver.getInstance().getDriver().getWindowHandles();
        if (!handles.isEmpty())
            SingletonDriver.getInstance().getDriver().switchTo().window(handles.iterator().next());
    }

    public void clickOnLinks(){
        new Button(ElementsCategory).click();
        new Button(links).click();
    }

    public void clickOnHomeLink(){
        new Button(linkHome).click();
    }

    public void switchOnPreviousTab(){
        Set<String> handles = SingletonDriver.getInstance().getDriver().getWindowHandles();
        Iterator<String> it = handles.iterator();
        String currentId = it.next();
        SingletonDriver.getInstance().getDriver().switchTo().window(currentId);
    }
}
