package com.example.biz;

import java.util.concurrent.TimeUnit;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(final ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/menuimgs/**")
                .addResourceLocations("classpath:/menuimgs/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());;
    }

}