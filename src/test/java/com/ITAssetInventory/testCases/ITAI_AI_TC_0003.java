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
//IT Asset Inventory-All Items in IT Inventory Section - Table Data
public class ITAI_AI_TC_0003 extends Base {
    @Test(priority = 0)
    public void navigateToBrowseInventorySection() throws IOException {
        login();
        logger.info("Login to the Home Page");
        HomePage home = new HomePage(driver);
        home.clickIctInventoryManager();
        logger.info("Select ICT Inventory Manager from the dropdown");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement browseInventoryOption = wait.until(ExpectedConditions.elementToBeClickable(home.getBrowseInventoryOption()));
        browseInventoryOption.click();
        logger.info("Select Browse Inventory from the dropdown");
    }

    @Test(priority = 1)//Check a record in Table corresponding to  assigned Laptop.
    public void checkLaptopRecordDataAreFilled() throws IOException {
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        WebElement table = browseInventoryPage.getAllItemsTable();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (!cells.isEmpty()) {
                String itemName = cells.get(2).getText();
                if (itemName.equalsIgnoreCase("Laptop")) {
                    String requestID = cells.get(0).getText();
                    logger.info("----------------------------------------------------------------------");
                    logger.info("Request ID for Laptop record: " + requestID);
                    List<Integer> requiredFields = Arrays.asList(2, 3, 4, 5, 6, 10, 21);
                    List<Integer> specialLaptopFields  = Arrays.asList(11,12);
                    List<Integer> specialChargerFields  = Arrays.asList(13,14);
                    List<Integer> otherFields = Arrays.asList(7, 8, 15, 16, 17, 18);
                    boolean laptopBarCodeFilled = false;
                    boolean chargerBarCodeFilled = false;
                    boolean laptopSerialNoFilled = false;
                    boolean chargerSerialNoFilled = false;
                    for (Integer columnNumber : requiredFields) {
                        String fieldValue = cells.get(columnNumber - 1).getText();
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
                            case 21:
                                fieldName = "IT PURCHASE NUMBER";
                                break;
                            default:
                                fieldName = "Unknown Field";
                                break;
                        }
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    Assert.assertTrue(true);
                                    logger.info("Required field '" + fieldName + "' of Laptop record is filled.");
                                } else {
                                    captureScreen(driver, "checkLaptopRecordDataAreFilled");
                                    logger.info("Required field '" + fieldName + "' of Laptop record is not filled.");
                                    Assert.fail();
                                }

                    }

                    for(Integer laptopNumber:specialLaptopFields) {
                        String fieldValue = cells.get(laptopNumber - 1).getText();
                        switch (laptopNumber) {
                            case 11:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    laptopSerialNoFilled = true;
                                }
                                break;
                            case 12:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    laptopBarCodeFilled = true;
                                }
                                break;
                            default:
                                break;
                        }

