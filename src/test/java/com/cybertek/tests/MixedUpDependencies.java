package com.cybertek.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class MixedUpDependencies {

    @Test
    public void openBrowser()
    {
        System.out.println("Opening browser");
    }
    @Test(dependsOnMethods = "openBrowser")
    public void login()
    {
        System.out.println("login");
    }
    @Test(dependsOnMethods = "login")
    public void logOut()
    {
        System.out.println("logOut");
    }
    @AfterMethod
    public void cleanUp()
    {
        System.out.println("Closing the browser");
    }
}
