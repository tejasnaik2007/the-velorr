package com.leema.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

/** Serves the photos and the hero video from the classpath (with HTTP Range support for the video). */
@Configuration
public class MediaConfig implements WebMvcConfigurer {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/image/**")
                .addResourceLocations("classpath:/image/")
                .setCacheControl(CacheControl.maxAge(7, TimeUnit.DAYS));
    }
}
