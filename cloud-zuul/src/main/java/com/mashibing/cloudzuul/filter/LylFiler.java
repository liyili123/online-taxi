package com.mashibing.cloudzuul.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;
@Component
public class LylFiler  implements Filter {

    public static void main(String[] args) {
        LylFiler lylFiler = new LylFiler();
        lylFiler.equals(lylFiler);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("hello world");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("lyl 拦截");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
