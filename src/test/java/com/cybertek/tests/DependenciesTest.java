package com.cybertek.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependenciesTest {

    @Test
    public void login(){
        System.out.println("login");
        Assert.assertTrue(false);
    }

    @Test(dependsOnMethods = "login")
    public void buySth(){
        System.out.println("buying something");
    }

    @Test
    public void homePage(){
        System.out.println("Home page");
    }
}
