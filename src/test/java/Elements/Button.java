package Elements;
import org.openqa.selenium.WebElement;

public class Button extends BaseElement {

    private final String xpath;

    public Button(String locator) {
        this.xpath = locator;
    }

    public void click() {
        WebElement element = isVisible(xpath);
        element.click();
    }
}
