package com.cybertek;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Days_CheckBox {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        String url = "http://samples.gwtproject.org/samples/Showcase/Showcase.html#!CwCheckBox";

        driver.get(url);

        WebElement monday =driver.findElement(By.id("gwt-debug-cwCheckBox-Monday-input"));
        WebElement tuesday=driver.findElement(By.id("gwt-debug-cwCheckBox-Tuesday-input"));
        WebElement wednesday=driver.findElement(By.id("gwt-debug-cwCheckBox-Wednesday-input"));
        WebElement thursday=driver.findElement(By.id("gwt-debug-cwCheckBox-Thursday-input"));
        WebElement friday=driver.findElement(By.id("gwt-debug-cwCheckBox-Friday-input"));
        WebElement sat=driver.findElement(By.id("gwt-debug-cwCheckBox-Saturday-input"));
        WebElement sun=driver.findElement(By.id("gwt-debug-cwCheckBox-Sunday-input"));
        List<WebElement> days=new ArrayList<WebElement>();
        days.add(monday);
        days.add(tuesday);
        days.add(wednesday);
        days.add(thursday);
        days.add(friday);
        days.add(sat);
        days.add(sun);
        int countFriday=0;
        Random rdnm=new Random();
        while(countFriday<=3) {

            int rd=rdnm.nextInt(days.size());
            if(days.get(rd).isEnabled()){
            days.get(rd).click();
            }

                if (days.get(rd).isSelected() && rd == 0) {
                    System.out.println("Monday " + " is selected");
                    days.get(rd).click();
                }
                if (days.get(rd).isSelected() && rd == 1) {
                    System.out.println("Tuesday " + " is selected");
                    days.get(rd).click();
                }
                if (days.get(rd).isSelected() && rd == 2) {
                    System.out.println("Wednesday " + " is selected");
                    days.get(rd).click();
                }
                if (days.get(rd).isSelected() && rd == 3) {
                    System.out.println("Thursday " + " is selected");
                    days.get(rd).click();
                }
                if (days.get(rd).isSelected() && rd == 4) {
                    countFriday++;
                    System.out.println("Friday" + " is selected");
                    days.get(rd).click();
                }




        }
    }
}
