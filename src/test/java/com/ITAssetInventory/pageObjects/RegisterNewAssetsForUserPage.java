package com.ITAssetInventory.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class RegisterNewAssetsForUserPage {

    @FindBy(id = "ContentPlaceHolder1_title")
    @CacheLookup
    WebElement issueItemHeading;

    @FindBy(xpath = "/html/body/form/div[4]/div[3]/div/div[1]/div[3]/div[3]/div/div/div/div[2]/div/h4")
    @CacheLookup
    WebElement newItemHeading;

    @FindBy(tagName = "label")
    @CacheLookup
    List<WebElement> inputFieldsLabels;
    @FindBy(xpath = "/html/body/form/div[4]/div[3]/div/div[1]/div[3]/div[3]/div/div/div/div[1]/div/div/div/div/div[1]/div[2]/div/a/span")
    @CacheLookup
    WebElement usernameDropdown;

    @FindBy(id = "ContentPlaceHolder1_PNLCapex")
    @CacheLookup
    WebElement issueItemForm;

    @FindBy(xpath = "//*[@id=\"ContentPlaceHolder1_cmbAgentUser_chzn\"]/div/div/input")
    @CacheLookup
    WebElement userNameSearchBar;

    public RegisterNewAssetsForUserPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public String getIssueItemHeadingText() {
        return issueItemHeading.getText();
    }
    public WebElement getNewItemHeading(){return newItemHeading;}
    public String getNewItemHeadingText(){return newItemHeading.getText();}
    public String getIssueItemHeadingColor(){
        return issueItemHeading.getCssValue("color");
    }
    public String getAddNewItemsHeadingColor(){return newItemHeading.getCssValue("color");}
    public List<WebElement> getInputFieldsLabels(){
        return inputFieldsLabels;
    }
    public WebElement getUserNameDropdown(){
       return usernameDropdown;
    }
    public void clickUserNameDropdown(){
        usernameDropdown.click();
    }
    public WebElement getIssueItemForm() {
        return issueItemForm;
    }
    public WebElement getUserNameSearchBar(){return userNameSearchBar;}

}
