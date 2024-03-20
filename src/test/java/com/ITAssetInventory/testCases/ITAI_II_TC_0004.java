package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.HomePage;
import com.ITAssetInventory.pageObjects.RegisterNewAssetsForUserPage;
import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class ITAI_II_TC_0004 extends Base {
    @Test(priority = 0)
    public void navigateToIssueItemSection() throws IOException {
        login();
        logger.info("Login to the Home Page");
        HomePage home=new HomePage(driver);
        home.clickIctInventoryManager();
        logger.info("Select ICT Inventory Manager from the dropdown");
        home.clickRegisterNewAssetsForUserOption();
        logger.info("Select Register New Assets for User from the dropdown");
    }

    @Test(priority = 1)
    public void checkUserNameDropdown()throws IOException{

        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
        registerPage.clickUserNameDropdown();
        List<WebElement> options = driver.findElements(By.xpath("//a[@class='chzn-single']"));
        boolean optionsSelectable = options.stream().allMatch(WebElement::isEnabled);

        if (optionsSelectable) {
            Assert.assertTrue(true);
            logger.info("All UserName dropdown options are selectable.");
        } else {
            captureScreen(driver, "checkUserNameDropdown");
            logger.info("Some dropdown options are not selectable.");
            Assert.fail();
        }
    }
}
