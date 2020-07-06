package com.selenium.debug;

import org.testng.annotations.Factory;

public class testFactory {
    @Factory
    public Object[] test(){
        Object[] result = new Object[1];
        for (int i = 0; i < 1; i++) {
            result[i] = new test("hello_world");
        }
        return result;
    }
}
