package com.cybertek.tests;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DragandDrop extends TestBase {


    @Test
    public void Test1() {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");

        // driver.switchTo().frame("iframeResult");

        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement dropable = driver.findElement(By.id("droptarget"));
        action.dragAndDrop(draggable,dropable).perform();

    //    action.clickAndHold(draggable).moveToElement(dropable).release().perform();

    }
}
