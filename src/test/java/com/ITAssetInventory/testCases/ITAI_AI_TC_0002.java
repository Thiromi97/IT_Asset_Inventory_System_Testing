package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.BrowseInventoryPage;
import com.ITAssetInventory.pageObjects.HomePage;
import com.google.common.collect.Sets;
import junit.framework.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

public class ITAI_AI_TC_0002 extends Base{
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

    @Test(priority = 1)
    public void checkAllCommonFieldsArePresent() throws IOException {
        logger.info("Executing checkAllCommonFieldsArePresent test");
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> headers = wait.until(ExpectedConditions.visibilityOfAllElements(browseInventoryPage.getTableHeaders()));
        Set<String> requiredHeaders = Set.of("USER NAME", "ITEM TYPE", "ITEM NAME", "ITEM CODE", "QUANTITY", "REMARK", "IT PURCHASE NO", "WARRANTY PERIOD");
        Set<String> actualHeaders = headers.stream().map(WebElement::getText).collect(Collectors.toSet());

        if (actualHeaders.containsAll(requiredHeaders)) {
            Assert.assertTrue(true);
            logger.info("All required table headers are present.");

            Set<String> duplicateHeaders = requiredHeaders.stream()
                    .filter(header -> Collections.frequency(headers.stream().map(WebElement::getText).collect(Collectors.toList()), header) > 1)
                    .collect(Collectors.toSet());

            if (!duplicateHeaders.isEmpty()) {
                captureScreen(driver, "checkAllCommonFieldsArePresent");
                logger.info("Duplicate headers found: " + duplicateHeaders);
                Assert.fail();
            }
        } else {
            captureScreen(driver, "checkAllCommonFieldsArePresent");
            logger.info("Missing required headers: " + Sets.difference(requiredHeaders, actualHeaders));
            Assert.fail();
        }
        logger.info("checkAllCommonFieldsArePresent test completed");
    }

    @Test(priority = 2)
    public void checkAllLaptopAdditionalFieldsArePresent() throws IOException {
        logger.info("Executing checkAllLaptopAdditionalFieldsArePresent test");
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> headers = wait.until(ExpectedConditions.visibilityOfAllElements(browseInventoryPage.getTableHeaders()));
        Set<String> requiredHeaders = Set.of("LAPTOP BRAND NAME", "LAPTOP SERIAL NUMBER", "LAPTOP BAR CODE", "CHARGER SERIAL NUMBER", "CHARGER BAR CODE");

        Set<String> actualHeaders = headers.stream().map(WebElement::getText).collect(Collectors.toSet());

        if (actualHeaders.containsAll(requiredHeaders)) {
            Assert.assertTrue(true);
            logger.info("All additional laptop table headers are present.");

            Set<String> duplicateRequiredHeaders = requiredHeaders.stream()
                    .filter(header -> Collections.frequency(headers.stream().map(WebElement::getText).collect(Collectors.toList()), header) > 1)
                    .collect(Collectors.toSet());

            if (!duplicateRequiredHeaders.isEmpty()) {
                captureScreen(driver, "checkAllLaptopAdditionalFieldsArePresent");
                logger.info("Duplicate headers found: " + duplicateRequiredHeaders);
                Assert.fail();
            }
        } else {
            captureScreen(driver, "checkAllLaptopAdditionalFieldsArePresent");
            logger.info("Missing required headers: " + Sets.difference(requiredHeaders, actualHeaders));
            Assert.fail();
        }
        logger.info("checkAllLaptopAdditionalFieldsArePresent test completed");
    }

    @Test(priority = 3)
    public void checkAllDesktopAdditionalFieldsArePresent() throws IOException {
        logger.info("Executing checkAllDesktopAdditionalFieldsArePresent test");
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> headers = wait.until(ExpectedConditions.visibilityOfAllElements(browseInventoryPage.getTableHeaders()));
        Set<String> requiredHeaders = Set.of("MONITOR SERIAL NUMBER", "MONITOR BAR CODE", "CPU SERIAL NUMBER", "CPU BAR CODE");
        Set<String> actualHeaders = headers.stream().map(WebElement::getText).collect(Collectors.toSet());

        if (actualHeaders.containsAll(requiredHeaders)) {
            Assert.assertTrue(true);
            logger.info("All additional desktop table headers are present.");

            Set<String> duplicateHeaders = requiredHeaders.stream()
                    .filter(header -> Collections.frequency(headers.stream().map(WebElement::getText).collect(Collectors.toList()), header) > 1)
                    .collect(Collectors.toSet());

            if (!duplicateHeaders.isEmpty()) {
                captureScreen(driver, "checkAllDesktopAdditionalFieldsArePresent");
                logger.info("Duplicate headers found: " + duplicateHeaders);
                Assert.fail();
            }
        } else {
            captureScreen(driver, "checkAllDesktopAdditionalFieldsArePresent");
            logger.info("Missing required headers: " + Sets.difference(requiredHeaders, actualHeaders));
            Assert.fail();
        }
        logger.info("checkAllDesktopAdditionalFieldsArePresent test completed");
    }

    @Test(priority = 4)
    public void checkAllSubItemsAdditionalFieldsArePresent() throws IOException {
        logger.info("Executing checkAllSubItemsAdditionalFieldsArePresent test");
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        List<WebElement> headers = wait.until(ExpectedConditions.visibilityOfAllElements(browseInventoryPage.getTableHeaders()));
        Set<String> requiredHeaders = Set.of("CODE", "CODE TYPE");
        Set<String> actualHeaders = headers.stream().map(WebElement::getText).collect(Collectors.toSet());

        if (actualHeaders.containsAll(requiredHeaders)) {
            Assert.assertTrue(true);
            logger.info("All additional sub item table headers are present.");
            Set<String> duplicateHeaders = requiredHeaders.stream()
                    .filter(header -> Collections.frequency(headers.stream().map(WebElement::getText).collect(Collectors.toList()), header) > 1)
                    .collect(Collectors.toSet());

            if (!duplicateHeaders.isEmpty()) {
                captureScreen(driver, "checkAllSubItemsAdditionalFieldsArePresent");
                logger.info("Duplicate headers found: " + duplicateHeaders);
                Assert.fail();
            }
        } else {
            captureScreen(driver, "checkAllSubItemsAdditionalFieldsArePresent");
            logger.info("Missing required headers: " + Sets.difference(requiredHeaders, actualHeaders));
            Assert.fail();
        }
        logger.info("checkAllSubItemsAdditionalFieldsArePresent test completed");
    }


}
