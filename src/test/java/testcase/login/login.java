package testcase.login;

import action.loginAction;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.common;
import utils.singleTonDriver;


public class login{
    String path;
    WebDriver driver;
    String url;

    @BeforeTest
    public void beforeTest(){
       driver = singleTonDriver.getDriver("chrome");
    }

    @BeforeClass
    public void beforeClass(){
        url = "http://192.168.0.62:8096/";
        driver.get(url);
        path = "D:\\idea-workspace\\selenium_maven\\src\\test\\java\\yaml\\element\\login.yaml";
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }
    @Test(groups = "login")
    public void test_login(){
        loginAction loginBase = new loginAction(driver,url,path);
        common common = new common();
        loginBase.base();
        String text = common.getAlert(driver,path,"欢迎提示语");
        System.out.println(String.format("获取到的提示语为：%s",text));
        Assert.assertEquals(text,"欢迎");
    }
}
