package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import javafx.scene.layout.Priority;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import sun.awt.windows.WEmbeddedFrame;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WaitsPractice {
    WebDriver driver;
    @Test(priority = 1)
    public void titleTest() {
    WebDriverManager.chromedriver().setup();
     driver= new ChromeDriver();
    driver.get("https://www.orbitz.com/");
        Assert.assertEquals(driver.getTitle(),"Orbitz Travel: Vacations, Cheap Flights, Airline Tickets & Airfares");
}
    @Test(priority=2)
    public void flightsTabCheck() throws InterruptedException {

       // WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.orbitz.com/");
        WebElement flights=driver.findElement(By.id("tab-flight-tab-hp"));
        flights.click();
        //WebElement oneway=driver.findElement(By.id("flight-type-one-way-label-hp-flight"));
        //oneway.click();
        Thread.sleep(2000);
        Assert.assertTrue(flights.isEnabled());
        //
    }

    @Test(priority=3)
    public void oneWaySelect() throws InterruptedException {

        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        //driver.get("https://www.orbitz.com/");
        WebElement oneway=driver.findElement(By.id("flight-type-one-way-label-hp-flight"));
        oneway.click();
       Assert.assertTrue(oneway.isEnabled(),"one way failed");




    }
    @Test(priority = 4)
    public void sortExplicitylWait(){
        WebElement from=driver.findElement(By.id("flight-origin-hp-flight"));
        WebElement to=driver.findElement(By.id("flight-destination-hp-flight"));
        WebElement date=driver.findElement(By.id("flight-departing-single-hp-flight"));
        from.sendKeys("Houston");
        to.sendKeys("NEWYORK");
        date.sendKeys("03/08/2019");
        driver.findElement(By.xpath("//button[@data-gcw-change-submit-text='Search'][1]")).click();

        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[@data-test-id='select-button'][1]"))));
        WebElement dropdown=driver.findElement(By.id("sortDropdown"));
        Select select= new Select(dropdown);
        select.selectByIndex(1);
        Assert.assertEquals(select.getFirstSelectedOption().getText(),"Price (Highest)");

    }
    @Test(priority = 5)
    public void chooseflight() throws InterruptedException {

        WebElement sel=driver.findElement(By.xpath("//button[@data-test-id='select-button'][1]"));
        WebDriverWait wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(sel));
        sel.click();
        Thread.sleep(3000);
        driver.findElement(By.id("forcedChoiceNoThanks")).click();


        ArrayList<String> tabs=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        wait=new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("bookButton"))));
        Assert.assertEquals(driver.getTitle(),"Trip Detail | Orbitz", "did not change the tab");
    }
}

