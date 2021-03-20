package com.mashibing.servicesms.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.locks.ReentrantLock;

@RestController
@RequestMapping("/lyl")
public class LylController {


    static volatile int i = 0;
    ReentrantLock reentrantLock = new ReentrantLock();


    @RequestMapping("/lylTest")
    public String man2(HttpServletRequest request/*,@PathVariable("ie") String id1*/) {
        reentrantLock.lock();
//        System.out.println("PathVariable: "+id1);
//        String id=request.getHeader("id");
        String id=request.getQueryString();
        String jmeter=request.getHeader("id");
        i++;
        System.out.println("i: " + i+" id:"+id+" jmeter:"+jmeter);
        reentrantLock.unlock();
        return "hello: i "+i;
    }

}
