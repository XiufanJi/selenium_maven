package com.selenium.demo.utils;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;


//表格处理
public class tableHandler {

//    判断table是否为空
    public boolean getTable( WebDriver driver){
        /**
         * @param driver: 浏览器驱动
         * @return flag: 获取到的表格是否存在数据
         */
        boolean flag = true;
//        List<WebElement> el_tables = driver.findElements(By.cssSelector("tbody.ant-table-tbody"));
        List<WebElement> el_tables = new WebDriverWait(driver,3).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("tbody.ant-table-tbody")));
        if(!el_tables.isEmpty()){
            String table_text = el_tables.get(0).getText();
//            System.out.println(String.format("输出的表格内容为：%s",table_text));
            if (table_text.equals(" ")){
                flag = false;
            }
        }
        else{
            System.out.println("未获取到任何数据！");
        }
        return flag;
    }

//    获取指定行的表格内容
    public <T>T getRow(WebDriver driver, int rowNum){
        /**
         * @param driver: 浏览器驱动
         * @param rowNum: 需要获取数据的表格行号
         * @return String: 查找到的表格行数据
         * 输入0行则默认查询全部
         */
        boolean flag = getTable(driver);
        System.out.println(String.format("获取到的表格是否为空：%s",flag));
        List<T> row = null;
        List<WebElement> el_rows = new WebDriverWait(driver,5).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("tr.ant-table-row")));
        if(flag){
            if(rowNum==0){
                for(WebElement i:el_rows){
                    row.add((T) i.getText());
                }
            }
            else if(rowNum>0){
                row = Collections.singletonList((T) el_rows.get(rowNum - 1).getText());
            }
            else{
                return (T) "输入的行号必须大于或等于0！";
            }
        }
        System.out.println("获取到的表格内容为：%s");
        System.out.println(String.format("%s",row));
        return (T) row;
    }


//    获取表头数据
//    该功能目前没有什么用处
    public void getTableTitle(WebDriver driver){
        List<WebElement> el_ths = new WebDriverWait(driver,5).
                until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("thead.ant-table-thead")));
        if(!el_ths.isEmpty()){
            for(WebElement i:el_ths){
                System.out.println("获取到的表头数据和序号分别为：");
                System.out.println(String.format("%s--%d",i.getText(),el_ths.indexOf(i)));
            }
        }
//        System.out.println(String.format("获取到的键值对显示为：%s",map));
//        return (T) map;
    }

//    获取指定列的数据
    public void getTableTd(WebDriver driver){

    }
}
