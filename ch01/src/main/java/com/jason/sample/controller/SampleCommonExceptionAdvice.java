package com.jason.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@ControllerAdvice
public class SampleCommonExceptionAdvice {

    /* common메소드는  Exception 타입으로 처리하는 모든 예외를 처리하도록 설정 */
    @ExceptionHandler(Exception.class)
    public ModelAndView unknown(Exception e) {

        log.info(e.toString());

        ModelAndView mav = new ModelAndView();
        mav.setViewName("sample/error/error_common");
        mav.addObject("exception", e);  //예외를 뷰에 던져서 주자.

        return mav;
    }
}
