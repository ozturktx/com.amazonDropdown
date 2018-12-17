package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DropDown {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
String url="https://the-internet.herokuapp.com/dropdown";

        driver.get(url);

        Select list=new Select(driver.findElement(By.id("dropdown")));
String selectedOption=list.getFirstSelectedOption().getText();
        List<WebElement>options=list.getOptions();
        System.out.println("Options.size() "+options.size());
        for(WebElement a:options)
        {
            System.out.println(a.getAttribute("value"));
        }
        list.selectByVisibleText("Option 1");
        System.out.println(list.getFirstSelectedOption().getText()+"selected");

        list.selectByIndex(2);
        System.out.println(list.getFirstSelectedOption().getText()+"selected");
        list.selectByValue("1");
        System.out.println(list.getFirstSelectedOption().getText()+"selected");


    }
}
