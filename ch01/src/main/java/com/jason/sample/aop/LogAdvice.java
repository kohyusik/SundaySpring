package com.jason.sample.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author : yusik
 * @date : 2019-01-06
 */

@Aspect
@Slf4j
@Component
public class LogAdvice {

    @PostConstruct
    public void init() {
        log.info("Bean created : LogAdvice");
    }

    @Pointcut("execution(* com.jason.sample.service.SampleService*.*(..))")
    public void sampleServicePointcut() {
    }

    @Pointcut("@annotation(ConvertTarget)")
    public void annoPointcut() {
    }

    @Pointcut("within(com.jason.*)")
    private void allPointcut() {
    }

    @Before("sampleServicePointcut()")
    public void logBefore() {
        log.info("================= before");
    }

    @Before(value = "execution(* com.jason.sample.service.SampleService*.*(String, String)) && args(str1, str2)", argNames = "str1,str2")
    public void logBeforeWithParam(String str1, String str2) {
        log.info("================= before with param : {},{}", str1, str2);
    }

    @After("execution(* com.jason.sample.service.SampleService*.*(..))")
    public void logAfter() {
        log.info("================= after");
    }

    @AfterReturning(pointcut = "execution(* com.jason.sample.service.SampleService*.*(..))", returning = "returnVal")
    public void logAfterReturning(String returnVal) {
        log.info("================= after returning : {}", returnVal);
    }

    @AfterThrowing(
            pointcut = "execution(* com.jason.sample.service.SampleService*.*(..))",
            throwing = "exception")
    public void logAfterThrowing(Exception exception) {
        log.info("================= throwing : {}", exception);
    }

    @Around(value = "execution(* com.jason.sample.service.SampleService*.*(..))")
    public Object around(ProceedingJoinPoint joinPoint) {

        log.info("================= around before proceed");

        log.info("target : {}", joinPoint.getTarget());
        log.info("args : {}", Arrays.toString(joinPoint.getArgs()));

        Object returnVal = null;
        try {
            returnVal = joinPoint.proceed();
        } catch (Throwable throwable) {
            log.error(throwable.getMessage());
        }

        log.info("================= around after proceed : {}", returnVal);

        return returnVal;
    }
}
