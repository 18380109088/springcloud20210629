package com.cme.zuul;
 
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
 
@SpringBootApplication
@EnableEurekaClient //Eureka Clinet
@EnableHystrix //断路器
@EnableZuulProxy //zuul网关
public class ZullMain{
     public static void main(String [] args) {
    	 new SpringApplicationBuilder(ZullMain.class).web(true).run(args);
     }
}