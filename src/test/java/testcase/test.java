package testcase;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import utils.base;



public class test {
    @Test
    public void case_one(){
        base base = new base();
        WebDriver webDriver = base.browser("Chrome");
        try {
            webDriver.get("http://59.46.145.19:8086");
//        设置页面载入策略
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.NONE);
            WebElement username = webDriver.findElement(By.cssSelector("input[placeholder=\"用户名\"]"));
            username.clear();
            username.sendKeys("admin");
            WebElement password = webDriver.findElement(By.cssSelector("input[placeholder=\"密码\"]"));
            password.clear();
            password.sendKeys("123456");
            WebElement login = webDriver.findElement(By.cssSelector(".login-button"));
            login.click();
        } catch (NoSuchElementException e) {
//            报错后进行错误截图保存，并打印报错信息
            base.screenShot(webDriver);
            e.printStackTrace();
        }
        finally {
            // 关闭页面，退出进程
            base.screenShot(webDriver);
            webDriver.close();
            webDriver.quit();
        }
    }
}
