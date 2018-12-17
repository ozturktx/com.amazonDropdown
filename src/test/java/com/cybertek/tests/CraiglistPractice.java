package com.cybertek.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import javax.sound.midi.Soundbank;
import java.sql.Driver;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class CraiglistPractice {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();

        driver.get("https://houston.craigslist.org/");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//span[.='motorcycles']")).click();

        WebElement mile=driver.findElement(By.name("search_distance"));
        WebElement zip=driver.findElement(By.name("postal"));
        WebElement min_price=driver.findElement(By.name("min_price"));
        WebElement model=driver.findElement(By.name("auto_make_model"));


        mile.sendKeys("30");
        zip.sendKeys("77498");
        min_price.sendKeys("1500");
        model.clear();
        model.sendKeys("harley davidson 1200");
        Thread.sleep(1000);
        model.clear();
        model.sendKeys("harley davidson 1200",Keys.ENTER);
       // driver.findElement(By.xpath("//*[@id=\"searchform\"]/div[2]/div/div[9]/button")).click();

        WebElement count=driver.findElement(By.xpath("//span[@class='totalcount']"));
        String tCount=count.getText();
        System.out.println(tCount);

        int countt=Integer.parseInt(tCount);

        ArrayList<WebElement> prices=new ArrayList<>(driver.findElements(By.xpath("//a[@class='result-image gallery']//span[@class='result-price']")));
        System.out.println(prices.size());
        int min=Integer.parseInt(prices.get(0).getText().substring(1));

        // finds the cheapest one and prints the all prices
        for(WebElement a:prices)
        {
            System.out.println(a.getText());
            if(Integer.parseInt(a.getText().substring(1))<min)
                min=Integer.parseInt(a.getText().substring(1));
        }
        System.out.println("min $"+min);

        // click the cheapest one
        for(WebElement a:prices)
        {
            if(a.getText().equals("$"+min)) {
            a.click();
            break;
            }
        }
        //prices.get(0).click();


    }
}
