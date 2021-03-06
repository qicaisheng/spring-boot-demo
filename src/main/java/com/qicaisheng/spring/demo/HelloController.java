package com.qicaisheng.spring.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String home() {
        return "home";
    }
    
    @GetMapping("/hello")
    public String hello() {
        return "hello world";
    }
}
