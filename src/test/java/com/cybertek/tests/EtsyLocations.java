package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class EtsyLocations {

    WebDriver driver;

    @BeforeClass
    public void setDrivers() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void openBrowser() {
        driver = new ChromeDriver();
        driver.get("https://etsy.com");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement input = driver.findElement(By.id("search-query"));
        input.sendKeys("decal");
        //WebElement submit=driver.findElement(By.xpath("//button[@type='submit' and @value='Search']"));
        WebElement submit = driver.findElement(By.cssSelector("button[value='Search']"));
        submit.click();
    }

    @Test(priority = 1)
    public void anywhereIsChecked() {
        WebElement anywhr = driver.findElement(By.cssSelector("input[aria-label='Anywhere']"));
        Assert.assertTrue(anywhr.isSelected());

    }

    @Test(dependsOnMethods = "anywhereIsChecked")
    public void USisnotSelected() {
        WebElement anywhr = driver.findElement(By.cssSelector("input[aria-label='United States']"));
        Assert.assertFalse(anywhr.isSelected());

    }

    @Test(priority = 2)
    public void USASelected() {
        WebElement usa = driver.findElement(By.xpath("//*[@id=\"search-filter-reset-form\"]/div[8]/fieldset/div/div/div[1]/label[2]/a"));
        usa.click();
        Assert.assertTrue(driver.findElement(By.xpath("//input[@value='6252001']")).isSelected());
    }

    @Test
    public void AnywhereIsNotSelected() {
        WebElement usa = driver.findElement(By.xpath("//*[@id=\"search-filter-reset-form\"]/div[8]/fieldset/div/div/div[1]/label[2]/a"));
        usa.click();
        WebElement anywhr = driver.findElement(By.cssSelector("input[aria-label='Anywhere']"));

        Assert.assertFalse(anywhr.isSelected());
    }

    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
