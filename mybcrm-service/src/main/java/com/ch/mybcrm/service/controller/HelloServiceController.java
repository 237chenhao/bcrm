package com.ch.mybcrm.service.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenhao
 * @date 2017/10/23
 */
@RestController
public class HelloServiceController {


    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello!!!!";
    }
}
