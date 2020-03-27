package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class base {
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

}
