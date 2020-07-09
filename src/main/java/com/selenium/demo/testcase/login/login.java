package com.selenium.demo.testcase.login;

import com.selenium.demo.page.loginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import com.selenium.demo.utils.common;
import com.selenium.demo.base.prepare;
import java.io.IOException;



public class login extends prepare {
    String path;
    WebDriver driver;

    @BeforeClass
    public void beforeClass(ITestContext context){
//        获取配置的参数
//        String browser = context.getCurrentXmlTest().getParameter("selenium.browser");
//        driver = singleton.getDriver();
//        url = context.getCurrentXmlTest().getParameter("selenium.url");
//        driver.get(url);
        path = context.getCurrentXmlTest().getParameter("loginPage.login");
//        driver.manage().window().maximize();
//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }


    @Test(groups = {"login"},description = "log in web com.selenium.demo.page")
    public void test_login() throws IOException {
        driver = super.driver;
        loginPage loginBase = new loginPage(driver,path);
        common common = new common();
        loginBase.base();
        String text = common.getAlert(driver,path,"欢迎提示语");
        System.out.println(String.format("获取到的提示语为：%s",text));
        Assert.assertEquals(text,"欢迎");
    }

//    @AfterClass
//    public void afterClass() throws InterruptedException {
//        Thread.sleep(2000);
//    }
}
