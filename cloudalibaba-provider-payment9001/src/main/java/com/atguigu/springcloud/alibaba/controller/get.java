package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.swing.text.html.parser.Entity;

@RestController
public class get {
    @Value("${server.port}")
    private String port;

    @GetMapping("/get")
    public String get(){
        return "这是"+port;
    }



}
