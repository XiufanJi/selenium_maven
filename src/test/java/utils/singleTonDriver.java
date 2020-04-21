package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

//单例模式实例化driver
public class singleTonDriver {
    private static WebDriver driver = null;
    public static WebDriver getDriver(String browser){
        if(driver == null){
            switch (browser){
                case "firefox":
                    driver = new FirefoxDriver();
                case "chrome":
                    driver = new ChromeDriver();
                case "safari":
                    driver = new SafariDriver();
                default:
                    driver = new InternetExplorerDriver();
            }
        }
        return driver;
    }
}
