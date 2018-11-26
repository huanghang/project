package com.education.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/home")
public class HomeController {

    @ResponseBody
    @RequestMapping(value = "/v1",method = RequestMethod.GET)
    public String home(){
        System.out.println("测试打印功能");
        return "home";
    }
}
