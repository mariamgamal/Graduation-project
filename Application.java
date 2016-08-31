package com.obdgp.webservices;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.obdgp.utils.ClassExecutingTask;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(Application.class,args);
		ClassExecutingTask executingTask = new ClassExecutingTask();
        executingTask.start();
	}
	

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
        	
            @Override
            public void addCorsMappings(CorsRegistry registry)  {
            	registry.addMapping("/**").allowedOrigins("*");
            	//TablereadingWebService tw= new TablereadingWebService();
            	//tw.insertReading("14,RPM,122rpm,ENGINE_LOAD,4050,location_latitude,3000.29842,location_longitude,03127.78149,SPEED,12kph");
            	
       	
          }
        };
    }
}
