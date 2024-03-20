package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.HomePage;
import com.ITAssetInventory.pageObjects.RegisterNewAssetsForUserPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

public class ITAI_II_TC_0005 extends Base{
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
    public void checkUserNameDropdownWhenEmptySearch() throws IOException {
        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
        registerPage.clickUserNameDropdown();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='chzn-single']")));
        List<WebElement> options = driver.findElements(By.xpath("//a[@class='chzn-single']"));
        boolean allUsernamesDisplayed = !options.isEmpty();
        if (allUsernamesDisplayed) {
            Assert.assertTrue(true);
            logger.info("The User Name dropdown displays all usernames without any filtering.");
        } else {
//            captureScreen(driver, "checkUserNameDropdownWhenEmptySearch");
            logger.info("The User Name dropdown does not display all usernames without any filtering.");
            Assert.fail();
        }
    }

    @Test(priority = 2)
    public void searchUserNameInDropdown() throws IOException {
        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
        registerPage.clickUserNameDropdown();
        registerPage.getUserNameSearchBar().sendKeys("Intern");
        registerPage.getUserNameSearchBar().sendKeys(Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='7611 | IT Intern | HO']")));
        boolean usernameFound = !driver.findElements(By.xpath("//span[text()='7611 | IT Intern | HO']")).isEmpty();

        if (usernameFound) {
            Assert.assertTrue(true);
            logger.info("Username found in the dropdown search results.");
        } else {
//            captureScreen(driver, "searchUserNameInDropdown");
            logger.info("Username not found in the dropdown search results.");
            Assert.fail();
        }
    }

    @Test(priority = 3)
    public void checkDropdownWithNonExistentKeyword() throws IOException {
        driver.navigate().refresh();
        RegisterNewAssetsForUserPage registerPage = new RegisterNewAssetsForUserPage(driver);
        registerPage.clickUserNameDropdown();
        registerPage.getUserNameSearchBar().sendKeys("Thiromi");
        registerPage.getUserNameSearchBar().sendKeys(Keys.ENTER);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='no-results']")));
        WebElement noResultsMessage = driver.findElement(By.xpath("//li[@class='no-results']"));
        String expectedMessage = "No results match \"Thiromi\"";
        String actualMessage = noResultsMessage.getText();
        if (actualMessage.equals(expectedMessage)) {
            Assert.assertTrue(true);
            logger.info("Dropdown displays 'No results' message for a non-existent keyword.");
        } else {
//            captureScreen(driver, "checkDropdownWithNonExistentKeyword");
            logger.info("Dropdown does not display the expected 'No results' message for a non-existent keyword.");
            Assert.fail();
        }
    }



}
