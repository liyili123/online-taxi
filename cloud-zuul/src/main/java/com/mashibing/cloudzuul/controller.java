package com.mashibing.cloudzuul;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 马士兵教育:晁鹏飞
 * @date 2020/07/01
 */
@RestController
public class controller {

    @GetMapping("/myController")
    public String testController(){
        System.out.println("我的调用！");

        return "my controller";
    }
}
