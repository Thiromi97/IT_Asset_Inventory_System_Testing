package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.BrowseInventoryPage;
import com.ITAssetInventory.pageObjects.HomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ITAI_AI_TC_0003 extends Base{
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
    public void checkLaptopRecordDataAreFilled() throws IOException {
        logger.info("Executing checkLaptopRecordDataAreFilled test");
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        WebElement table = browseInventoryPage.getAllItemsTable();
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        for (WebElement row : tableRows) {
            WebElement itemNameCell = row.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/tbody/tr/td[3]")); // Assuming item name is in the 3rd column
            String itemName = itemNameCell.getText();

            if (itemName.equalsIgnoreCase("Laptop")) {
                List<Integer> requiredFields = Arrays.asList(2, 3, 4, 5, 6, 10, 11, 12, 13, 14,21);
                List<Integer> otherFields = Arrays.asList(7, 8, 15,16, 17, 18);
                // Check required fields
                for (Integer columnNumber : requiredFields) {
                    WebElement fieldCell = row.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/tbody/tr/td[" + columnNumber + "]"));
                    String fieldValue = fieldCell.getText();
                    String fieldName;
                    switch (columnNumber) {
                        case 2:
                            fieldName = "USER NAME";
                            break;
                        case 3:
                            fieldName = "ITEM NAME";
                            break;
                        case 4:
                            fieldName = "ITEM CODE";
                            break;
                        case 5:
                            fieldName = "QUANTITY";
                            break;
                        case 6:
                            fieldName = "ITEM TYPE";
                            break;
                        case 10:
                            fieldName = "LAPTOP BRAND NAME";
                            break;
                        case 11:
                            fieldName = "LAPTOP SERIAL NUMBER";
                            break;
                        case 12:
                            fieldName = "LAPTOP BAR CODE";
                            break;
                        case 13:
                            fieldName = "CHARGER SERIAL NUMBER";
                            break;
                        case 14:
                            fieldName = "CHARGER BAR CODE";
                            break;
                        case 21:
                            fieldName = "IT PURCHASE NUMBER";
                            break;
                        default:
                            fieldName = "Unknown Field";
                            break;
                    }
                    if(columnNumber == 11 || columnNumber == 12){
                        if (!fieldValue.equalsIgnoreCase("N/A")) {
                            Assert.assertTrue(true);
                            logger.info("Required field '" + fieldName + "' of Laptop record is filled.");
                        }
                        else {
                            captureScreen(driver, "checkLaptopRecordDataAreFilled");
                            logger.info("Required field '" + fieldName + "' of Laptop record is not filled.");
                            Assert.fail();
                        }
                    }else if (columnNumber == 13 || columnNumber == 14){
                        if (!fieldValue.equalsIgnoreCase("N/A")) {
                            Assert.assertTrue(true);
                            logger.info("Required field '" + fieldName + "' of Laptop record is filled.");
                        }
                        else {
                            captureScreen(driver, "checkLaptopRecordDataAreFilled");
                            logger.info("Required field '" + fieldName + "' of Laptop record is not filled.");
                            Assert.fail();
                        }
                    }
                    else{
                        if (!fieldValue.equalsIgnoreCase("N/A")) {
                            Assert.assertTrue(true);
                            logger.info("Required field '" + fieldName + "' of Laptop record is filled.");
                        }
                        else {
                            captureScreen(driver, "checkLaptopRecordDataAreFilled");
                            logger.info("Required field '" + fieldName + "' of Laptop record is not filled.");
                            Assert.fail();
                        }
                    }
                }
                for (Integer fieldNumber : otherFields) {
                    WebElement fieldCell = row.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/tbody/tr/td[" + fieldNumber + "]"));
                    String fieldValue = fieldCell.getText();
                    String fieldName;
                    switch (fieldNumber) {
                        case 7:
                            fieldName = "CODE";
                            break;
                        case 8:
                            fieldName = "CODE TYPE";
                            break;
                        case 15:
                            fieldName = "CPU SERIAL NUMBER";
                            break;
                        case 16:
                            fieldName = "CPU BAR CODE";
                            break;
                        case 17:
                            fieldName = "MONITOR SERIAL NUMBER";
                            break;
                        case 18:
                            fieldName = "MONITOR BAR CODE";
                            break;
                        default:
                            fieldName = "Unknown Field";
                            break;
                    }

                    if (fieldValue.equals("N/A")) {
                        Assert.assertTrue(true);
                        logger.info("Non-required field '" + fieldName + "' of Laptop record is filled with 'N/A'.");
                    } else {
                        captureScreen(driver, "checkLaptopRecordDataAreFilled");
                        logger.info("Non-required field '" + fieldName + "' of Laptop record is not filled with 'N/A'.");
                        Assert.fail();
                    }
                }

                logger.info("checkLaptopRecordDataAreFilled test completed");
            }
        }
        driver.navigate().refresh();
    }

    @Test(priority = 2)
    public void checkDesktopRecordDataAreFilled() throws IOException {
        logger.info("Executing checkDesktopRecordDataAreFilled test");
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        browseInventoryPage.recordsPerPage();
        WebElement table = browseInventoryPage.getAllItemsTable();
        List<WebElement> tableRows = table.findElements(By.tagName("tr"));

        for (WebElement row : tableRows) {
            WebElement itemNameCell = row.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/tbody/tr/td[3][text()='Desktop Computer']")); // Assuming item name is in the 3rd column
            String itemName = itemNameCell.getText();
            logger.info("Item Name: " + itemName);

            if (itemName.equalsIgnoreCase("Desktop Computer")) {
                List<Integer> requiredFields = Arrays.asList(2, 3, 4, 5, 6, 15, 16, 17, 18,21);
                List<Integer> otherFields = Arrays.asList(7, 8, 10,11, 12, 13,14);
                // Check required fields
                for (Integer columnNumber : requiredFields) {
                    WebElement fieldCell = row.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/tbody/tr/td[" + columnNumber + "]"));
                    String fieldValue = fieldCell.getText();
                    String fieldName;
                    boolean isAnyFieldFilled = false;
                    switch (columnNumber) {
                        case 2:
                            fieldName = "USER NAME";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + fieldName + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("Required field '" + fieldName + "' of Desktop record is not filled.");
                                Assert.fail();
                            }
                            break;
                        case 3:
                            fieldName = "ITEM NAME";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + fieldName + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("Required field '" + fieldName + "' of Desktop record is not filled.");
                                Assert.fail();
                            }
                            break;
                        case 4:
                            fieldName = "ITEM CODE";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + fieldName + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("Required field '" + fieldName + "' of Desktop record is not filled.");
                                Assert.fail();
                            }
                            break;
                        case 5:
                            fieldName = "QUANTITY";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + fieldName + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("Required field '" + fieldName + "' of Desktop record is not filled.");
                                Assert.fail();
                            }
                            break;
                        case 6:
                            fieldName = "ITEM TYPE";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + fieldName + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("Required field '" + fieldName + "' of Desktop record is not filled.");
                                Assert.fail();
                            }
                            break;
                        case 15:
                            fieldName = "CPU SERIAL NUMBER";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + columnNumber + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("None of the required field'" +columnNumber+ "'of Desktop record is filled.");
                                Assert.fail();
                                }
                            break;
                        case 17:
                        case 18:
                            fieldName = "MONITOR SERIAL NUMBER OR BAR CODE";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + fieldName + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("None of the required field'" + fieldName+ "'of Desktop record is filled.");
                                Assert.fail();
                            }
                            break;
                        case 21:
                            fieldName = "IT PURCHASE NUMBER";
                            if (!fieldValue.equalsIgnoreCase("N/A")) {
                                Assert.assertTrue(true);
                                logger.info("Required field '" + fieldName + "' of Desktop record is filled.");
                            }
                            else {
                                captureScreen(driver, "checkDesktopRecordDataAreFilled");
                                logger.info("Required field '" + fieldName + "' of Desktop record is not filled.");
                                Assert.fail();
                            }
                            break;
                        default:
                            fieldName = "Unknown Field";
                            break;
                    }


                }
                for (Integer fieldNumber : otherFields) {
                    WebElement fieldCell = row.findElement(By.xpath("//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/tbody/tr/td[" + fieldNumber + "]"));
                    String fieldValue = fieldCell.getText();
                    String fieldName;
                    switch (fieldNumber) {
                        case 7:
                            fieldName = "CODE";
                            break;
                        case 8:
                            fieldName = "CODE TYPE";
                            break;
                        case 10:
                            fieldName = "LAPTOP BRAND NAME";
                            break;
                        case 11:
                            fieldName = "LAPTOP SERIAL NUMBER";
                            break;
                        case 12:
                            fieldName = "LAPTOP BAR CODE";
                            break;
                        case 13:
                            fieldName = "CHARGER SERIAL NUMBER";
                            break;
                        case 14:
                            fieldName = "CHARGER BAR CODE";
                            break;
                        default:
                            fieldName = "Unknown Field";
                            break;
                    }

                    if (fieldValue.equals("N/A")) {
                        Assert.assertTrue(true);
                        logger.info("Non-required field '" + fieldName + "' of Desktop record is filled with 'N/A'.");
                    } else {
                        captureScreen(driver, "checkDesktopRecordDataAreFilled");
                        logger.info("Non-required field '" + fieldName + "' of Desktop record is not filled with 'N/A'.");
                        Assert.fail();
                    }
                }

                logger.info("checkDesktopRecordDataAreFilled test completed");
            }
        }
    }


}
