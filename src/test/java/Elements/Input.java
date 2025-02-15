package Elements;

import org.openqa.selenium.WebElement;

public class Input extends BaseElement {

    private String xpath;

    public Input(String locator) {
        this.xpath = locator;
    }

    public void sendKeys(String text){
        WebElement element = getElement(xpath);
        element.sendKeys(text);
    }
}
