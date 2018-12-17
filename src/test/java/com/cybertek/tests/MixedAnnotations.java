package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class MixedAnnotations {
WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.out.println("Setting up the drivers");
        WebDriverManager.chromedriver().setup();
    }


    @BeforeMethod
    public void SetUpMethod(){
        System.out.println("Opening a browser");
        driver=new ChromeDriver();
        System.out.println("go to website and login");
        driver.get("https://google.com");
    }
    @Test
    public void testOne(){
        System.out.println("Tesing testing");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Logout");
        System.out.println("Closing the browser");
        driver.quit();
    }
    @AfterClass
    public void afterClass(){
        System.out.println("REPORT EVERYTHING");
    }
}
