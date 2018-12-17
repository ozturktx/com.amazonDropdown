package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AmazonSearchResultsConfirmation {
    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.amazon.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }
    @Test
    public void searchAndCheck()
    {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium Cookbook", Keys.ENTER);
        //WebElement res=driver.findElement(By.xpath("//h2"));
       List<WebElement> results=new ArrayList<>(driver.findElements(By.xpath("//div[@id='atfResults']//h2")));
       boolean contns=true;
       for(WebElement a:results)
       {
           if(! a.getText().contains("Selenium")) {
               contns = false;
           }
       }
        Assert.assertTrue(contns,"items do not include Selenium");

    }
    @Test
    public void usaIsDefaultshippingOption()
    {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium Cookbook", Keys.ENTER);
        WebElement deliverto=driver.findElement(By.id("glow-ingress-line1"));
        deliverto.click();
        WebElement shipTo=driver.findElement(By.id("GLUXCountryList"));
        Select shippingOptions=new Select(shipTo);
        Assert.assertEquals(shippingOptions.getFirstSelectedOption().getText(),"Ship outside the US");
    }
    @Test
    public void canadaIsshippingOption()
    {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium Cookbook", Keys.ENTER);
        WebElement deliverto=driver.findElement(By.id("glow-ingress-line1"));
        deliverto.click();
        WebElement shipTo=driver.findElement(By.id("GLUXCountryList"));
        Select shippingOptions=new Select(shipTo);
        ArrayList<WebElement> sOptions=new ArrayList<>(shippingOptions.getOptions());
        boolean isCanada=false;
        for(WebElement a:sOptions)
        {
            if(a.getText().equals("Canada"))
            { isCanada=true;
            break;
            }

        }

        Assert.assertTrue(isCanada);
    }
    @Test
    public void canadaIsSelected()
    {
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Selenium Cookbook", Keys.ENTER);
        WebElement deliverto=driver.findElement(By.id("glow-ingress-line1"));
        deliverto.click();
        WebElement shipTo=driver.findElement(By.id("GLUXCountryList"));
        Select shippingOptions=new Select(shipTo);
        ArrayList<WebElement> sOptions=new ArrayList<>(shippingOptions.getOptions());

        boolean isCanada=false;
        for(WebElement a:sOptions)
        {
            if(a.getText().equals("Canada"))
            {
                a.click();

            }

        }

        Assert.assertEquals(shippingOptions.getFirstSelectedOption().getText(),"Canada");
    }
    @AfterMethod
    public void tearDown()
    {
        driver.quit();
    }
}
