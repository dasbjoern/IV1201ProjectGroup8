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
    

}