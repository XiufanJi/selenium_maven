package com.selenium.demo.utils.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class retry implements IRetryAnalyzer {

    private int retryCount = 1;
    private static int maxRetryTimes = 2;

    @Override
    public boolean retry(ITestResult result) {
        if(retryCount<maxRetryTimes){
            retryCount++;
            return true;
        }
        return false;
    }
}
