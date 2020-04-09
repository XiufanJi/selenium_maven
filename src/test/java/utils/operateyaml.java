package utils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;


public class operateyaml {
    /**
     * @param path:yaml文件路径
     */
    private  String path;

    public operateyaml(String path){
        this.path = path;
    }

    //获取yaml文件全部的数据
    public <T>T  load() throws FileNotFoundException {
        Yaml yaml = new Yaml();
        T data;
        File file = new File(path);
        data = yaml.load(new FileInputStream(file));
        return data;
    }

    //获取yaml文件中的content字段
    public String getContent(String desc) throws FileNotFoundException {
        ArrayList<LinkedHashMap> loadData = load();
        String content = "";
        for (LinkedHashMap x: loadData){
            if(x.get("description").equals(desc)){
                content = x.get("content").toString();
            }
        }
        return content;
    }

    //根据输入的描述字段获进行元素的查找并进行返回
    public <T> T getdata(WebDriver diver, String desc) throws FileNotFoundException {
        /**
         * @param desc:对应yaml文件中的描述词description
         * @param driver:对应使用的浏览器驱动
         * @return 泛型类的HashMap
         */
        //load返回的数据类型为ArrayList类型，里面子集则是LinkedHashMap类型的
        common common = new common();
        WebElement element = null;
        List<?> elements = null;
        HashMap<String ,T> map = new HashMap<String , T>();
        ArrayList<LinkedHashMap> loadData = load();
        for (LinkedHashMap x: loadData) {
            if(x.get("description").equals(desc)){
                if(x.get("returnNum").equals("single")){
                        element = common.findBy(diver, x.get("Strategy").toString(),
                                x.get("locator").toString());
                }
                else{
                        elements = common.findsBy(diver,x.get("Strategy").toString(),
                                x.get("locator").toString());
                }
            }
        }
        map.put("element",(T) element);
        map.put("elements",(T) elements);
        return (T) map;
    }


}