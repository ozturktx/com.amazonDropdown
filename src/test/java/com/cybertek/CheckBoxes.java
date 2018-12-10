package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class CheckBoxes {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox");
        WebElement monday=driver.findElement(By.cssSelector("input[id='gwt-debug-cwCheckBox-Monday-input']"));
        WebElement tuesday=driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));
        WebElement wednesday=driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-input"));
        WebElement thursday=driver.findElement(By.id("gwt-debug-cwCheckBox-Thursday-input"));
        WebElement friday=driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-input"));
        WebElement saturday=driver.findElement(By.id("gwt-debug-cwCheckBox-Saturday-input"));
        WebElement sunday=driver.findElement(By.id("gwt-debug-cwCheckBox-Sunday-input"));

        while (!friday.isSelected()) {
            if (!monday.isSelected()) {
                System.out.println("Monday is not selected");
                System.out.println("Monday is being selecting");
                monday.click();
                System.out.println("DAy is selected "+monday.isSelected());
            }

            if (!tuesday.isSelected()) {
                System.out.println("Tuesday is not selected");
                System.out.println("Day is being selecting");
                tuesday.click();
                System.out.println("DAy is selected " + tuesday.isSelected());
            }
            if (!wednesday.isSelected()) {
                System.out.println("Wednesady is not selected");
                System.out.println("Day is being selecting");
                wednesday.click();
                System.out.println("DAy is selected " + wednesday.isSelected());
            }
            if (!thursday.isSelected()) {
                System.out.println("Thursday is not selected");
                System.out.println("Day is being selecting");
                thursday.click();
                System.out.println("DAy is selected "+thursday.isSelected());
            }

            if (!friday.isSelected()) {
                System.out.println("Friday is not selected");
                System.out.println("Day is being selecting");
                friday.click();
                System.out.println("Friday is selected "+friday.isSelected());
            }

        }
        driver.close();
    }

}
