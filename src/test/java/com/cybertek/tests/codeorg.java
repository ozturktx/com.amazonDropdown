package com.cybertek.tests;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import com.cybertek.Utilities.TestBase;
import java.util.Random;
public class codeorg extends TestBase {

    @Test
    public void signUp() throws InterruptedException {

        driver.get("https://code.org/");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.linkText("Create an account")).click();

        Select select = new Select(driver.findElement(By.id("user_user_type")));
        select.selectByIndex(1);

        //WebElements

       // fake = new Faker();
        String FakerEmail = fake.internet().emailAddress();


        WebElement user_email = driver.findElement(By.id("user_email"));
        user_email.sendKeys(FakerEmail);
        WebElement user_password = driver.findElement(By.id("user_password"));
        String fakerPassword = fake.internet().password();
        user_password.sendKeys(fakerPassword);
         WebElement password_confirmation = driver.findElement(By.id("user_password_confirmation"));
        password_confirmation.sendKeys(fakerPassword);

        WebElement DisplayName = driver.findElement(By.id("user_name"));
        String fakeUsername = fake.name().firstName() + fake.number().digit();

        DisplayName.sendKeys(fakeUsername);

        Random random = new Random();

        Select selectAge = new Select(driver.findElement(By.id("user_user_age")));
        int rnd = random.nextInt(14)+3;

        System.out.println("rnd = " + rnd);

        selectAge.getOptions().get(rnd).click();
        selectAge.selectByIndex(rnd);
        Select selectGender = new Select(driver.findElement(By.id("user_gender")));
        selectGender.selectByIndex(1);
        selectGender.getOptions().get(1).click();

        Thread.sleep(2000);
        // driver.findElement(By.id("user_terms_of_service_version")).click();
        driver.findElement((By.xpath("//input[@id='user_terms_of_service_version']"))).click();

        Actions action=new Actions(driver);
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();
        action.sendKeys(Keys.PAGE_DOWN).perform();

      //  Thread.sleep(2000);

        driver.findElement(By.id("signup-button")).click();
       // driver.findElement(By.xpath("//*[@id='signup-button']")).click();
       // driver.findElement(By.xpath("//*[@id=\"signup-button\"]")).click();

    }
}