                        if (laptopSerialNoFilled || laptopBarCodeFilled) {
                            Assert.assertTrue(true);
                            logger.info("At least one of the required fields (LAPTOP SERIAL NUMBER or LAPTOP BAR CODE) of Laptop record is filled.");
                            break;
                        } else {
                            captureScreen(driver, "checkLaptopRecordDataAreFilled");
                            logger.info("Both required fields (LAPTOP SERIAL NUMBER and LAPTOP BAR CODE) of Laptop record are not filled.");
                            Assert.fail();
                        }

                    }

                    for(Integer chargerNumber:specialChargerFields){
                        String fieldValue = cells.get(chargerNumber - 1).getText();
                        switch (chargerNumber) {
                            case 13:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    chargerSerialNoFilled = true;
                                }
                                break;
                            case 14:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    chargerBarCodeFilled = true;
                                }
                                break;
                            default:
                                break;
                        }

                        if (chargerSerialNoFilled || chargerBarCodeFilled) {
                            Assert.assertTrue(true);
                            logger.info("At least one of the required fields (CHARGER SERIAL NUMBER or CHARGER BAR CODE) of Laptop record is filled.");
                            break;
                        } else {
                            captureScreen(driver, "checkLaptopRecordDataAreFilled");
                            logger.info("Both required fields (CHARGER SERIAL NUMBER and CHARGER BAR CODE) of Laptop record are not filled.");
                            Assert.fail();
                        }

                    }

                    for (Integer fieldNumber : otherFields) {
                        String fieldValue = cells.get(fieldNumber - 1).getText();
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


                }
            }

        }

    }

    @Test(priority = 2)
    public void checkDesktopRecordDataAreFilled() throws IOException {
        BrowseInventoryPage browseInventoryPage = new BrowseInventoryPage(driver);
        browseInventoryPage.recordsPerPage();
        WebElement table = browseInventoryPage.getAllItemsTable();
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            if (!cells.isEmpty()) {
                String itemName = cells.get(2).getText();
                if (itemName.equalsIgnoreCase("Desktop Computer")) {
                    String requestID = cells.get(0).getText();
                    logger.info("----------------------------------------------------------------------");
                    logger.info("Request ID for Laptop record: " + requestID);
                    List<Integer> requiredFields = Arrays.asList(2, 3, 4, 5, 6, 21);
                    List<Integer> otherFields = Arrays.asList(7, 8, 10, 11, 12, 13, 14);
                    List<Integer> specialCPUFields = Arrays.asList(15,16);
                    List<Integer> specialMonitorFields = Arrays.asList(17,18);
                    boolean cpuBarCodeFilled = false;
                    boolean monitorBarCodeFilled = false;
                    boolean cpuSerialNoFilled = false;
                    boolean monitorSerialNoFilled = false;
                    // Check required fields
                    for (Integer columnNumber : requiredFields) {
                        String fieldValue = cells.get(columnNumber - 1).getText();
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
                            case 21:
                                fieldName = "IT PURCHASE NUMBER";
                                break;
                            default:
                                fieldName = "Unknown Field";
                                break;
                        }
                        if (!fieldValue.equalsIgnoreCase("N/A")) {
                            Assert.assertTrue(true);
                            logger.info("Required field '" + fieldName + "' of Laptop record is filled.");
                        } else {
                            captureScreen(driver, "checkLaptopRecordDataAreFilled");
                            logger.info("Required field '" + fieldName + "' of Laptop record is not filled.");
                            Assert.fail();
                        }

                    }

                    for(Integer cpuNumber:specialCPUFields){
                        String fieldValue = cells.get(cpuNumber - 1).getText();
                        switch (cpuNumber) {
                            case 15:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    cpuSerialNoFilled = true;
                                }
                                break;
                            case 16:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    cpuBarCodeFilled = true;
                                }
                                break;
                            default:
                                break;
                        }

                        if (cpuSerialNoFilled || cpuBarCodeFilled) {
                            Assert.assertTrue(true);
                            logger.info("At least one of the required fields (CPU SERIAL NUMBER or CPU BAR CODE) of Laptop record is filled.");
                            break;
                        } else {
                            captureScreen(driver, "checkDesktopRecordDataAreFilled");
                            logger.info("Both required fields (CPU SERIAL NUMBER and CPU BAR CODE) of Laptop record are not filled.");
                            Assert.fail();
                        }

                    }

                    for(Integer monitorNumber:specialMonitorFields){
                        String fieldValue = cells.get(monitorNumber - 1).getText();
                        switch (monitorNumber) {
                            case 17:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    monitorSerialNoFilled = true;
                                }
                                break;
                            case 18:
                                if (!fieldValue.equalsIgnoreCase("N/A")) {
                                    monitorBarCodeFilled = true;
                                }
                                break;
                            default:
                                break;
                        }

                        if (monitorSerialNoFilled || monitorBarCodeFilled) {
                            Assert.assertTrue(true);
                            logger.info("At least one of the required fields (Monitor SERIAL NUMBER or Monitor BAR CODE) of Laptop record is filled.");
                            break;
                        } else {
                            captureScreen(driver, "checkDesktopRecordDataAreFilled");
                            logger.info("Both required fields (Monitor SERIAL NUMBER and Monitor BAR CODE) of Laptop record are not filled.");
                            Assert.fail();
                        }

                    }


                    for (Integer fieldNumber : otherFields) {
                        String fieldValue = cells.get(fieldNumber- 1).getText();
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
                }
            }
        }
    }

    @Test(priority = 3)

}
