package com.example.demo;

import com.example.demo.service.RetryableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("demo")
@EnableRetry
public class HelloWorldController {

    @Autowired
    C c;
    @Autowired
    RetryableService retryableService;

    @RequestMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        return "Hello World" + ":" + this.c.getVal() + " " + this.c.getB().getVal();
    }

    @RequestMapping("retry")
    public String testRetriable() {
        retryableService.performTask();
        return "Test retry";
    }

    @GetMapping(value = "/json", produces = "application/json")
    public Map processJSON() {
        Map<String, String> map=new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");
        /* Converts map to JSON while sending*/
        return map;
    }
}
