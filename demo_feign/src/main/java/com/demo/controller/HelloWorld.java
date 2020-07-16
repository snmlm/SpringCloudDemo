package com.demo.controller;

import com.alibaba.fastjson.JSONObject;
import com.demo.service.ServiceA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
    @Autowired
    ServiceA server;

    @RequestMapping("/")
    public String sayHelloWorld() throws UnknownHostException {
        String port = environment.getProperty("local.server.port");
        InetAddress localHost = null;
        localHost = Inet4Address.getLocalHost();
        String ip = localHost.getHostAddress();
        return ip+":"+port;
    }

    @RequestMapping("/A")
    public String sayA() throws UnknownHostException {
        String port = environment.getProperty("local.server.port");
        InetAddress localHost = null;
        localHost = Inet4Address.getLocalHost();
        String ip = localHost.getHostAddress();
        return ip+":"+port+"A";
    }

    @RequestMapping("/server/")
    public String sayDemoServerA(){
        return server.sayHelloWorld("{\"111\":\"2222\"}");
    }

    @RequestMapping("/server/A")
    public String sayDemoServerAA(){
        return server.sayA();
    }
}
