package com.selenium.demo.base;

import com.selenium.demo.utils.singleton;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class prepare {
    public  WebDriver driver = singleton.getDriver();

//    这里使用的driver现在是固定写死的哪种浏览器，因为在测试用例中使用到driver,暂时没想到好的办法
    @BeforeSuite
    public void setUp(ITestContext context){
        String url = context.getCurrentXmlTest().getParameter("selenium.url");
        driver.get(url);
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
        driver.quit();
    }
}
