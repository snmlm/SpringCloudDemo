package com.demo.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author: xxxxx
 * @create: 2019-12-20
 */
@RestController
public class HelloWorld {

    @Autowired
    Environment environment;

    @RequestMapping(value="/",method = RequestMethod.POST,produces = "application/json; charset=utf-8")
    public String sayHelloWorld(@RequestBody String string) {
        System.out.println(string);
        return string;
    }

    @RequestMapping("/A")
    public String sayA() throws UnknownHostException {
        String port = environment.getProperty("local.server.port");
        InetAddress localHost = null;
        localHost = Inet4Address.getLocalHost();
        String ip = localHost.getHostAddress();
        return ip+":"+port+"demo_A_A";
    }
}
