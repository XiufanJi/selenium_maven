package testcase.tradeManage;

import base.tradeBase;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.common;

public class tradeOrder {
    WebDriver driver;
    String path;

    @BeforeClass
    public void startUp(){
        path = "D:\\idea-workspace\\selenium_maven\\src\\test\\java\\yaml\\element\\tradeManage.yaml";
        driver.getCurrentUrl();
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }

    @Test(dependsOnGroups = {"login"})
    public void test_order(){
        tradeBase orderBase = new tradeBase(driver, path);
        common common = new common();
        orderBase.order();
        String pageTitle = common.getAlert(driver, path, "支付订单页面标题");
        System.out.println(String.format("获取到的页面标题名称为：%s",pageTitle));
        Assert.assertEquals("支付订单查询",pageTitle);
    }
}
