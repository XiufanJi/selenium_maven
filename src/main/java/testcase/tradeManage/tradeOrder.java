package testcase.tradeManage;

import action.tradeAction;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.common;
import utils.singleton;


public class tradeOrder{
    WebDriver driver;
    String path;

    @BeforeClass
    public void startUp(){
        driver = singleton.getDriver("chrome");
        path = "yaml\\element\\tradeManage.yaml";
//        login loginPage=PageFactory.initElements(login.driver,login.class);
//        loginPage.test_login();
    }

    @Test(dependsOnGroups = {"login"})
    public void test_order(){
        driver.getCurrentUrl();
//        System.out.println("页面标题为："+driver.getTitle());
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
