package com.demo.service;

import com.demo.service.hystrix.ServiceAHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author: xxxxx
 * @create: 2019-12-23
 */
@FeignClient(value="server",fallback = ServiceAHystrix.class)
public interface ServiceA {
    @RequestMapping(value="/",method= RequestMethod.POST)
    public String sayHelloWorld(@RequestBody String string);
    @RequestMapping(value="/A",method= RequestMethod.GET)
    public String sayA();
}
