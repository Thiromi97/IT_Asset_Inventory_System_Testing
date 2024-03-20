package com.ITAssetInventory.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BrowseInventoryPage {
    @FindBy(xpath = "/html/body/form/div[4]/div[3]/div/div[1]/div/div[1]/h4")
    @CacheLookup
    WebElement AllItemsInInventoryHeading;

    @FindBy(xpath = "/html/body/form/div[4]/div[3]/div/div[1]/div/div[1]/div/div[1]/div/div/div/table/thead/tr/th")
    @CacheLookup
    List<WebElement> tableHeaders;

    @FindBy(xpath = "/html/body/form/div[4]/div[3]/div/div[1]/div/div[1]/div/div[1]/div/div/div/table")
    @CacheLookup
    WebElement allItemsTable;

    @FindBy(xpath ="//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[3]" )
    @CacheLookup
    WebElement itemNameField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[4]")
    @CacheLookup
    WebElement itemCodeField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[5]")
    @CacheLookup
    WebElement quantityField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[6]")
    @CacheLookup
    WebElement itemTypeField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[10]")
    @CacheLookup
    WebElement laptopBrandField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[11]")
    @CacheLookup
    WebElement laptopSerialNoField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[12]")
    @CacheLookup
    WebElement laptopBarCodeField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[13]")
    @CacheLookup
    WebElement chargerSerialNoField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand\"]/thead/tr/th[14]")
    @CacheLookup
    WebElement chargerBarCodeField;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand_length\"]/label/select")
    @CacheLookup
    WebElement paginationAllItem;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_gridcashinhand_length\"]/label/select")
    @CacheLookup
    WebElement select100;

    WebDriver driver;

    public BrowseInventoryPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public String getAllItemsInInventoryHeadingText() {
        return AllItemsInInventoryHeading.getText();
    }

    public WebElement getAllItemsInInventoryHeading(){
        return AllItemsInInventoryHeading;
    }
    public String getAllItemsInInventoryHeadingColor(){
        return AllItemsInInventoryHeading.getCssValue("color");
    }

    public List<WebElement> getTableHeaders(){
        return tableHeaders;
    }

    public WebElement getAllItemsTable(){
        return allItemsTable;
    }

    public void recordsPerPage(){
        WebElement selectElement = paginationAllItem;
        Select select = new Select(selectElement);
        select.selectByValue("100");
    }

}
