package com.ch.mybcrm.service.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author chenhao
 * @date 2017/10/23
 */
@RestController
public class HelloServiceWeb {


    @RequestMapping("/hello")
    public String hello(){
        System.out.println("hello");
        return "hello!!!!";
    }
}
