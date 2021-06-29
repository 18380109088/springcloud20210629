package com.cme.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cme.provider.service.SchedualServiceHi;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class RestProviderController {
	
    @Autowired
    SchedualServiceHi schedualServiceHi;
    
    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam String name) {
        return "hi " + name + ",i am from port:" + port;
    }
    
    @RequestMapping(value = "/hi2",method = RequestMethod.GET)
    @HystrixCommand(fallbackMethod = "hiError")
    public String sayHi(@RequestParam String name) {
        return schedualServiceHi.sayHiFromClientOne(name)+" 调用者："+port;
    }
    
    /**
     * 上述方法异常后，调用断路器失败回调
     * **/
    public String hiError(String name) {
    	System.out.println("springcloud-provider");
        return "hi," + name + ",sorry,error!"+" 调用者："+port;
    }

}