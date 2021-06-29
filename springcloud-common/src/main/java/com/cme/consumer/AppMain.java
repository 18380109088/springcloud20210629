package com.cme.consumer;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableEurekaClient //Eureka Client
@EnableFeignClients //声明式服务调用，请求URL地址查询/拼接
@EnableHystrix //断路器
public class AppMain {
    public static void main(String[] args) {
        new SpringApplicationBuilder(AppMain.class).web(true).run(args);
    }
    
}