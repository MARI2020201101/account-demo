package com.mariworld.accountdemo.global.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mariworld.accountdemo.global.adaptor.LocalDateTimeDeserializer;
import com.mariworld.accountdemo.global.adaptor.LocalDateTimeSerializer;
import com.mariworld.accountdemo.global.handler.AuthHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@EnableWebMvc
@Configuration
@RequiredArgsConstructor
public class WebConfig extends WebMvcConfigurerAdapter {

    private final LocalDateTimeSerializer localDateTimeSerializer;
    private final LocalDateTimeDeserializer localDateTimeDeserializer;
    private final AuthHandler authHandler;
    private final List<String> URL_PATTERNS = Arrays.asList("/**/user/**");
    private final List<String> EXCLUDE_PATTERNS = Arrays.asList("/**/signin", "/**/signup");

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authHandler)
                .addPathPatterns(URL_PATTERNS)
                .excludePathPatterns(EXCLUDE_PATTERNS);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        JavaTimeModule module = new JavaTimeModule();
        module.addSerializer(LocalDateTime.class, localDateTimeSerializer);
        module.addDeserializer(LocalDateTime.class, localDateTimeDeserializer);

        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(module);
        converters.add(new MappingJackson2HttpMessageConverter(mapper));
    }
}
