/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author huynq
 */
@Configuration
@EnableWebMvc
//@ComponentScan("com.spring.security") // omit basePackages
@ComponentScan(basePackages = "com.spring.security")
public class AppConfig implements WebMvcConfigurer{

    @Bean
    public ViewResolver viewResolver() {

        InternalResourceViewResolver viewResolver
                = new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // Config to serve content from the "/css" directory
        registry.addResourceHandler("/css/**")
                .addResourceLocations("/css/");
    }


}
