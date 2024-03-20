package com.ITAssetInventory.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "txtUsername")
    @CacheLookup
    WebElement usernameField;

    @FindBy(id = "txtPassword")
    @CacheLookup
    WebElement passwordField;

    @FindBy(id = "btnSubmit")
    @CacheLookup
    WebElement signInBtn;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }
    public void setUsername(String username){
        usernameField.sendKeys(username);
    }
    public void setPassword(String password){
        passwordField.sendKeys(password);
    }
    public void clickSignIn(){
        signInBtn.click();
    }



}
