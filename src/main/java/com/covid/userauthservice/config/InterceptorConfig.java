package com.covid.userauthservice.config;

import com.covid.userauthservice.interceptor.CustomJwtAuthInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig {

    @Bean
    WebMvcConfigurer configurer(){
        return  new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                registry.addInterceptor(customJwtAuthInterceptor());
            }
        };
    }

    @Bean
    public CustomJwtAuthInterceptor customJwtAuthInterceptor(){
        return new CustomJwtAuthInterceptor();
    }
}
