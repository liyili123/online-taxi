package com.mashibing.cloudzuul.filter;

import com.mashibing.cloudzuul.dao.CommonGrayRuleDaoCustom;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 马士兵教育:晁鹏飞
 * @date 2020/06/29
 */
@Component
public class GrayFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }

    @Autowired
    private CommonGrayRuleDaoCustom commonGrayRuleDaoCustom;

    @Override
    public Object run() throws ZuulException {


        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();

        int userId = Integer.parseInt(request.getHeader("userId"));
        // 根据用户id 查 规则  查库 v1,meata

        // 金丝雀
        if (userId == 1){
            RibbonFilterContextHolder.getCurrentContext().add("version","v1");
        // 普通用户
        }else if (userId == 2){
            RibbonFilterContextHolder.getCurrentContext().add("version","v2");
        }



        return null;
    }
}
