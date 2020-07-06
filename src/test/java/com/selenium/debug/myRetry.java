package com.selenium.debug;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class myRetry implements IRetryAnalyzer {

    private int retryCount = 0;
    private static int maxRetryTimes = 3;

    @Override
    public boolean retry(ITestResult result) {
        if(retryCount<maxRetryTimes){
            retryCount++;
            return true;
        }
        return false;
    }
}
