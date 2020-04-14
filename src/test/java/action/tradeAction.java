package action;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.common;
import utils.operateyaml;

import java.io.FileNotFoundException;

public class tradeAction {
    WebDriver driver;
    String path;
    public tradeAction(WebDriver dirver, String path){
        /**
         * @param driver:使用的浏览器驱动；
         * @param url:登录地址；
         * @param path: 访问的yaml文件路径；
         */
        this.driver = dirver;
        this.path = path;
    }

    public void order(){
        operateyaml operate = new operateyaml(path);
        common common = new common();
        try {
            WebElement tradeManage = operate.getdata(driver,"");
            System.out.println(String.format("获取到元素文字为：%s",tradeManage.getText()));
            tradeManage.click();
            WebElement tradeOrder = operate.getdata(driver,"");
            System.out.println(String.format("获取到元素文字为：%s",tradeOrder.getText()));
            tradeOrder.click();
        }
        catch (NoSuchElementException | FileNotFoundException e){
            common.screenShot(driver);
            e.printStackTrace();
        }
    }

}
