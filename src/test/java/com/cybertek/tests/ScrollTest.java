package com.cybertek.tests;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ScrollTest extends TestBase {

    @Test
    public void Test2() {
        driver.get("https://www.youtube.com/");

        //WebElement help = driver.findElement(By.xpath("(//a[.='Help'])[2]"));
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.ARROW_DOWN).perform();
        // driver.findElement(By.linkText("Your Hearts")).click();
        //Assert.assertTrue(driver.getTitle().contains("Interesting"));
    }

}
