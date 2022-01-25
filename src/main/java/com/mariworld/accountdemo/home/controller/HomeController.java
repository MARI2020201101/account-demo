package com.mariworld.accountdemo.home.controller;

import com.mariworld.accountdemo.home.helper.CookieHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/home/v1")
public class HomeController {

    private final CookieHelper cookieHelper;

    @GetMapping("/make/cookie")
    public String makeMyCookie(){
        cookieHelper.setCookie();
        return "generated new My-Cookie!";
    }
    @GetMapping("/read/cookie")
    public String readMyCookie(){
        return "is there My-Cookie?";
    }

    @GetMapping("/remove/cookie")
    public String removeMyCookie(){
        cookieHelper.removeCookie();
        return "My-Cookie removed...";
    }
}
