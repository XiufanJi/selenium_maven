package com.selenium.demo.testcase.tradeManage;

import com.selenium.demo.page.tradePage;
import com.selenium.demo.utils.tableHandler;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.selenium.demo.utils.common;
import com.selenium.demo.base.prepare;

import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class tradeOrder extends prepare {
    WebDriver driver;
    String path_order;

    @Parameters({"tradePage.order"})
    @BeforeClass
    public void startUp(String path){
//        String browser = context.getCurrentXmlTest().getParameter("selenium.browser");
//        driver = singleton.getDriver();
//        path = context.getCurrentXmlTest().getParameter("tradePage.order");
        path_order=path;
    }

    @Test(dependsOnGroups = {"login"},description ="orderPay com.selenium.demo.page")
    public void test_order() throws IOException, InterruptedException {
        driver = super.driver;
        driver.getCurrentUrl();
//        System.out.println("页面标题为："+driver.getTitle());
        tradePage orderBase = new tradePage(driver, path_order);
        common common = new common();
        orderBase.order();
        Thread.sleep(2000);
//        driver.manage().timeouts().pageLoadTimeout(3,TimeUnit.SECONDS);
        tableHandler table = new tableHandler();
//        table.getTable(driver);
        table.getRow(driver,1);
        table.getTableTitle(driver);
        String pageTitle = common.getAlert(driver, path_order, "支付订单页面标题");
        System.out.println(String.format("获取到的页面标题名称为：%s",pageTitle));
        Assert.assertEquals("支付订单查询",pageTitle);
    }
}
