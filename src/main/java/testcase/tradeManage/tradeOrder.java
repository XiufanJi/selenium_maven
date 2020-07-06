package testcase.tradeManage;

import action.tradeAction;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.common;
import utils.retry;
import utils.singleton;


@Test(retryAnalyzer = retry.class)
public class tradeOrder{
    WebDriver driver;
    String path_order;

    @Parameters({"selenium.browser","tradePage.order"})
    @BeforeClass
    public void startUp(String browser, String path){
//        String browser = context.getCurrentXmlTest().getParameter("selenium.browser");
        driver = singleton.getDriver(browser);
//        path = context.getCurrentXmlTest().getParameter("tradePage.order");
        path_order=path;
    }

    @Test(dependsOnGroups = {"login"},description ="orderPay page")
    public void test_order(){
        driver.getCurrentUrl();
//        System.out.println("页面标题为："+driver.getTitle());
        tradeAction orderBase = new tradeAction(driver, path_order);
        common common = new common();
        orderBase.order();
        String pageTitle = common.getAlert(driver, path_order, "支付订单页面标题");
        System.out.println(String.format("获取到的页面标题名称为：%s",pageTitle));
        Assert.assertEquals("支付订单查询",pageTitle);
    }

    @AfterSuite
    public void afterSuite(){
       driver.close();
       driver.quit();
    }
}
