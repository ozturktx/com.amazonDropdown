package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class SleepTest {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = "https://the-internet.herokuapp.com/dynamic_loading/1";

        driver.get(url);

        WebElement start=driver.findElement(By.tagName("button"));
        start.click();

        WebElement message =driver.findElement(By.xpath("//h4[.='Hello World!']"));

        Thread.sleep(5000);
        Assert.assertTrue(message.isDisplayed(),"Message not displayed");
    }


}
