package com.atguigu.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.springcloud.alibaba.myHandler.customerBlockHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderNacosController {

    @Autowired
    public RestTemplate restTemplate;

    @Value("${service-url.nacos-user-service}")
    private String serverURL;

    @GetMapping("/get")
    public String get(){
        int age=10/0;
        return restTemplate.getForObject(serverURL+"/get",String.class);
    }

    @GetMapping("/testHotKey")
    @SentinelResource(value = "testHotKey",blockHandler = "deal_testHotKey")
    public String testHotKey(@RequestParam(value = "p1",required = false) String p1,
                             @RequestParam(value = "p2",required = false) String p2){
        return "正常";
    }

    public String deal_testHotKey(@RequestParam(value = "p1",required = false) String p1,
                                         @RequestParam(value = "p2",required = false) String p2,
                                         BlockException e){
        return "不正常";
    }

    @GetMapping("/customerBlockHandler")
    @SentinelResource(value = "customerBlockHandler",blockHandlerClass = customerBlockHandler.class,blockHandler = "test")
    public String customerBlockHandler(){
        return "正常";
    }


}
