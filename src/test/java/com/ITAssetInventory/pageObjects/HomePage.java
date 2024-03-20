package com.ITAssetInventory.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/div[2]/div[1]/ul[1]/li[2]/a[1]")
    @CacheLookup
    WebElement ictInventoryManager;

    @FindBy(xpath = "/html[1]/body[1]/form[1]/div[4]/div[2]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]")
    @CacheLookup
    WebElement registerNewAssetsForUserOption;

    @FindBy(xpath = "//*[@id=\"leftmenu1\"]/ul/li[2]/ul/li[2]/a")
    @CacheLookup
    WebElement browseInventoryOption;

    public HomePage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clickIctInventoryManager() {
        ictInventoryManager.click();
    }

    public void clickRegisterNewAssetsForUserOption() {
        registerNewAssetsForUserOption.click();
    }

    public WebElement getBrowseInventoryOption(){return browseInventoryOption;}
}
