package testcase.login;

import base.loginBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.common;

import java.io.FileNotFoundException;

public class login {
    WebDriver driver;

    String url;
    String path;

    @BeforeClass
    public void startUp(){
       driver = new ChromeDriver();
       url = "http://192.168.0.57:8097";
       path = "D:\\idea-workspace\\selenium_maven\\src\\test\\java\\yaml\\login.yaml";
    }

    @Test
    public void test_login() throws FileNotFoundException {
        loginBase loginBase = new loginBase(driver,url,path);
        common common = new common();
        loginBase.base();
        String text = common.getAlert(driver,path,"欢迎提示语");
        System.out.println(String.format("获取到的提示语为：%s",text));
        Assert.assertEquals(text,"欢迎");
    }

    @AfterClass
    public void tearDown(){
        driver.close();
        driver.quit();
    }

}
