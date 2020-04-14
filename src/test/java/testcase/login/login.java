package testcase.login;

import action.loginAction;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;
import utils.common;


public class login{
    String path;
    WebDriver driver;
    String url;

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    @BeforeTest
    public void beforeTest(){
        setDriver(new ChromeDriver());
        driver = getDriver();
    }

    @BeforeClass
    public void beforeClass(){
        url = "http://192.168.0.57:8097";
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
