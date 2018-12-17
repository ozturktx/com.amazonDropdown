package com.cybertek.tests;


import org.apache.http.util.Asserts;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AssetionsDemo {

    @Test
    public void test1(){
    String a="A";
    String b="B";
    Assert.assertEquals(a,b);

}
    @Test
    public void test2(){
        String a="A";
        String b="A";
        Assert.assertEquals(a,b);
   }
    @Test
    public void test3(){
        String a="A";
        String b="AB";
        Assert.assertTrue(b.contains(a));

    }
}
