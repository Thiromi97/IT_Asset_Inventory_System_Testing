package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.HomePage;
import com.ITAssetInventory.pageObjects.RegisterNewAssetsForUserPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

public class ITAI_II_TC_0002 extends Base {
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
    public void checkLabelsAreBold() throws IOException{
        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
        List<WebElement> inputFields = registerPage.getInputFieldsLabels();
        boolean allLabelsAreBold = true;
        for (int i = 0; i < Math.min(8, inputFields.size()); i++) {
            WebElement inputFieldLabel = inputFields.get(i);
            String fontWeight = inputFieldLabel.getCssValue("font-weight");
            if (!fontWeight.equals("700")) {
                allLabelsAreBold = false;
                break;
            }
        }
        if (allLabelsAreBold) {
            Assert.assertTrue(true);
            logger.info("All labels have font-weight of 700");
        } else {
            captureScreen(driver, "checkLabelsAreBold");
            logger.info("Not all labels have font-weight of 700.");
            Assert.fail();
        }

    }

    @Test(priority = 2)
    public void checkLabelsAreCapitalized() throws IOException{
        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
        List<WebElement> inputFields = registerPage.getInputFieldsLabels();
        boolean allLabelsAreCapitalized = true;
        for (WebElement inputFieldLabel : inputFields.subList(0, Math.min(8, inputFields.size()))) {
            String labelText = inputFieldLabel.getText();
            for (String word : labelText.split("\\s+")) {
                if (!Character.isUpperCase(word.charAt(0))) {
                    allLabelsAreCapitalized = false;
                    break;
                }
            }
        }
        if (allLabelsAreCapitalized) {
            Assert.assertTrue(true);
            logger.info("All Labels are capitalized properly.");
        } else {
            captureScreen(driver, "checkLabelsAreCapitalized");
            logger.info("Not all labels have proper capitalization.");
            Assert.fail();
        }

    }

}
