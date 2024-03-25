package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.HomePage;
import com.ITAssetInventory.pageObjects.RegisterNewAssetsForUserPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

//IT Asset Inventory-Issue Item Section - Heading
public class ITAI_II_TC_0001 extends Base{

    @Test(priority = 0)//Navigate to the Issue Items Section
    public void navigateToIssueItemSection() throws IOException {
        login();
        logger.info("Login to the Home Page");
        HomePage home=new HomePage(driver);
        home.clickIctInventoryManager();
        logger.info("Select ICT Inventory Manager from the dropdown");
        home.clickRegisterNewAssetsForUserOption();
        logger.info("Select Register New Assets for User from the dropdown");
    }

    @Test(priority = 1)//Heading should be "Issue Item" (word should be start with a capital letter)
    public void checkHeadingText()throws IOException{
        RegisterNewAssetsForUserPage registerPage=new RegisterNewAssetsForUserPage(driver);
        String actualHeading = registerPage.getIssueItemHeadingText();
        if (actualHeading.equals("Issue Item"))
        {
            Assert.assertTrue(true);
            logger.info("Heading text is correct");
        }
        else{
            captureScreen(driver,"checkHeadingText");
            logger.info("Heading text mismatched:"+actualHeading);
            Assert.fail();
        }

    }

    @Test(priority = 2)
    public void checkHeadingColor()throws IOException{
        RegisterNewAssetsForUserPage registerPage=new RegisterNewAssetsForUserPage(driver);
        String actualColor = registerPage.getIssueItemHeadingColor();
        if(actualColor.equals("rgba(255, 255, 255, 1)"))
        {
            Assert.assertTrue(true);
            logger.info("Heading text color is white");
        }
        else{
//            captureScreen(driver,"checkHeadingColor");
            logger.info("Heading font color is not white."+actualColor);
            Assert.fail();
        }
    }

//    @Test(priority = 3)
//    public void checkCapitalization()throws IOException{
//        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
//        String headingText = registerPage.getIssueItemHeadingText();
//        String[] words = headingText.split("\\s+");
//        boolean allWordsCapitalized = true;
//        for (String word : words) {
//            String firstLetter = word.substring(0, 1);
//            if (!firstLetter.equals(firstLetter.toUpperCase())) {
//                allWordsCapitalized = false;
//                break;
//            }
//        }
//        if (allWordsCapitalized) {
//            Assert.assertTrue(true);
//            logger.info("All words start with uppercase in the heading");
//        } else {
//            captureScreen(driver, "checkCapitalization");
//            logger.info("Not all words start with uppercase in the heading: " + headingText);
//            Assert.fail();
//        }
//    }
//

}
