package utils;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class retryListener implements IAnnotationTransformer {
    public void transform(ITestAnnotation iTestAnnotation, Class aClass, Constructor constructor, Method method) {

        IRetryAnalyzer myRetry = iTestAnnotation.getRetryAnalyzer();
        if (myRetry == null) {
            iTestAnnotation.setRetryAnalyzer(retry.class);
        }
    }
}
