package com.mashibing.apilistenorder;

import net.sf.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ApiListenOrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiListenOrderApplication.class, args);
    }

    @GetMapping
    public String test(){
        return "hellow";
    }
    // channel , 马士兵   4G 支付 token，
    @RequestMapping(value = "listen/{driverId}",produces = "text/event-stream;charset=utf-8")
    public String getStream(@PathVariable("driverId") int driverId){
        System.out.println("听单来了");

        String a = "asdfasdf";
        a.length();


        return "data:"+Math.random()+"\n\n";
    }
}
