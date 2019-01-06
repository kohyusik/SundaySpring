package com.jason.web.service;

import com.jason.web.controller.MemberController;
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
public class MemberServiceTests {

    @Setter(onMethod_ = @Autowired)
    private MemberService memberService;

    @Setter(onMethod_ = @Autowired)
    private MemberController memberController;

    @Test
    public void insertUser() {

        try {
            log.info("truncate : {}", memberService.removeAll());
            memberController.insertUser();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
