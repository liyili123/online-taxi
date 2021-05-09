package com.mashibing.cloudzuul.filter;

import com.mashibing.cloudzuul.dao.CommonGrayRuleDaoCustom;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jmnarloch.spring.cloud.ribbon.support.RibbonFilterContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 马士兵教育:晁鹏飞
 * @date 2020/06/29
 */
@Component
public class GrayPostFilter extends ZuulFilter {


    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return false;
    }



    @Override
    public Object run() throws ZuulException {
        RibbonFilterContextHolder.clearCurrentContext();
        return null;
    }
}
