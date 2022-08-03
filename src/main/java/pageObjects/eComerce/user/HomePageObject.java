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

    public boolean isProductPriceSortByAscendig() {
        ArrayList<Float> productUIList = new ArrayList<Float>();

        List<WebElement> productPriceText = getListWebElement(driver, HomePageUI.PRODUCT_PRICE_TEXT);

        for (WebElement productPrice : productPriceText) {

            productUIList.add(Float.parseFloat(productPrice.getText().replace("$", ",").replace(",", "")));
            System.out.print("Product name  on UI:" + productPrice.getText() + "\n");
        }

        ArrayList<Float> productSortList = new ArrayList<Float>();
        for (Float product : productUIList) {
            productSortList.add(product);
        }

        Collections.sort(productSortList);
        for (Float productName : productSortList) {
            System.out.print("Product name after sort" + productName + "\n");
        }

        return productSortList.equals(productUIList);
    }
}
