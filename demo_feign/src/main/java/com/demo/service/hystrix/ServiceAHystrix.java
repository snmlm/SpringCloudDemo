package com.demo.service.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.demo.service.ServiceA;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @author: xxxxx
 * @create: 2019-12-23
 */
@Component
public class ServiceAHystrix implements ServiceA {

    @Override
    public String sayHelloWorld(String string) {
        JSONObject json = new JSONObject();
        json.put("id", "");
        json.put("description", "服务异常演习专用！");
        json.put("msg", "throwable.getMessage()");
        return json.toString();
    }

    @Override
    public String sayA() {
        JSONObject json = new JSONObject();
        json.put("id", "id");
        json.put("description", "服务异常演习专用！");
        json.put("msg", "throwable.getMessage()");
        return json.toString();
    }
}
