package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class TabHandling {

    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/windows");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void newTab()
    {

        driver.findElement(By.linkText("Click Here")).click();
        System.out.println(driver.getTitle());
        //gets the tabs on arraylist and then go to first one
        ArrayList<String>tabs=new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(1));
        Set<String> windowhandles=driver.getWindowHandles();

        for(String handle:windowhandles)
        {
            System.out.println(handle);
            driver.switchTo().window(handle);
            if(driver.getTitle().equals("New Window"))
                break;
        }
       // driver.switchTo().window(windowhandles);
        Assert.assertEquals(driver.getTitle(),"New Window");
        Assert.assertNotEquals(driver.getTitle(),"The Internet");

    }
/*// got to w3schools.com/html
    click on try it yourself
    verify the url of new tab contains default*/
    @Test
    public void changeTab() {
        driver.get("https://www.w3schools.com/html/");
        driver.findElement(By.linkText("Try it Yourself »")).click();
        System.out.println(driver.getTitle());
        //gets the tabs on arraylist and then go to first one
        //ArrayList<String>tabs=new ArrayList<>(driver.getWindowHandles());
        //driver.switchTo().window(tabs.get(1));


        for (String handle : driver.getWindowHandles()){
            System.out.println(handle);
            driver.switchTo().window(handle);
            if (driver.getTitle().equals("Tryit Editor v3.6"))
                break;
        }
        // driver.switchTo().window(windowhandles);
        Assert.assertTrue(driver.getCurrentUrl().contains("default"));
        //Assert.assertNotEquals(driver.getTitle(),"The Internet");
    }
   /* @AfterMethod
    public void tearDown(){
        driver.quit();
    }*/

}
