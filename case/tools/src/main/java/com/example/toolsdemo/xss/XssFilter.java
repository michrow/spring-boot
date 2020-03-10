package com.example.toolsdemo.xss;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author: wangxh
 * @Description:
 * @Date: Created in 16:13 2020/3/10
 * @Modified By:
 */
public class XssFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        chain.doFilter(new RequestWrapper((HttpServletRequest)request), response);
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}
