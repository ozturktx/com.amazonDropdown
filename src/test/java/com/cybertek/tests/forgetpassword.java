package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.http.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class forgetpassword {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://the-internet.herokuapp.com/forgot_password");
        driver.findElement(By.id("email")).clear();

        driver.findElement(By.id("email")).sendKeys("abc@hotmail.com");
        Thread.sleep(1001);

        //driver.findElement(By.id("email")).sendKeys("abc@hotmail.com"+ Keys.ENTER);
        driver.findElement(By.id("form_submit")).click();
        //driver.sendKeys("somemeail@somemail.com"+ Keys.ENTER);
        //input.sendKeys("somemeail@somemail.com");
        //driver.findElement(By.id("email")).submit();

        String expected="Your e-mail's been sent!";
        String actual=driver.findElement(By.id("content")).getText();

        if(actual.equals(expected))
            System.out.println("Email sent successfully");
        else
            System.out.println("Not expected outcome");



        String URL=driver.getCurrentUrl();
        if(URL.contains("email_sent"))
            System.out.println("URL contains email_sent");
        else
            System.out.println("URL does not contain expected word.");



    }
}
