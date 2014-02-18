package com.pvt.jd2.project.front.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Oleg
 * Date: 15.02.14
 * Time: 20:34
 */
@Aspect
@Component
public class ServiceAopLogger {

    private static final Logger logger = LoggerFactory.getLogger(ServiceAopLogger.class);

    @Pointcut("execution(public * com.pvt.jd2.project.back.hibernate.service.*Impl.*(..))")
    private void allMethodsInServicePackage(){}

    @AfterThrowing(pointcut = "allMethodsInServicePackage()", throwing = "exception")
    public void logThrownException(JoinPoint pointcut, Exception exception){
        if (logger.isErrorEnabled()){
            logger.error(String.format("Exception in %s.%s",
                    pointcut.getSignature().getDeclaringTypeName(),
                    pointcut.getSignature().getName()),
                    exception);
        }
    }

    @Before(value = "allMethodsInServicePackage()")
    public void beforeMethodCall(JoinPoint point){
        if (logger.isInfoEnabled()){
            logger.info(String.format("%s.%s - %s",
                    point.getSignature().getDeclaringTypeName(),
                    point.getSignature().getName(),
                    Arrays.toString(point.getArgs())));
        }
    }

    @AfterReturning(value = "allMethodsInServicePackage()", returning = "result")
    public void afterMethodCall(JoinPoint point, Object result){
        if (logger.isInfoEnabled()){
            logger.info(String.format("%s.%s - %s",
                    point.getSignature().getDeclaringTypeName(),
                    point.getSignature().getName(),
                    result));
        }
    }

}
