package com.projectgroup8.iv1201.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.*;

import com.projectgroup8.iv1201.controller.ErrorHandler.myException;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.xml.crypto.Data;


@EnableWebMvc
@Configuration
@EnableTransactionManagement
@PropertySource(value = "classpath:config.properties", ignoreResourceNotFound = true)
public class ConfigureApp {
    

//  @Bean
//   public DataSource getDataSource() throws Exception{
    
//     DataSourceBuilder<?> dataSourceBuilder = DataSourceBuilder.create();
//     dataSourceBuilder.url("${DATABASE_URL}");
//     dataSourceBuilder.username("${DATABASE_USER}");
//     dataSourceBuilder.password("${DATABASE_PASS}");
//     return dataSourceBuilder.build();
    
//   }
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