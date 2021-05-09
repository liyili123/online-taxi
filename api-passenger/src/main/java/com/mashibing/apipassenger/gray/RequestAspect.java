package com.mashibing.apipassenger.gray;

import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 马士兵教育:晁鹏飞
 * @date
 */
@Aspect
@Component
public class RequestAspect {

    @Pointcut("execution(* com.mashibing.apipassenger.controller..*Controller*.*(..))")
    private void anyMehtod(){

    }

    @Before(value = "anyMehtod()")
    public void before(JoinPoint joinPoint){

        HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        String version = request.getHeader("version");

        // 灰度规则 匹配的地方 查db，redis ====
        if (version.trim().equals("v2")){
            RibbonFilterContextHolder.getCurrentContext().add("version","v2");
        }




    }
}
