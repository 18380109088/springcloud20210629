package com.cme.eureka;
 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
 
@SpringBootApplication
@EnableEurekaServer //Eureka Server
public class RegisterMain{
     public static void main(String [] args) {
    	 new SpringApplicationBuilder(RegisterMain.class).web(true).run(args);
     }
}