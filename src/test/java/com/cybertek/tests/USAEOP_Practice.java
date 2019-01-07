package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class USAEOP_Practice {

    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.usaeop.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void urlTest()
    {
        String expected="https://www.usaeop.com/";
        Assert.assertEquals(driver.getCurrentUrl(),expected);
    }
    @Test
    public void interestedOptions() throws InterruptedException {

        driver.findElement(By.cssSelector("a[class='button help find-a-program']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id=\"participants-educators\"]//parent::p[@class='ng-scope']")).click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[@class='button more next-question'][1]")).isEnabled());

        //*[@id="filter-participants"]/fieldset/div/p[2]
    }
    @Test
    public void UndergradNotselected() throws InterruptedException {

        driver.findElement(By.cssSelector("a[class='button help find-a-program']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//input[@id=\"participants-educators\"]//parent::p[@class='ng-scope']")).click();
       driver.findElement(By.xpath("//a[@class='button more next-question'][1]")).click();
        Assert.assertTrue(!driver.findElement(By.id("grade-multi-178")).isEnabled());

        //*[@id="filter-participants"]/fieldset/div/p[2]
    }
    @Test
    public void gradeLevel() throws InterruptedException {

        driver.findElement(By.cssSelector("a[class='button help find-a-program']")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@id=\"participants-educators\"]//parent::p[@class='ng-scope']")).click();
        driver.findElement(By.xpath("//a[@class='button more next-question'][1]")).click();
        /*Thread.sleep(2000);
        driver.findElement(By.cssSelector("#filter-grade > fieldset > div > p:nth-child(26)")).click();
        Thread.sleep(2000);/*/
        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
       // [@id="filter-participants"]/fieldset/div/p[2]
        driver.findElement(By.xpath("//a[@href='https://www.usaeop.com/program-volunteers/']")).click();
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }


}
