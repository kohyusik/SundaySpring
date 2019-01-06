package com.jason.sample.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * @author : yusik
 * @date : 2019-01-06
 */

@RunWith(SpringJUnit4ClassRunner.class)
@Slf4j
@ContextConfiguration({
        "file:src/main/webapp/WEB-INF/spring/root-context.xml",
        "file:src/main/webapp/WEB-INF/spring/dispatcher-servlet.xml"
        })
public class SampleServiceTests {

    @Setter(onMethod_ = @Autowired)
    private SampleService sampleService;

    @Test
    public void testClassLoad() {
        log.info("testClass autowired : {}", sampleService);
        log.info("testClass autowired : {}", sampleService.getClass().getName());

    }

    @Test
    public void testDoAdd() {

        int sum = sampleService.doAdd("12", "13");
        assertEquals(25, sum);

    }

    @Test(expected = NumberFormatException.class)
    public void testDoAddError() {

        int sum = sampleService.doAdd("abc", "13");


    }

}
