package org.demoweatherapi.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import java.util.logging.Logger;

@Component
@Aspect
public class MyLoggingAspect {

    private static Logger logger = Logger.getAnonymousLogger();

    @Around("execution(public void addCurrentWeatherInDB())")
    public Object aroundAddWeatherInDBMethodAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
        logger = Logger.getLogger(methodSignature.getName());
        logger.info("Start method");
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger = Logger.getLogger(methodSignature.getName());
        logger.info("Successfully adding an object to database");

        return targetMethodResult;

    }

    @Around("execution(* org.demoweatherapi.controller.MyRESTController.*(..))")
    public Object aroundAllControllerMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
        logger = Logger.getLogger(methodSignature.getName());
        logger.info("Start method");
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger = Logger.getLogger(methodSignature.getName());
        logger.info("End method");

        return targetMethodResult;
    }

    @Around("execution(* org.demoweatherapi.communicate_third_API.Communicate.*(..))")
    public Object aroundAllCommunicateMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
        logger = Logger.getLogger(methodSignature.getName());
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger.info("JSON from WeatherAPI.com received successfully");

        return targetMethodResult;
    }

    @Around("execution(* org.demoweatherapi.parse.Parsing.*(..))")
    public Object aroundAllParseMethodsAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        MethodSignature methodSignature =(MethodSignature) proceedingJoinPoint.getSignature();
        logger = Logger.getLogger(methodSignature.getName());
        Object targetMethodResult = proceedingJoinPoint.proceed();
        logger.info("Conversion of JSON file to object was successful");

        return targetMethodResult;
    }

}
