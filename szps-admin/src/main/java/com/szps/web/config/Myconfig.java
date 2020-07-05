package com.szps.web.config;

import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class Myconfig extends WebMvcConfigurerAdapter {

    //该方法用于使Springboot识别static下所有文件夹的静态资源
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {



        registry.addResourceHandler("/upload/**").addResourceLocations("file:D:/upload/");
        super.addResourceHandlers(registry);


    }

}
