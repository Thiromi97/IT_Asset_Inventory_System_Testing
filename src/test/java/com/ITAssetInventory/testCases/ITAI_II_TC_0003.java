package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.HomePage;
import com.ITAssetInventory.pageObjects.RegisterNewAssetsForUserPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ITAI_II_TC_0003 extends Base {
    @Test(priority = 0)
    public void navigateToIssueItemSection() throws IOException {
        login();
        logger.info("Login to the Home Page");
        HomePage home = new HomePage(driver);
        home.clickIctInventoryManager();
        logger.info("Select ICT Inventory Manager from the dropdown");
        home.clickRegisterNewAssetsForUserOption();
        logger.info("Select Register New Assets for User from the dropdown");
    }

    @Test(priority = 1)
    public void checkUsernameDropdownPosition() throws IOException {
        int width = 600;
        int height= 716;
        driver.manage().window().setSize(new org.openqa.selenium.Dimension(width, height));
        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
        WebElement formContainer = registerPage.getIssueItemForm();
        WebElement usernameDropdown = registerPage.getUserNameDropdown();
        int elementX = usernameDropdown.getLocation().getX();
        int elementY = usernameDropdown.getLocation().getY();
        int containerX = formContainer.getLocation().getX();
        int containerY = formContainer.getLocation().getY();
        int containerWidth = formContainer.getSize().getWidth();
        int containerHeight = formContainer.getSize().getHeight();

        if(elementX >= containerX && elementY >= containerY && (elementX + usernameDropdown.getSize().getWidth()) <= (containerX + containerWidth) && (elementY + usernameDropdown.getSize().getHeight()) <= (containerY + containerHeight)){
            Assert.assertTrue(true);
            logger.info("Username dropdown is positioned within the form boundaries for screen size"+width+"x"+height);

        }
        else{
            captureScreen(driver,"checkUsernameDropdownPosition");
            logger.info("Username dropdown is not positioned within the form boundaries for screen size " + width + "x" + height);
            Assert.fail();

        }

    }



}

