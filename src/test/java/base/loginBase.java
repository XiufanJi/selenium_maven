package base;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.common;
import utils.operateyaml;

import java.io.FileNotFoundException;
import java.util.HashMap;

//登录操作
public class loginBase {
    WebDriver driver;
    String url;
    String path;
    public loginBase(WebDriver dirver, String url, String path){
        /**
         * @param driver:使用的浏览器驱动；
         * @param url:登录地址；
         * @param path: 访问的yaml文件路径；
         */
        this.driver = dirver;
        this.url = url;
        this.path = path;
    }
    public void base(){
        operateyaml operate = new operateyaml(path);
        common common = new common();
//        driver.get(url);
//        driver.manage().window().maximize();
//        ChromeOptions options = new ChromeOptions();
//        options.setPageLoadStrategy(PageLoadStrategy.NONE);
        try{
            System.out.println(String.format("当前页面的句柄为：%s",driver.getWindowHandles()));

            WebElement el_user = operate.getdata(driver,"用户名");
            String userContent = operate.getContent("用户名");
            el_user.sendKeys(userContent);

            WebElement el_pwd = operate.getdata(driver,"密码");
            String pwdContent = operate.getContent("密码");
            el_pwd.sendKeys(pwdContent);

            WebElement el_login = operate.getdata(driver,"登录按钮");
            el_login.click();
        }
        catch (NoSuchElementException | FileNotFoundException e){
            common.screenShot(driver);
            e.printStackTrace();
        }
    }
}
