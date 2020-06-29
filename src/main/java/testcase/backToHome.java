package testcase;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import utils.common;
import utils.operateyaml;

import java.io.FileNotFoundException;

public class backToHome {
    String path;
    WebDriver driver;
    String url;

    @BeforeTest
    public void beforeTest(){
        driver = new ChromeDriver();
    }

    @BeforeClass
    public void beforeClass(){
        url = "http://192.168.0.64:8098";
        driver.get(url);
        path = "yaml\\element\\home.yaml";
        driver.manage().window().maximize();
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }
    @Test
    public void test_home(){
        operateyaml operate = new operateyaml(path);
        common common = new common();
        try{
            WebElement el_home = operate.getdata(driver,"首页");
            el_home.click();
            WebElement el_title = operate.getdata(driver, "首页标题");
            String homeTitle = el_title.getText();
            Assert.assertEquals("首页",homeTitle);
        }
        catch (NoSuchElementException | FileNotFoundException e){
            common.screenShot(driver);
            e.printStackTrace();
        }

    }
}
