package com.mariworld.accountdemo.global.handler;

import com.mariworld.accountdemo.common.CustomCode;
import com.mariworld.accountdemo.global.exception.CustomException;
import com.mariworld.accountdemo.user.helper.TokenGenerator;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@Slf4j
@RequiredArgsConstructor
public class AuthHandler implements HandlerInterceptor {

    private final TokenGenerator tokenGenerator;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String authorization = request.getHeader("Authorization");

        if(authorization == null || !authorization.contains("Bearer")) throw new CustomException(CustomCode.LOGIN_REQUAIRED);

        String token = authorization.substring("Bearer ".length());
        boolean isValidate = tokenGenerator.validateToken(token);

        if(! isValidate) throw new CustomException(CustomCode.LOGIN_REQUAIRED);

        return true;

    }

}
