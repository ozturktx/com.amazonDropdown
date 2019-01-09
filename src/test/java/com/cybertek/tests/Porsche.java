package com.cybertek.tests;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.xml.ws.WebEndpoint;
import java.util.ArrayList;

public class Porsche extends TestBase {

    public int equipmentPrice()
    {
        int  EquipmentPrice=Integer.parseInt(
                driver.findElement(By.xpath("(//div[@class='ccaPrice'])[2]")).getAttribute("innerHTML")
                        .replace("$","")
                        .replace(",",""));
        return EquipmentPrice;
    }

    public int totalPrice()
    {
        int TotalPrice=Integer.parseInt(
                driver.findElement(By.xpath("(//div[@class='ccaPrice'])[4]")).getAttribute("innerHTML")
                        .replace("$","")
                        .replace(",",""));

        return  TotalPrice;
    }
    public int handlingPrice()
    {
        int HandlingPrice=Integer.parseInt(
                driver.findElement(By.xpath("(//div[@class='ccaPrice'])[3]")).getAttribute("innerHTML")
                        .replace("$","")
                        .replace(",",""));

        return HandlingPrice;
    }
    public int AddedPrices()
    {
        int addedPrice=handlingPrice()+equipmentPrice()+baseprice();

        return  addedPrice;
    }
    public int baseprice()
    {
        int baseprice=Integer.parseInt(driver.findElement(By.xpath("(//div[@class='ccaPrice'])[1]")).getAttribute("innerHTML")
                .replace("$","")
                .replace(",",""));

        return  baseprice;
    }
    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.porsche.com/usa/modelstart/");
        driver.findElement(By.linkText("718")).click();
        //driver.findElement(By.xpath("//*[@title='Porsche - 718']")).click();
        String CaymanSprice=driver.findElement(By.xpath("//div[@id='m982130']//div[@class='m-14-model-price']")).getText();
        CaymanSprice=CaymanSprice.substring(5,13).replace(",","").replace("$","").trim();
        int priceOnMainPage=Integer.parseInt(CaymanSprice);

        driver.findElement(By.id("m982130")).click();
       // String winHandleBefore = driver.getWindowHandle();
       ArrayList<String> newTab = new ArrayList<String>(driver.getWindowHandles());
       // System.out.println(newTab.size());
       driver.switchTo().window(newTab.get(1));

        Assert.assertEquals(priceOnMainPage,baseprice());

        Assert.assertEquals(equipmentPrice(),0);
        Assert.assertEquals(totalPrice(),AddedPrices());

        driver.findElement(By.id("s_exterieur_x_FJ5")).click();
        int priceForBlue=Integer.parseInt(driver.findElement(By.id("s_exterieur_x_FJ5")).getAttribute("data-price")
                .replace("$","")
                .replace(",",""));

        Assert.assertEquals(equipmentPrice(),priceForBlue);
        Assert.assertEquals(totalPrice(),AddedPrices());
        // Step 12
        Actions action=new Actions(driver);


       // action.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.id("s_exterieur_x_IRZ"))).build().perform();
        Thread.sleep(2000);
        //action.sendKeys(Keys.PAGE_DOWN).perform();
        //action.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement wheel=driver.findElement(By.id("s_exterieur_x_MXRD"));
        int priceForSportWheels=Integer.parseInt(wheel.getAttribute("data-price")
                .replace("$","")
                .replace(",",""));


wheel.click();

        Thread.sleep(2000);
Assert.assertEquals(equipmentPrice(),(priceForSportWheels+priceForBlue),"Equipment price error");
Assert.assertEquals(totalPrice(),AddedPrices(),"Error");

        action.moveToElement(driver.findElement(By.xpath("(//div[@id='seats_73']//div[@class='pBox'])[2]"))).build().perform();
        Thread.sleep(2000);
       driver.findElement(By.id("s_interieur_x_PP06")).click();
        int priceForSeat=Integer.parseInt(driver.findElement(By.xpath("(//div[@id='seats_73']//div[@class='pBox'])[2]")).getText()
                .replace("$","")
                .replace(",",""));
        System.out.println(priceForSeat);
        Assert.assertEquals(equipmentPrice(),(priceForSportWheels+priceForBlue+priceForSeat),"Equipment price error");
        Assert.assertEquals(totalPrice(),AddedPrices(),"TotalPriceError");

        action.moveToElement(driver.findElement(By.id("s_individual_x_IAU"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.id("IIC_wrapper")).click();
        driver.findElement(By.id("vs_table_IIC_x_PEKH_x_c04_PEKH_x_shorttext")).click();
        int priceForInterior=Integer.parseInt(driver.findElement(By.xpath("//div[@id='vs_table_IIC_x_PEKH']//div[@class='pBox']")).getText()
                .replace("$","")
                .replace(",",""));
        Assert.assertEquals(equipmentPrice(),(priceForSportWheels+priceForBlue+priceForSeat+priceForInterior),"Equipment price error");
        Assert.assertEquals(totalPrice(),AddedPrices(),"TotalPriceError");

        action.moveToElement(driver.findElement(By.id("individual_sHeadline"))).build().perform();
        Thread.sleep(2000);
        driver.findElement(By.id("IMG_wrapper")).click();
        driver.findElement(By.id("vs_table_IMG_x_M250_x_c11_M250")).click();
       // Thread.sleep(3000);
        int priceFor7speed=Integer.parseInt(driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M250']//div[@class='pBox']")).getText()
                .replace("$","")
                .replace(",",""));
        action.moveToElement(driver.findElement(By.id("s_individual_x_ILS"))).build().perform();

        driver.findElement(By.id("vs_table_IMG_x_M450_x_c81_M450")).click();

        int priceForBreak=Integer.parseInt(driver.findElement(By.xpath("//div[@id='vs_table_IMG_x_M450']//div[@class='pBox']")).getText()
                .replace("$","")
                .replace(",",""));


        Assert.assertEquals(equipmentPrice(),(priceForBreak+priceFor7speed+priceForSportWheels+priceForBlue+priceForSeat+priceForInterior),"Equipment price error");
        Assert.assertEquals(totalPrice(),AddedPrices(),"TotalPriceError");

    }
}
