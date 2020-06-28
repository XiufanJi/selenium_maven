package testcase.tradeManage;

import action.tradeAction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.common;
import utils.singleTonDriver;

public class tradeOrder {
    WebDriver driver;
    String path;

    @BeforeClass
    public void startUp(){
        driver = singleTonDriver.getDriver("chrome");

        path = "D:\\idea-workspace\\selenium_maven\\src\\test\\java\\yaml\\element\\tradeManage.yaml";
    }

    @Test(dependsOnGroups = {"login"})
    public void test_order(){
        driver.getCurrentUrl();
        tradeAction orderBase = new tradeAction(driver, path);
        common common = new common();
        orderBase.order();
        String pageTitle = common.getAlert(driver, path, "支付订单页面标题");
        System.out.println(String.format("获取到的页面标题名称为：%s",pageTitle));
        Assert.assertEquals("支付订单查询",pageTitle);
    }

    @AfterSuite
    public void afterSuite(){
        driver.close();
        driver.quit();
    }
}
