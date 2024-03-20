package com.ITAssetInventory.testCases;

import com.ITAssetInventory.pageObjects.LoginPage;
import com.ITAssetInventory.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import java.io.File;
import java.io.IOException;

public class Base {

    ReadConfig readConfig = new ReadConfig();
    public String baseUrl = readConfig.getBaseURL();
    public String username = readConfig.getUsername();
    public String password = readConfig.getPassword();
    WebDriver driver;

    public static Logger logger;

    @Parameters("browser")

    @BeforeClass
    public void setup(String br)
    {
        logger = Logger.getLogger("GoodHealth AUD Plan");
        PropertyConfigurator.configure("Log4j.properties");

        if(br.equals("chrome"))
        {
            System.setProperty(readConfig.getChromePath(), "chromedriver");
            driver=new ChromeDriver();
        }

        else if(br.equals("edge")) {
            System.setProperty(readConfig.getEdgePath(), "msedgedriver");
            driver = new EdgeDriver();
        }

    }

    @AfterClass
    public void tearDown()
    {
        driver.close();
        driver.quit();
    }

    public void login()throws IOException{
        driver.get(baseUrl);
        logger.info("URL is opened");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();

        LoginPage login = new LoginPage(driver);
        login.setUsername(username);
        logger.info("Username is entered");
        login.setPassword(password);
        logger.info("Password is entered");
        login.clickSignIn();

        if(driver.getTitle().equals("iME | © Softlogic Life"))
        {
            Assert.assertTrue(true);
            logger.info("Login successfully");
        }
        else{
            captureScreen(driver,"login");
            Assert.assertFalse(false);
            logger.info("Login un-successful");
        }
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }

}
