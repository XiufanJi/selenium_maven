package action;

import org.openqa.selenium.*;
import utils.common;
import utils.operateyaml;

import java.io.FileNotFoundException;

//登录操作
public class loginAction {
    WebDriver driver;
    String url;
    String path;
    public loginAction(WebDriver dirver, String url, String path){
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
        try{
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
