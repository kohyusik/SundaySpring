package com.jason.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : kohyusik
 * @version : 1.0
 * @date : 2018-11-16
 * @description :
 */

@Controller
public class IndexController {
    
    @RequestMapping("/index")
    public String index() {
        return "index";
    }
    
}
