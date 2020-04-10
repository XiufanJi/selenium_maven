package testcase.login;

import base.loginBase;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.common;


public class login {
    WebDriver driver;
    String url;
    String path;

    @BeforeSuite
    public void setUp(){
        driver = new ChromeDriver();
        url = "http://192.168.0.57:8097";
    }

    @BeforeClass
    public void startUp(){
        path = "D:\\idea-workspace\\selenium_maven\\src\\test\\java\\yaml\\element\\login.yaml";
        driver.get(url);
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }

    @Test(groups = "login")
    public void test_login(){
        loginBase loginBase = new loginBase(driver,url,path);
        common common = new common();
        loginBase.base();
        String text = common.getAlert(driver,path,"欢迎提示语");
        System.out.println(String.format("获取到的提示语为：%s",text));
        Assert.assertEquals(text,"欢迎");
    }

    @AfterSuite
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
