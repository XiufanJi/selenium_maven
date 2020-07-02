package testcase.login;

import action.loginAction;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.common;
import utils.singleton;


public class login{
    String path;
    WebDriver driver;
    String url;

    @BeforeClass
    public void beforeClass(){
        driver = singleton.getDriver("chrome");
        url = "http://192.168.0.64:8098/";
        driver.get(url);
        path = "yaml\\element\\login.yaml";
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
