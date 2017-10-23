package com.ch.mybcrm.web.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author chenhao
 * @date 2017/10/23
 */
@RestController
@Slf4j
public class HelloController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/hello")
    public String hello(){
        System.out.println("------hello");
        return restTemplate.getForEntity("http://MYBCRM-SERVICE/hello",String.class).getBody();
    }
}
