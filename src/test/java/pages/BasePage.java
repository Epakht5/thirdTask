package pages;

import Elements.BaseElement;

public class BasePage {

    public BasePage() {
    }

    public boolean uniqueElement(String xpath){
        BaseElement baseElement = new BaseElement();
        return baseElement.isLocated(xpath).isDisplayed();
    }
}
