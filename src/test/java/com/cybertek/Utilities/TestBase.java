package com.cybertek.Utilities;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public abstract class TestBase {
    public WebDriver driver;
    protected SoftAssert softAssert;
    protected Actions action;
public Faker fake;
    @BeforeClass
    public void setUpClass()
    {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp()
    {
        fake=new Faker();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        action= new Actions(driver);
        softAssert=new SoftAssert();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
        softAssert.assertAll();
    }
}
