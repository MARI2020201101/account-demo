package com.mariworld.accountdemo.global.config;


import com.mariworld.accountdemo.global.handler.AuthHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.Arrays;
import java.util.List;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class WebConfig extends WebMvcConfigurerAdapter {

    private final AuthHandler authHandler;
    private final List<String> URL_PATTERNS = Arrays.asList("/**/user/**");
    private final List<String> EXCLUDE_PATTERNS = Arrays.asList("/**/signin", "/**/signup");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(authHandler)
                .addPathPatterns(URL_PATTERNS)
                .excludePathPatterns(EXCLUDE_PATTERNS);
    }
}
