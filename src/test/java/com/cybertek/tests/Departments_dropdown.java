package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Departments_dropdown {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = "http://amazon.com";

        driver.get(url);

        WebElement mainDropDown=driver.findElement(By.id("searchDropdownBox"));
        Select dropdown= new Select(mainDropDown);
        List<WebElement> options=new ArrayList<WebElement>(dropdown.getAllSelectedOptions());
        if(options.get(0).getText().equals("All Departments"))
            System.out.println("First test is passed");
        else
            System.out.println("First test is failed");

        options=new ArrayList<WebElement>(dropdown.getOptions());
        System.out.println("********************TEST***********************");
        if(sort(options)) {
            System.out.println("Test 2 is passed");
        }
        else{
            System.out.println("Alphatical order Dropdown test is failed");
        }

        WebElement menu=driver.findElement(By.id("nav-hamburger-menu"));
        menu.click();
        WebElement storeDirectory=driver.findElement(By.linkText("Full Store Directory"));
        storeDirectory.click();

        //System.out.println(options.size());
        List<WebElement> departments=driver.findElements(By.cssSelector("h2[class='fsdDeptTitle']"));
        //System.out.println(departments.size());

        System.out.println("******************TEST ****************");
        if(sort(departments))
            System.out.println("Sorted department name test is passed");
        else
            System.out.println("Sorted department name test is failed");


    }

    public static boolean sort(List<WebElement> lst)
    {
        boolean issorted=true;

        for(int i=1;i<lst.size()-1;i++)
        {
            if(lst.get(i).getText().compareToIgnoreCase(lst.get(i+1).getText())>0)
            {
                issorted=false;
                System.out.println(lst.get(i+1).getText());
                System.out.println(lst.get(i+2).getText());
                break;
            }
        }
        return issorted;
    }
}
