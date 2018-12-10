package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.xml.ws.WebEndpoint;
import java.util.concurrent.TimeUnit;

public class EtsyExample {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url="https://etsy.com";

        driver.get(url);

        WebElement input=driver.findElement(By.id("search-query"));
        input.sendKeys("decal");
        WebElement submit=driver.findElement(By.xpath("//button[@type='submit' and @value='Search']"));
        submit.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@data-path='link-Black']")).click();


    }
}
