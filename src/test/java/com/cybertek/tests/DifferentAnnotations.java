package com.cybertek.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DifferentAnnotations {

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before Method");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @Test
    public void testOne(){
        System.out.println("Test One");
    }

    @Test
    public void testTwo(){
        System.out.println("Test Two");
    }


}
