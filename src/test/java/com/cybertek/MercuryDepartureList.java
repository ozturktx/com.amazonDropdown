package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MercuryDepartureList {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
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
        WebElement departFrom=driver.findElement(By.name("fromPort"));

        String []expectedOptions=new String[]{"Acapulco", "Frankfurt", "London", "New York", "Paris", "Portland", "San Francisco", "Seattle", "Sydney", "Zurich"};
        Select departList=new Select(departFrom);
        String defaultSelected=departList.getFirstSelectedOption().getText();
        List<WebElement>departOptions=departList.getOptions();
        if(defaultSelected.equals("Acapulco"))
            System.out.println("Default selected test is passed");
        else
            System.out.println("Default selected test is failed");
        boolean passed=true;
        for(int i=0;i<expectedOptions.length;i++)
        {
            if(!expectedOptions[i].equals(departOptions.get(i).getText()))
            {
                passed=false;//
                break;
            }
        }
        if(passed)
        {
            System.out.println("Depart from locations test is passed");
        }
        else
            System.out.println("Depart from locations test is failed");

        for(int i=0;i<2;i++) {
            if (driver.findElement(By.cssSelector("input[value='roundtrip']")).isSelected() && !driver.findElement(By.cssSelector("input[value='oneway']")).isSelected()) {
                System.out.println("Round trip is selected and Oneway trip is not selected");
                driver.findElement(By.cssSelector("input[value='oneway']")).click();
            } else if(!driver.findElement(By.cssSelector("input[value='roundtrip']")).isSelected() && driver.findElement(By.cssSelector("input[value='oneway']")).isSelected())
            {
                System.out.println("Round trip is NOT selected and Oneway trip is selected");

            }
            else
            { System.out.println("RadioButton test is failed");}

        }
    }

}
