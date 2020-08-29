package com.example.mybatis.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

    private String aa = "df";

    @ResponseBody
    @RequestMapping("/helloworld")
    public Object helloworld () {
        return "你好啊世界"+ aa;
    }
}
