package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HTMLPopUpHandle {

    WebDriver driver;
    @BeforeMethod
    public void setUp()
    {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }
    @Test
    public void handlePopUp() throws InterruptedException {
       driver.findElement(By.id("j_idt691:j_idt692")).click();
       //locate an element on popup window and click it
       driver.findElement(By.xpath("//span[.='No']")).click();

    }
    @Test
    public void oppsTest(){
        driver.get("https://sweetalert.js.org/");
        driver.findElement(By.xpath("(//button[@class='preview'])[2]")).click();
driver.findElement(By.xpath("//button[.='OK']")).click();

    }
    @AfterMethod
    public void tearDown() throws InterruptedException {

        Thread.sleep(4000);
       // driver.quit();
    }
}
