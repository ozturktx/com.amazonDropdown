package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;

public class AmazonDropdownMenues {
WebDriver driver;
Select dropdown;

    @BeforeClass
    public void setDrivers()
    {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeMethod
    public void openBrowser()
    {
        driver=new ChromeDriver();
        driver.get("https://amazon.com");

    }

    @Test(priority = 0)
    public void menuName(){
        WebElement mainDropDown=driver.findElement(By.id("searchDropdownBox"));
        dropdown= new Select(mainDropDown);
        List<WebElement>  options=new ArrayList<WebElement>(dropdown.getAllSelectedOptions());
        //it fails
        Assert.assertEquals(options.get(0).getText(),"All");
        //System.out.println(options.size());
    }
    @Test(priority = 1)
    public void AlphaticalOrderCheck(){

        //using compareTo method, compares each element with the next one

        WebElement mainDropDown=driver.findElement(By.id("searchDropdownBox"));
        dropdown= new Select(mainDropDown);
        List<WebElement>  options=new ArrayList<WebElement>(dropdown.getOptions());

        boolean issorted=true;
        for (int i=0;i<dropdown.getOptions().size()-1;i++)
        {
            if(options.get(i).getText().compareToIgnoreCase(options.get(i+1).getText())>0)
            {
                issorted=false;
                System.out.println(options.get(i+1).getText());
                System.out.println(options.get(i+2).getText());
                break;
            }

        }
        Assert.assertTrue(issorted);
    }

    @Test
    public void StoreDirectoryAllDepartmentsOrderCheck() throws InterruptedException {
        WebElement menu=driver.findElement(By.id("nav-hamburger-menu"));
        menu.click();
        Thread.sleep(3000);
        WebElement storeDirectory=driver.findElement(By.linkText("Full Store Directory"));
        storeDirectory.click();
        List<WebElement> departments=driver.findElements(By.cssSelector("h2[class='fsdDeptTitle']"));

        boolean issorted=true;
        for (int i=0;i<departments.size()-1;i++)
        {
            if(departments.get(i).getText().compareToIgnoreCase(departments.get(i+1).getText())>0)
            {
                issorted=false;
                System.out.println(departments.get(i).getText());
                System.out.println(departments.get(i+1).getText());
                break;
            }

        }
        Assert.assertTrue(issorted);

    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
