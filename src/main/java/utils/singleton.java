package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

//单例模式实例化driver
public class singleton {
    private static volatile WebDriver driver = null;
    private singleton(){}
    public static WebDriver getDriver(String browser){
        if (driver==null){
            if(browser.equalsIgnoreCase("chrome")){
                System.setProperty("webdriver.chrome.driver","webdriver\\chrome_83\\chromedriver.exe");
                driver = new ChromeDriver();
            }
            else{
                System.setProperty("webdriver.firefox.bin","webdriver\\firefox_77\\geckodriver.exe");
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}