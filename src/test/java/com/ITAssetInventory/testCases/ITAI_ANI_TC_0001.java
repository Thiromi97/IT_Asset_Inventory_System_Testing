package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.HomePage;
import com.ITAssetInventory.pageObjects.RegisterNewAssetsForUserPage;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
//IT Asset Inventory-Add New Items Section - Heading
public class ITAI_ANI_TC_0001 extends Base{

    @Test(priority = 0)//Navigate to the Add New Items Section
    public void navigateToRegisterNewAssetsForUserSection() throws IOException {
        login();
        logger.info("Login to the Home Page");
        HomePage home=new HomePage(driver);
        home.clickIctInventoryManager();
        logger.info("Select ICT Inventory Manager from the dropdown");
        home.clickRegisterNewAssetsForUserOption();
        logger.info("Select Register New Assets for User from the dropdown");
    }

    @Test(priority = 1)//Heading should be "Add New Items" (word should be start with a capital letter)
    public void checkAddNewItemsHeadingText()throws IOException{
        RegisterNewAssetsForUserPage registerPage=new RegisterNewAssetsForUserPage(driver);
        WebElement headingElement = registerPage.getNewItemHeading();
        String actualHeading = registerPage.getNewItemHeadingText();
        if (actualHeading.equals("Add New Items"))
        {
            Assert.assertTrue(true);
            logger.info("Add New Items Heading text is correct");
        }
        else{
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();",headingElement);
            captureScreen(driver,"checkAddNewItemsHeadingText");
            logger.info("Add New Items Heading text mismatched:"+actualHeading);
            Assert.fail();
        }
    }

    @Test(priority = 2)//Heading font color should be white
    public void checkAddNewItemsHeadingColor()throws IOException{
        RegisterNewAssetsForUserPage registerPage=new RegisterNewAssetsForUserPage(driver);
        String actualColor = registerPage.getAddNewItemsHeadingColor();
        if(actualColor.equals("rgba(255, 255, 255, 1)"))
        {
            Assert.assertTrue(true);
            logger.info("Add New Items Heading text color is white");
        }
        else{
            captureScreen(driver,"checkAddNewItemsHeadingColor");
            logger.info("Add New Items Heading font color is not white."+actualColor);
            Assert.fail();
        }
    }

}
