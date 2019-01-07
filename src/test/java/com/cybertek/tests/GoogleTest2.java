package com.cybertek.tests;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GoogleTest2 extends TestBase {
    /*Opne google and search for selenium cookbook
    verify title contains search term
    * */

    @Test
    public void test1(){
        driver.get("https://google.com");
        driver.findElement(By.name("q")).sendKeys("Selenium cookbook"+ Keys.ENTER);
        Assert.assertTrue(driver.getTitle().contains("Selenium cookbook"));
    }
}
