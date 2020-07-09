package com.selenium.demo.page;

import org.openqa.selenium.*;
import com.selenium.demo.utils.common;
import com.selenium.demo.utils.yaml.operateyaml;

import java.io.FileNotFoundException;
import java.io.IOException;

//登录操作
public class loginPage {
    WebDriver driver;
    String path;
    public loginPage(WebDriver driver, String path){
        /**
         * @param driver:使用的浏览器驱动；
         * @param url:登录地址；
         * @param path: 访问的yaml文件路径；
         */
        this.driver = driver;
        this.path = path;
    }
//    进行页面登录操作：包括输入用户名、密码，点击登录按钮
    public void base() throws IOException {
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
