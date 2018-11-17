package com.jason.controller;

import com.jason.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-11-16
 * @description :
 */

@Controller
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @RequestMapping("/time")
    @ResponseBody
    public String time() {
        return memberService.getTime();
    }

    @RequestMapping("/time2")
    @ResponseBody
    public String time2() {
        return memberService.getTime2();
    }
    
}
