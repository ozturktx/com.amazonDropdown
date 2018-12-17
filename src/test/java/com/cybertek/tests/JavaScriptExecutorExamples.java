package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class JavaScriptExecutorExamples {

    @Test
    public void alerts()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        String url = "https://the-internet.herokuapp.com/dynamic_controls";
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
//class enables executing js command
        JavascriptExecutor js=(JavascriptExecutor)driver;
        // takes a string as a parameter and executes it
        js.executeScript("alert('WARNING: some bad things are happening')");
    }

    @Test
    public void scroll(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        JavascriptExecutor js=(JavascriptExecutor)driver;

        String url = "https:www.amazon.com";
        driver.get(url);
        WebElement element=driver.findElement(By.xpath("//*[.='Get to Know Us']"));
        js.executeScript("arguments[0].scrollIntoView(true)",element);

    }
}
