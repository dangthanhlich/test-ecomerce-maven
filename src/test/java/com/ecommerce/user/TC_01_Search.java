package com.ecommerce.user;

import com.aventstack.extentreports.Status;
import commons.BaseTest;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pageObjects.eComerce.user.HomePageObject;
import pageObjects.eComerce.user.PageGeneratorManager;
import reportConfig.ExtentTestManager;

import java.lang.reflect.Method;
import java.util.Random;

public class TC_01_Search extends BaseTest {
    @Parameters({ "browser", "urlUser"})
    @BeforeClass
    public void beforeClass(String browserName, String urlUser) {
        this.urlUser = urlUser;

        driver = getBrowserDriver(browserName, urlUser);
        homePageObject = PageGeneratorManager.getHomePage(driver);

        nameProductSearch = "iphone 11";

    }

    @Test
    public void New_Customer_01_login(Method method) {
        ExtentTestManager.startTest(method.getName(), "Open system");
        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 01: Enter to Search textbox with value is '" + nameProductSearch + "'");
        homePageObject.inputToSearchTextbox(nameProductSearch);

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 02: Click to buttun search ");
        homePageObject.ClickToButtonSearch();

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 03: Verify  'Lenovo IdeaCentre 600 All-in-One PC' message is displayed");
        verifyTrue(homePageObject.isProductName("Apple iPhone 11, 64GB, Red - Unlocked (Renewed Premium)"));

        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 04: Click to dropdown menu notebooks");
        homePageObject.selectItemInProductSortDropdown("Price: Low to High");
        homePageObject.sleepInSecond(2);


        ExtentTestManager.getTest().log(Status.INFO, "Search - Step 05:verify Price: Low to High is diplay");
        verifyTrue(homePageObject.isProductPriceSortByAscendig());

    }



    @AfterClass
    public void afterClass() {
        driver.quit();
    }


    private WebDriver driver;
    HomePageObject homePageObject;
    String nameProductSearch;
    String urlUser;
}
