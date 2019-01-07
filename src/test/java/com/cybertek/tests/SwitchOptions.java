package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SwitchOptions {
    WebDriver driver;
    String url="https://the-internet.herokuapp.com/tinymce";
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void switchByElement()
    {
        WebElement iframe=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("adadadadsa");
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();
    }
    @Test
    public void switchByName_Id()
    {
        driver.switchTo().frame("mce_0_ifr");
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("adadadadsa");
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();
    }
    @Test
    public void switchByIndex()
    {
        driver.switchTo().frame(0);
        driver.findElement(By.id("tinymce")).clear();
        driver.findElement(By.id("tinymce")).sendKeys("adadadadsa");
        driver.switchTo().parentFrame();
        driver.findElement(By.linkText("Elemental Selenium")).click();
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
