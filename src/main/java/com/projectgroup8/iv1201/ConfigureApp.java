package com.projectgroup8.iv1201;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.*;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;

@EnableWebMvc
@Configuration
public class ConfigureApp {
    
//     @Bean
//     public ServletContextTemplateResolver templateResolver() {
//     ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
//     templateResolver.setPrefix("/web/views/");
//     templateResolver.setSuffix(".html");

//     return templateResolver;
// }

//     @Bean
//     public SpringTemplateEngine templateEngine() {
//     SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//     templateEngine.setTemplateResolver(templateResolver());
//     templateEngine.setTemplateEngineMessageSource(messageSource());
//     return templateEngine;
// }

//     @Bean
//     public ThymeleafViewResolver viewResolver(){
//     ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
//     viewResolver.setTemplateEngine(templateEngine());
//     return viewResolver;
// }

    // @Bean
    // public DataSource dataSource(){
    //     DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
    //     // dataSourceBuilder.driverClassName("org.postgresql.Driver");

    //     dataSourceBuilder.url("jdbc:postgresql://127.0.0.1:5432/test");
    //     dataSourceBuilder.username("postgres");
    //     dataSourceBuilder.password("bjorn123");

    //     return dataSourceBuilder.build();
    // }
}