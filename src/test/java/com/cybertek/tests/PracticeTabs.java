package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class PracticeTabs {

    WebDriver driver;

    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();

        driver.get("http://www.robotc.net/education/curriculum/vexiq/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @Test
    public void tab1() throws InterruptedException {
        Actions action=new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//li//a[.='Education '] "))).build().perform();
        driver.findElement(By.xpath("//div[@id='education']//a[contains(text(),'VEX Training')]")).click();


        for(String handle:driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
            System.out.println("Current tab:"+driver.getCurrentUrl());
        }
    System.out.println("=================Switching tabs=========");

        driver.findElement(By.linkText("CS-STEM Network")).click();

        for(String handle:driver.getWindowHandles())
        {
            driver.switchTo().window(handle);
            System.out.println("Current tab:"+driver.getCurrentUrl());
        }
       // driver.get("https://www.ebay.com/");
    }
}
