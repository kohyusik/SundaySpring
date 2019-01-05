package com.jason.sample.controller;

import com.jason.sample.service.SampleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/aop")
public class TestAopController {

    private final SampleService sampleService;

    public TestAopController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @GetMapping("/doAdd")
    @ResponseBody
    public Integer doAdd(String s1, String s2) {

        return sampleService.doAdd(s1, s2);
    }

}
