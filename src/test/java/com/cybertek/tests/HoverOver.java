package com.cybertek.tests;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HoverOver extends TestBase {


    @Test
    public void Test() {
        driver.get("https://www.amazon.com/");

       // driver.switchTo().frame("iframeResult");

        WebElement option = driver.findElement(By.id("nav-link-accountList"));
        action.moveToElement(option).perform();
        driver.findElement(By.linkText("Your Hearts")).click();
       Assert.assertTrue(driver.getTitle().contains("Interesting"));
    }

    @Test
    public void Test2() {
        driver.get("https://www.amazon.com/");

        // driver.switchTo().frame("iframeResult");

        WebElement help = driver.findElement(By.xpath("(//a[.='Help'])[2]"));
        action.moveToElement(help).perform();
       // driver.findElement(By.linkText("Your Hearts")).click();
        //Assert.assertTrue(driver.getTitle().contains("Interesting"));
    }
    }
