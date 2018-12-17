package com.cybertek.tests;

import org.testng.annotations.Test;

public class MoreDependencies {

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
}
