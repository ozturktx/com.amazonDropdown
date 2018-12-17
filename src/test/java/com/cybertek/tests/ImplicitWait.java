package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ImplicitWait {

    @Test
    public void test()throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";

        driver.get(url);

        WebElement start=driver.findElement(By.tagName("button"));
        start.click();

        WebElement message =driver.findElement(By.xpath("//h4[.='Hello World!']"));

        //Thread.sleep(5000);
        Assert.assertTrue(message.isDisplayed());//,"Message not displayed");

    }
    @Test
    public void realExample(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/dynamic_controls";


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        driver.findElement(By.xpath("//button[.='Remove']")).click();
        WebElement message=driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed(),"Mesage should be displayed");
        Assert.assertEquals(message.getText(),"It's gone!");

        driver.findElement(By.xpath("//button[.='Add']")).click();
       message=driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed(),"Mesage should be displayed");
        Assert.assertEquals(message.getText(),"It's back!");


    }
}
