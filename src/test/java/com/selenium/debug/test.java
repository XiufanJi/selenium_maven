package com.selenium.debug;


import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class test {
    String str="";
    public test(String test){
        this.str=test;
    }

    @Test(retryAnalyzer = myRetry.class)
    public void one(){
        System.out.println(String.format("this is case one, %s",str));
//        Assert.assertEquals(str,"the real world");
    }

    @Ignore
    @Test
    public void two(){
        System.out.println(String.format("this is case two, %s",str));
    }
}
