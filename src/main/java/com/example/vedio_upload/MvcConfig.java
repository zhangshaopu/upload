package com.example.vedio_upload;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.text.SimpleDateFormat;

/**
 * @author zsp
 * @version v 0.1 2022/7/11 20:38
 */

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    //private static final String UPLOADED_FOLDER = System.getProperty("user.dir");
    //SimpleDateFormat sdf = new SimpleDateFormat("/yyyy/MM/dd");
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**")
                .addResourceLocations("file:/D:/IdeaProjects/vedio_upload/upload/");

//        registry.addResourceHandler("/upload/processed/**")
//                .addResourceLocations("file:/D:/IdeaProjects/vedio_upload/upload/");
        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}
