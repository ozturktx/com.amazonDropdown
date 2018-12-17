package com.cybertek.tests;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class OrderOfThings {
    @Test(priority = 1)
    public void test1(){
        System.out.println("Test 1");
    }

    @Test(priority = 2)
    public void test2(){
        System.out.println("Test 2");
    }
    @Ignore
    @Test()
    public void test3(){
        System.out.println("Test 3");
    }

}
