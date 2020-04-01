package utils;
import org.yaml.snakeyaml.Yaml;

import java.io.File;

public class operateyaml {
    private  String path;
    private  String mode;

    public operateyaml(String path, String mode){
        this.mode = mode;
        this.path = path;
    }

//    //获取全部的数据
//    public <T> T loadData(){
//        Yaml yaml = new Yaml();
//        String data = yaml.load(path);
//        return data;
//    }

//    //获取元素个数
//    public int getNum(){
//        int num = loadData();
//        return ;
//    }
}
