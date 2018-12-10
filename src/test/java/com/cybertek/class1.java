package com.cybertek;

import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class class1 {

    public static void main(String[] args) {
        System.out.println("Prinitng");


        Faker faker = new Faker();
        String name = faker.name().fullName();
        String address=faker.address().fullAddress();

        System.out.println(name+address+faker.university().name());

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://see.stanford.edu/Course/CS223A");
        driver.findElement(By.xpath("//h2[contains(text(),'Assignments')]")).click();

        driver.findElement(By.xpath("//*[@id=\"page\"]/div[2]/div/div/nav/ul[2]/li[1]/a")).click();
        ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.findElement(By.id("QR~QID1~2")).click();
        driver.findElement(By.id("QID3-1-label")).click();
        driver.findElement(By.id("QR~QID4~1")).click();
        driver.findElement(By.id("QR~QID4~6~TEXT")).sendKeys("61");
        driver.findElement(By.id("QR~QID10~1~3")).click();
        driver.findElement(By.id("QR~QID11")).sendKeys(faker.shakespeare().asYouLikeItQuote());
    }
}
