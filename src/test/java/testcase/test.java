package testcase;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.common;
import utils.operateyaml;

import java.util.*;


public class test {
    WebDriver webDriver;
    common common = new common();
    @BeforeClass
    public void before(){
        webDriver = new ChromeDriver();
        webDriver.get("http://192.168.0.57:8097");
        webDriver.manage().window().maximize();
//        设置页面载入策略
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
    }

    @Test
    public void case_one() throws InterruptedException {

//        common common = new common();
        try {
            WebElement username = webDriver.findElement(By.cssSelector("input[placeholder=\"用户名\"]"));
//            System.out.println("获取到的用户名webElement元素为："+username);
            username.clear();
            username.sendKeys("admin");
            WebElement password = webDriver.findElement(By.cssSelector("input[placeholder=\"密码\"]"));
            password.clear();
            password.sendKeys("123456");
            WebElement login = webDriver.findElement(By.cssSelector(".login-button"));
            login.click();
        } catch (NoSuchElementException e) {
//            报错后进行错误截图保存，并打印报错信息
            common.screenShot(webDriver);
            e.printStackTrace();
        }
//        finally {
//            // 关闭页面，退出进程
//            common.screenShot(webDriver);
//            webDriver.close();
//            webDriver.quit();
//        }
        Thread.sleep(3);
    }


    @Test(dependsOnMethods = {"case_one"})
    public void test_two(){
        String path = "D:\\idea-workspace\\selenium_maven\\src\\test\\java\\yaml\\element\\tradeOrder.yaml";
        try{
            String locator = "div.ant-menu-submenu-title>span>span";
            WebDriverWait wait = new WebDriverWait(webDriver, 10);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.
                    xpath("/html/body/div[1]/div/div/div[1]/div/ul/li[12]/div/span/span")));
            operateyaml operateyaml = new operateyaml(path);
            WebElement trade = operateyaml.getdata(webDriver, "交易管理");
            System.out.println(String.format("获取到的管理元素为:%s",trade.toString()));
            System.out.println(String.format("获取到的文字为:%s",trade.getText()));
            Assert.assertTrue(trade.isDisplayed());
        }
        catch (Exception e){
           common.screenShot(webDriver);
            e.getMessage();
        }
//        finally {
//            webDriver.close();
//            webDriver.quit();
//        }

    }

    @AfterClass
    public void after(){
        webDriver.close();
        webDriver.quit();
    }

}
