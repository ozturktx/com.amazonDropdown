package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Sports_RadioButton {


    public static void main(String[] args) {


        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwRadioButton";

        driver.get(url);


        WebElement baseball=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Baseball-input"));
        WebElement basketball=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Basketball-input"));
        WebElement football=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Football-input"));
        WebElement hockey=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Hockey-input"));
        WebElement soccer=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-Soccer-input"));
        WebElement water=driver.findElement(By.id("gwt-debug-cwRadioButton-sport-WaterPolo-input"));

        List<WebElement> radios=new ArrayList<WebElement>();
        radios.add(baseball);
        radios.add(basketball);
        radios.add(football);
        radios.add(hockey);
        radios.add(soccer);
        radios.add(water);
        for (int i=0;i<radios.size();i++)
        {
            if(radios.get(i).isSelected())
            {
                System.out.println(radios.get(i).toString() +" is selected");
            }
            else
            {
                System.out.println("Option "+(i+1) +" is not selected");
            }
        }

        Random rdnm=new Random();
        int rd=rdnm.nextInt(radios.size());

        radios.get(rd).click();

        for (int i=0;i<radios.size();i++)
        {
            if(radios.get(i).isSelected())
            {
                System.out.println("Option "+(i+1) +" is selected");
            }
            else
            {
                System.out.println("Option "+(i+1) +" is not selected");
            }
        }
    }
}

