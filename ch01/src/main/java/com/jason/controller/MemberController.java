package com.jason.controller;

import com.jason.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-11-16
 * @description :
 */

@Slf4j
@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/time")
    @ResponseBody
    public String time() {
        log.debug("MemberController.time()...");
        return memberService.getTime();
    }

    @RequestMapping("/time2")
    @ResponseBody
    public String time2() {
        log.debug("MemberController.time2()...");
        return memberService.getTime2();
    }

}
