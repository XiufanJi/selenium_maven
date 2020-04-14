package utils;


import org.openqa.selenium.WebDriver;
import testcase.login.login;

public class pageFactory {
    private static WebDriver driver;

    public static void setDriver(WebDriver driver) {
        pageFactory.driver = driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static <T> T getPage(){
        login login = new login();
        Class<?> page = login.getClass();
        return (T) page;
    }

    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<?> page = getPage();
        login newPage = (login) page.newInstance();
        System.out.println(String.format("获取到的类名称为：%s：",page.getPackage().getName()));
    }
}
