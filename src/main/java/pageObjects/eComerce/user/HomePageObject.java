package pageObjects.eComerce.user;

import commons.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pageUIs.eComerce.user.HomePageUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageObject extends BasePage {
    private WebDriver driver;

    public HomePageObject(WebDriver driver) {
        this.driver = driver;
    }


    public void inputToSearchTextbox(String nameProductSearch) {
        waitForElementVisible(driver, HomePageUI.SEARCH_INPUT);
        sendkeyToElement(driver,HomePageUI.SEARCH_INPUT,nameProductSearch);
    }

    public void ClickToButtonSearch() {
        waitForElementClickable(driver, HomePageUI.SEARCH_BUTTON);
        clickToElement(driver, HomePageUI.SEARCH_BUTTON);
    }

    public boolean isProductName(String productName) {
        waitForElementVisible(driver, HomePageUI.PRODUCT_NAME, productName);
        return isElementDisplayed(driver, HomePageUI.PRODUCT_NAME, productName);
    }

    public void selectItemInProductSortDropdown(String textItem) {
        waitForElementClickable(driver, HomePageUI.FEATURED_DROPDOWN);
        clickToElement(driver, HomePageUI.FEATURED_DROPDOWN);

        waitForElementClickable(driver, HomePageUI.FEATURED_DROPDOWN_ITEM);
        clickToElement(driver, HomePageUI.FEATURED_DROPDOWN_ITEM, textItem);
    }

}
