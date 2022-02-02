package com.mariworld.accountdemo.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/home/v1")
public class ViewController {

    @GetMapping("/view")
    public String view(){
        return "index";
    }

    @PutMapping("/view")
    public void clickView(){
    }
}
