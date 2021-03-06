package com.selenium.demo.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.selenium.demo.utils.common;
import com.selenium.demo.utils.yaml.operateyaml;

import java.io.FileNotFoundException;
import java.io.IOException;

public class tradePage {
    WebDriver driver;
    String path;
    public tradePage(WebDriver dirver, String path){
        /**
         * @param driver:使用的浏览器驱动；
         * @param url:登录地址；
         * @param path: 访问的yaml文件路径；
         */
        this.driver = dirver;
        this.path = path;
    }

    public void order() throws IOException {
        operateyaml operate = new operateyaml(path);
        common common = new common();
        try {
            WebElement tradeManage = operate.getdata(driver,"支付订单管理");
//            System.out.println(String.format("获取到元素文字为：%s",tradeManage.getText()));
            tradeManage.click();
            WebElement tradeOrder = operate.getdata(driver,"支付订单查询");
//            System.out.println(String.format("获取到元素文字为：%s",tradeOrder.getText()));
            tradeOrder.click();
        }
        catch (FileNotFoundException  e){
            common.screenShot(driver);
//            throw new NoSuchMethodException("");
            e.printStackTrace();
        }
    }

}
