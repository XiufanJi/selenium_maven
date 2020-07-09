package com.selenium.demo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


//单例模式实例化driver
//现在因为其他的测试用例需要继承prepare类并使用类中的driver，所以暂时先将getDriver中的参数去掉，
// 因为加上的话，prepare中driver初始化会有问题
//后续考虑dataProvider的方式看是否能解决
public class singleton {
    private static volatile WebDriver driver = null;
    private singleton(){}
    public static WebDriver getDriver(){
        if (driver==null){
//            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","webdriver\\chrome_83\\chromedriver.exe");
                driver = new ChromeDriver();
//            }
//            else{
//                System.setProperty("webdriver.firefox.bin","webdriver\\firefox_77\\geckodriver.exe");
//                driver = new FirefoxDriver();
//            }
        }
        return driver;
    }

}