package com.cybertek.tests;

import com.cybertek.Utilities.TestBase;
import org.openqa.selenium.By;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.WebElement;
import sun.awt.windows.WBufferStrategy;

import java.util.List;

public class WebTableHandling extends TestBase {

    public void login(){
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();
    }
@Test
    public void printWholeTable(){
login();
    System.out.println(driver.findElement(By.id("ctl00_MainContent_orderGrid")).getText());
    }
    @Test
    public void printTableHeads()
{
    login();
    List<WebElement>header=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

    for(WebElement h:header) {
        System.out.println(h.getText());
    }
    }

    @Test
    public void findRow(){
        login();
        List<WebElement>allRows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));


        for(WebElement rows:allRows) {
            System.out.println(rows.getText());
        }
        System.out.println("Printing row 3");
        System.out.println(allRows.get(2).getText());
//table[@id='ctl00_MainContent_orderGrid']//tr
    }
    @Test
    public void printTableSize(){
        login();
        List<WebElement>allRows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        System.out.println("Number of rows: "+allRows.size());
        List<WebElement>headers=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        System.out.println("Number of headers/columns: "+headers.size());
        System.out.println("Table size "+headers.size()*allRows.size());

    }

    @Test
    public void printRow2(){
        login();
        List<WebElement>allRows=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr"));
        //System.out.println("Number of rows: "+allRows.size());
        //List<WebElement>headers=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));
        System.out.println("Row 2"+allRows.get(3).getText());
      //  System.out.println("Table size "+headers.size()*allRows.size());

    }


    @Test
    public void printAllCellsInOneRow(){
        login();
        List<WebElement>cells=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[2]//td"));
        for(WebElement rows:cells) {
            System.out.println(rows.getText());
        }
    }
    @Test
    public void printByCoordinates(){
        login();
        WebElement cell=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[3]//td[3]"));
        System.out.println(cell.getText());

        System.out.println(getCell(6,11).getText());
    }

    public WebElement getCell(int row,int column)
    {
        String xpath="//table[@id='ctl00_MainContent_orderGrid']//tr["+row+"]//td["+column+"]";
        return driver.findElement(By.xpath(xpath));
    }

    @Test
    public void printColumn(){
        login();
        List<WebElement>FirstColumn=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td[2]"));
        for(WebElement column:FirstColumn) {
            System.out.println(column.getText());
        }

    }

    //Find a specific name and click on checkbox then delete that record
    @Test
    public void deleteARecord(){
        login();
        // find the td/cell which contaians that name
        //td[.='Mark Smith']
        //go to row that contains that cell from step1
        //td[.='Mark Smith']/.. -- goes to parent
        // in that row, find the cell that contains the checkbox
        //td[.='Mark Smith']/../td[1]/input
        WebElement checkbox=driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]/input"));
        System.out.println(checkbox.isSelected());
        checkbox.click();
        System.out.println(checkbox.isSelected());
        driver.findElement(By.name("ctl00$MainContent$btnDelete")).click();
    }
/*
Verify that name "Mark Smith "exist in the names column
verify tht city 'Whitestone, British' exist in the cities column
 */
@Test
public void verifyNameAndCityTest(){
    login();
    int nameIndex=getColumnIndex("Name");
    System.out.println(nameIndex);
List<WebElement> allNames=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td["+nameIndex+"]"));
boolean found=false;
for (int i = 0; i < allNames.size(); i++) {
        if (allNames.get(i).getText().equals("Mark Smith")) {
            found=true;
            System.out.println("PASSED");
            break;
        }
        System.out.println("found "+allNames.get(i).getText()+"but Looking for Mark Smith");
    }
    Assert.assertTrue(found);


int cityIndex=getColumnIndex("city");
    List<WebElement> allCities=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr//td["+cityIndex+"]"));
    found=false;
    for (int i = 0; i < allCities.size(); i++) {
        if (allCities.get(i).getText().equals("Whitestone, British")) {
            found=true;
            System.out.println("PASSED city");
            break;
        }
        System.out.println("found "+allCities.get(i).getText()+"but Looking for Whitestone, British");
    }
    Assert.assertTrue(found);

}

//gets a column name as a parameters returns the index of the column name
    private int getColumnIndex(String column) {
        List<WebElement>headers=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//th"));

        for (int i = 0; i < headers.size(); i++) {
            if (headers.get(i).getText().equals(column))
            {
                return i+1;
            }
        }
    return 0;
}

}
