package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.BrowseInventoryPage;
import com.ITAssetInventory.pageObjects.HomePage;
import com.ITAssetInventory.pageObjects.RegisterNewAssetsForUserPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;

//IT Asset Inventory-All Items in IT Inventory Section - Heading

public class ITAI_AI_TC_0001 extends Base{
    @Test(priority = 0)
    public void navigateToBrowseInventorySection() throws IOException {
        login();
        logger.info("Login to the Home Page");
        HomePage home=new HomePage(driver);
        home.clickIctInventoryManager();
        logger.info("Select ICT Inventory Manager from the dropdown");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement browseInventoryOption = wait.until(ExpectedConditions.elementToBeClickable(home.getBrowseInventoryOption()));
        browseInventoryOption.click();
        logger.info("Select Browse Inventory from the dropdown");
    }

    @Test(priority = 1) //Heading should be "All Items in IT Inventory" (word should be start with a capital letter)
    public void checkAllItemsInInventoryHeadingText()throws IOException{
//        logger.info("Executing checkAllItemsInInventoryHeadingText test");
        BrowseInventoryPage browseInventoryPage=new BrowseInventoryPage(driver);
        WebElement headingElement = browseInventoryPage.getAllItemsInInventoryHeading();
        String actualHeading = browseInventoryPage.getAllItemsInInventoryHeadingText();
        if (actualHeading.equals("All Items in IT Inventory"))
        {
            Assert.assertTrue(true);
            logger.info("All Items In IT Inventory Heading text is correct");
        }
        else{
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",headingElement);
            captureScreen(driver,"checkAllItemsInInventoryHeadingText");
            logger.info("All Items In IT Inventory Heading text mismatched:"+actualHeading);
            Assert.fail();
        }
//        logger.info("checkAllItemsInInventoryHeadingText test completed");
    }

    @Test(priority = 2)//Heading font color should be white
    public void checkAllItemsInInventoryHeadingColor()throws IOException{
//        logger.info("Executing checkAllItemsInInventoryHeadingColor test");
        BrowseInventoryPage browseInventoryPage=new BrowseInventoryPage(driver);
        String actualColor = browseInventoryPage.getAllItemsInInventoryHeadingColor();
        if(actualColor.equals("rgba(255, 255, 255, 1)"))
        {
            Assert.assertTrue(true);
            logger.info("All Items In Inventory Heading text color is white");
        }
        else{
            captureScreen(driver,"checkHeadingColor");
            logger.info("All Items In Inventory Heading font color is not white."+actualColor);
            Assert.fail();
        }
//        logger.info("checkAllItemsInInventoryHeadingColor test completed");
    }


}
