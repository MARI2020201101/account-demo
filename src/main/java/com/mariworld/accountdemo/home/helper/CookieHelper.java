package com.mariworld.accountdemo.home.helper;

import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class CookieHelper {

    public void setCookie(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        Cookie cookie = new Cookie("myCookie", "myCookieSampleValue");
        cookie.setPath("/");
        response.addCookie(cookie);
    }

    public void removeCookie(){
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = servletRequestAttributes.getRequest();
        HttpServletResponse response = servletRequestAttributes.getResponse();
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("myCookie")){
                cookie.setMaxAge(0);
                cookie.setPath("/");
                cookie.setValue(null);
                response.addCookie(cookie);
            }
        }
    }
}
