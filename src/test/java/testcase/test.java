package testcase;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.common;
import utils.operateyaml;

import java.util.*;


public class test {
    @Test
    public void case_one(){
        common common = new common();
        WebDriver webDriver = common.browser("Chrome");
        try {
            webDriver.get("http://59.46.145.19:8086");
//        设置页面载入策略
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
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
        finally {
            // 关闭页面，退出进程
            common.screenShot(webDriver);
            webDriver.close();
            webDriver.quit();
        }
    }


    @Test
    public void test_two(){
        common common = new common();
        String path = "D:\\idea-workspace\\selenium_maven\\src\\test\\java\\yaml\\login.yaml";
        operateyaml operate = new operateyaml(path);
        WebDriver webDriver = new ChromeDriver();
        webDriver.get("http://59.46.145.19:8086");
//        设置页面载入策略
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        try{
            HashMap<String, WebElement> map = operate.getdata(webDriver,"用户名");
            WebElement username = map.get("element");
            boolean flag = username.isDisplayed();
            username.sendKeys(operate.getContent("用户名"));
            System.out.println("获取到的元素为："+map.get("element"));
            System.out.println("元素是否在页面展示："+flag);
        }
       catch (Exception e){
           common.screenShot(webDriver);
           e.getMessage();
       }
        finally {
            webDriver.close();
            webDriver.quit();
        }
    }


}
