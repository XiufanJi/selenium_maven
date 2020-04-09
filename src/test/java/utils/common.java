package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class common {
    //屏幕截图并按照日期进行分类存放
    public void screenShot(WebDriver driver){
        /**
         * @param driver: 浏览器使用的驱动类型(Firefox、chrome..)
         */
        Date date = new Date();
        SimpleDateFormat formatYear = new SimpleDateFormat("yyyyMMdd");
        SimpleDateFormat formatHour = new SimpleDateFormat("HHmmss");
        //folder和pic使用年月日、时分秒的形式来进行命名
        String folder = formatYear.format(date);
        String pic = formatHour.format(date);
        //新建根目录文件和一级文件夹
        File rootDir = new File("screenShots");
        File parentDir = new File(rootDir+"/"+folder);
        //设置截图的类型，这里为文件形式
        File scrFile =  ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try{
            if(rootDir.exists()){
                if(parentDir.exists()){
                    //复制截图保存在指定位置，并自定义截图的格式
                    FileUtils.copyFile(scrFile, new File(String.format("%s/%s.png", parentDir,pic)));
                }
                else{
                    parentDir.mkdirs();
                    FileUtils.copyFile(scrFile, new File(String.format("%s/%s.png", parentDir,pic)));
                }
            }
            else{
                rootDir.mkdir();
                parentDir.mkdirs();
                FileUtils.copyFile(scrFile, new File(String.format("%s/%s.png", parentDir,pic)));
            }
        }
        catch (IOException e) {
            // TODO Auto-generated catch block
            System.out.println("找不到对应的文件目录！");
            e.printStackTrace();
        }
    }

    //浏览器选择
    public WebDriver browser(String browserName){
        /**
         *
         * @param browserName 浏览器名称：首字母大写
         * @return webDriver
         */
        WebDriver webDriver;
        if ("Firefox".equals(browserName)) {
            webDriver = new FirefoxDriver();
        } else if ("Chrome".equals(browserName)) {
            webDriver = new ChromeDriver();
        } else if ("Safari".equals(browserName)) {
            webDriver = new SafariDriver();
        } else {
            webDriver = new EdgeDriver();
        }
        return webDriver;
    }


    public WebElement findBy(WebDriver driver, String strategy, String locator){
        /**
         *
         * @param driver 浏览器驱动
         * @param strategy 元素定位的方法
         * @param locator 元素定位使用的具体定位方式
         * @return 查找到的单个web元素
         */
        WebElement result;
        try{
            if (strategy.equals("className")){
                result = driver.findElement(By.className(locator));
            }
            else if (strategy.equals("cssSelector")){
                result = driver.findElement(By.cssSelector(locator));
            }
            else if (strategy.equals("id")){
                result = driver.findElement(By.id(locator));
            }
            else if (strategy.equals("name")){
                result = driver.findElement(By.name(locator));
            }
            else if (strategy.equals("linkText")){
                result = driver.findElement(By.linkText(locator));
            }
            else if (strategy.equals("partialLinkText")){
                result = driver.findElement(By.partialLinkText(locator));
            }
            else if (strategy.equals("tagName")){
                result = driver.findElement(By.tagName(locator));
            }
            else{
                result = driver.findElement(By.xpath(locator));
            }
            return result;
        }
        catch (NoSuchElementException e) {
            WebElement flag = null;
            return flag;
        }
    }


    public List<?> findsBy(WebDriver driver, String strategy, String locator){
        /**
         *
         * @param driver 浏览器驱动
         * @param strategy 元素定位的方法
         * @param locator 元素定位使用的具体定位方式
         * @return 查找到的web元素数组
         */
        List<?> results;
        try{
            if (strategy.equals("className")){
                results = driver.findElements(By.className(locator));
            }
            else if (strategy.equals("cssSelector")){
                results = driver.findElements(By.cssSelector(locator));
            }
            else if (strategy.equals("id")){
                results = driver.findElements(By.id(locator));
            }
            else if (strategy.equals("name")){
                results = driver.findElements(By.name(locator));
            }
            else if (strategy.equals("linkText")){
                results = driver.findElements(By.linkText(locator));
            }
            else if (strategy.equals("partialLinkText")){
                results = driver.findElements(By.partialLinkText(locator));
            }
            else if (strategy.equals("tagName")){
                results= driver.findElements(By.tagName(locator));
            }
            else{
                results = driver.findElements(By.xpath(locator));
            }
            return results;
        }
        catch (NoSuchElementException e) {
            List<?> flag = null;
            return flag;
        }
    }

    public String getAlert(WebDriver driver, String path, String desc){
        /**
         * @param driver: 浏览器驱动
         * @param path: yaml文件的路径
         * @param desc: 对应yaml文件中的description描述词
         */
        WebElement el_success = null;
        try{
            operateyaml operate = new operateyaml(path);
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.
                    cssSelector("div.ant-notification-notice-message")));
            HashMap<String, WebElement> success = operate.getdata(driver, desc);
            el_success = success.get("element");
            System.out.println(String.format("获取到的文字信息为：%s",el_success.getText()));
            return el_success.getText();
        }
        catch (Exception e){
            return "未获取到对应的提示信息";
        }
    }


}
