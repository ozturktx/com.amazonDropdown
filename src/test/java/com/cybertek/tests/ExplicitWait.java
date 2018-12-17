package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class ExplicitWait {
    WebDriver driver;
    @Test
    public void OnWhereImplicitDoesnotWork(){
        WebDriverManager.chromedriver().setup();
         driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);
        WebElement start=driver.findElement(By.tagName("button"));
        start.click();

        WebElement message =driver.findElement(By.cssSelector("#finish h4"));
        Assert.assertTrue(message.isDisplayed(),"Message not displayed");
        Assert.assertEquals(message.getText(),"Hello World!");


    }

    @Test
    public void explicitlyWait()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);
        WebElement start=driver.findElement(By.tagName("button"));
        start.click();
        WebElement message =driver.findElement(By.cssSelector("#finish h4"));

        // WAIT UNTIL MESSAGE BECOMES VISIBLE


        WebDriverWait wait=new WebDriverWait(driver,5);

    wait.until(ExpectedConditions.visibilityOf(message));

        Assert.assertTrue(message.isDisplayed(),"Message not displayed");
        Assert.assertEquals(message.getText(),"Hello World!");
    }

    @Test
    public void waitforDisappear()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";
        driver.get(url);
        WebElement start=driver.findElement(By.tagName("button"));
        start.click();
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("loading")));


        WebElement message =driver.findElement(By.cssSelector("#finish h4"));

        // WAIT UNTIL MESSAGE BECOMES VISIBLE
        Assert.assertTrue(message.isDisplayed());
        //Assert.assertEquals(message.getText(),"Hello World!");




    }

}
