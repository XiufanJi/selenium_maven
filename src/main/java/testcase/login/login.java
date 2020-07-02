package testcase.login;

import action.loginAction;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;
import utils.common;
import utils.singleton;


public class login{
    String path;
    WebDriver driver;
    String url;

    @BeforeClass
    public void beforeClass(ITestContext context){
//        获取配置的参数
        String browser = context.getCurrentXmlTest().getParameter("selenium.browser");
        driver = singleton.getDriver(browser);
        url = context.getCurrentXmlTest().getParameter("selenium.url");
        driver.get(url);
        path = context.getCurrentXmlTest().getParameter("loginPage.login");
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }
    @Test(groups = "login",description = "log in web page")
    public void test_login(){
        loginAction loginBase = new loginAction(driver,url,path);
        common common = new common();
        loginBase.base();
        String text = common.getAlert(driver,path,"欢迎提示语");
        System.out.println(String.format("获取到的提示语为：%s",text));
        Assert.assertEquals(text,"欢迎");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
    }
}
