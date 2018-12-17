package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static java.time.Duration.*;

public class FluentWaitTest {

    @Test

    public void test()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/dynamic_controls";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);

        driver.findElement(By.xpath("//button[.='Remove']")).click();

        Wait<WebDriver>wait=new FluentWait<WebDriver>(driver).withTimeout(ofSeconds(5)).
                pollingEvery(ofSeconds(5))
                .ignoring(NoSuchElementException.class);
        WebElement message=driver.findElement(By.id("message"));
        Assert.assertTrue(message.isDisplayed(),"Mesage should be displayed");
        Assert.assertEquals(message.getText(),"It's gone!");



    }
}
