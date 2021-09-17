/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.security.config;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
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
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfig implements WebMvcConfigurer{

    // set up variable to hold the properties
    @Autowired
    private Environment env;

    // set up a logger for diagnostics
    private Logger logger = Logger.getLogger(getClass().getName());


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

    // define a bean for security datasource
    @Bean
    public DataSource securityDataSource() {

        // create connection pool
        BasicDataSource securityDataSource = new BasicDataSource();

        securityDataSource.setDriverClassName(env.getProperty("jdbc.driver"));

        // log to check values in .properties file - only for test
        logger.log(Level.INFO, ">>>jdbc.url= {0}", env.getProperty("jdbc.url"));
        logger.log(Level.INFO, ">>>jdbc.urer= {0}", env.getProperty("jdbc.user"));

        // set db props
        securityDataSource.setUrl(env.getProperty("jdbc.url"));
        securityDataSource.setUsername(env.getProperty("jdbc.user"));
        securityDataSource.setPassword(env.getProperty("jdbc.password"));

        // set connection pool props
        securityDataSource.setInitialSize(getIntProperty("connection.pool.initialSize"));
        securityDataSource.setMinIdle(getIntProperty("connection.pool.minIdle"));
        securityDataSource.setMaxIdle(getIntProperty("connection.pool.maxIdle"));
        securityDataSource
                .setMaxWaitMillis(getIntProperty("connection.pool.maxWaitMillis"));

        return securityDataSource;
    }

    // helper method
    private int getIntProperty(String propName) {

        return Integer.parseInt(env.getProperty(propName));
    }

}
