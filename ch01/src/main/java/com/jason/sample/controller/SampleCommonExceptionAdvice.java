package com.jason.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
//@ControllerAdvice
public class SampleCommonExceptionAdvice {

//    @ExceptionHandler(Exception.class)
    public ModelAndView unknown(Exception e) {

        log.info("exception handle : {}", e.toString(), e);
        ModelAndView mav = new ModelAndView();
        mav.setViewName("sample/error/error_common");
        mav.addObject("exception", e);

        return mav;
    }
}
