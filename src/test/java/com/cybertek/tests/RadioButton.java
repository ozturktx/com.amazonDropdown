package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class RadioButton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        driver.findElement(By.xpath("//div[@aria-posinset='2' and @aria-level='2']")).click();
       // WebElement monday=driver.findElement(By.cssSelector("input[id='gwt-debug-cwCheckBox-Monday-input']"));
        WebElement blue=driver.findElement(By.id("gwt-debug-cwRadioButton-color-blue-input"));
        WebElement red=driver.findElement(By.id("gwt-debug-cwRadioButton-color-red-input"));
       // WebElement thursday=driver.findElement(By.id("gwt-debug-cwCheckBox-Thursday-input"));

        //Select select=new Select(blue);

        if(!blue.isSelected())
        {
            System.out.println("Blue is not selected but  is being selected");
            blue.click();
            System.out.println("Red is not selected");
        }
        if (!red.isSelected())
        {
            System.out.println("Red is not selected");
            red.click();
            System.out.println("Red is being selected");
        }
    }
}
