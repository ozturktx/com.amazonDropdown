package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class googleTest {

    WebDriver driver;

    @BeforeMethod
    public void SetUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://google.com");
    }
    @Test
    public void test1(){
        Assert.assertTrue(driver.getTitle().contains("Google"));
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }

}
