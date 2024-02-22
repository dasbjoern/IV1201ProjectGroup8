package com.projectgroup8.iv1201;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;


@SpringBootApplication
@PropertySource(value = "classpath:config.properties", ignoreResourceNotFound = true)
public class Iv1201Application {
	/* This method will start the application. */
	public static void main(String[] args) {
		SpringApplication.run(Iv1201Application.class, args);
	}
	

}
