package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestNG_1 {


    //=driver.findElement(By.name("login"));

    String [] expectedOptions=new String[]{"Acapulco", "Frankfurt", "London", "New York", "Paris", "Portland", "San Francisco", "Seattle", "Sydney", "Zurich"};
    WebDriver driver;


    @BeforeMethod
    public  void setUp()
    {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = "http://www.newtours.demoaut.com/";
        driver.get(url);

        WebElement username=driver.findElement(By.name("userName"));
        WebElement password=driver.findElement(By.name("password"));
        WebElement login=driver.findElement(By.name("login"));
        username.sendKeys("tutorial");
        password.sendKeys("tutorial");
        login.click();



    }
    @Test
    public void testOne()
    {
        WebElement departFrom=driver.findElement(By.name("fromPort"));
        Select departList=new Select(departFrom);

        String defaultSelected=departList.getFirstSelectedOption().getText();

        Assert.assertEquals(defaultSelected,"Acapulco");
        if(defaultSelected.equals("Acapulco"))
            System.out.println("Default selected test is passed");
        else
            System.out.println("Default selected test is failed");
    }
    @Test
    public void testTwo()
    {   //List<WebElement> departOptions=departList.getOptions();
        WebElement departFrom=driver.findElement(By.name("fromPort"));
        Select departList=new Select(departFrom);

        List<WebElement>departOptions=departList.getOptions();
        boolean passed=true;
        for(int i=0;i<expectedOptions.length;i++)
        {
            Assert.assertEquals(expectedOptions[i],departOptions.get(i).getText());
            if(!expectedOptions[i].equals(departOptions.get(i).getText()))
            {
                passed=false;
                break;
            }
        }
        if(passed)
        {
            System.out.println("Depart from locations test is passed");
        }
        else
            System.out.println("Depart from locations test is failed");




    }
    @AfterMethod
    public void tearDown()
    {
        System.out.println("Closing");
    }
}
