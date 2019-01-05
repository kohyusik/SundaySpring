package com.jason.sample.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

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

    @Before("execution(* com.jason.sample.service.SampleService*.*(..))")
    public void logBefore() {
        log.info("================= log before");
    }
}
