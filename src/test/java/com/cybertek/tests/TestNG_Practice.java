package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class TestNG_Practice {

    WebDriver driver;
    @BeforeClass
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void beforeMethod(){
        driver=new ChromeDriver();
        driver.get("https://www.peardeck.com");
    }
    @Test
    public void titleTest(){
        String expected="Pear Deck";
        Assert.assertEquals(driver.getTitle(),expected);

    }
    @Test
    public void studentLogin(){
        WebElement button=driver.findElement(By.linkText("Student Login"));
        Assert.assertTrue(button.isDisplayed());

    }
    @Test
    public void TeacherLogin(){
        WebElement button=driver.findElement(By.linkText("Teacher Login"));
        Assert.assertTrue(button.isDisplayed());
    }
    @Test
    public void priceButton(){
        WebElement button=driver.findElement(By.linkText("Pricing"));
        Assert.assertTrue(button.isDisplayed());
    }
    @Test(dependsOnMethods = "priceButton")
    public void EssentialPricingOption(){
        WebElement button=driver.findElement(By.linkText("Pricing"));
        button.click();
        WebElement essential=driver.findElement(By.id("block-yui_3_17_2_7_1518711235727_24794"));
       // if(essential.isDisplayed()&&essential.getText())
        Assert.assertTrue(essential.isDisplayed(),"did not Passed");

    }
    @Test(dependsOnMethods = "priceButton")
    public void PremiumpricingOption(){
        WebElement button=driver.findElement(By.linkText("Pricing"));
        button.click();
        WebElement premium=driver.findElement(By.xpath("//h3[contains(text(),'PREMIUM')]"));
        if(premium.isDisplayed()&&premium.getText().equals("PREMIUM"))
        Assert.assertTrue(true,"expected PREMIUM"+" actual: "+premium.getText());

    }
    @Test(dependsOnMethods = "priceButton")
    public void Premiumprice(){
        WebElement button=driver.findElement(By.linkText("Pricing"));
        button.click();
        WebElement pprice=driver.findElement(By.xpath("(//p[@class='pricing-table-1__price'])[2]"));
        Assert.assertEquals(pprice.getText(),"$149.99",pprice.getText());

    }
    @Test
    public void quote(){
        WebElement button=driver.findElement(By.linkText("Pricing"));
        button.click();
        Assert.assertTrue(driver.findElement(By.xpath("//a[.='Request a Quote']")).isDisplayed());

    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

}
