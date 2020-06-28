package com.murong.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickControler {
    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "hello hanyu!";
    }
}
