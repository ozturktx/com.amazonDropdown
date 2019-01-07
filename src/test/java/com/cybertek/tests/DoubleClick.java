package com.cybertek.tests;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClick extends TestBase {

    @Test
    public void doubleClickTest(){
        driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick2");

        driver.switchTo().frame("iframeResult");

        Actions action=new Actions(driver);
        WebElement text=driver.findElement(By.id("demo"));
        action.doubleClick(text).perform();
        Assert.assertTrue(text.getAttribute("style").contains("color: red"));


    }


}
