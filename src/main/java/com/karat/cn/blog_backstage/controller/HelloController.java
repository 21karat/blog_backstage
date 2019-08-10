package com.karat.cn.blog_backstage.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {


    @ResponseBody
    @RequestMapping("helloWord")
    public String helloWord(){
        return "hello,word";
    }


}
