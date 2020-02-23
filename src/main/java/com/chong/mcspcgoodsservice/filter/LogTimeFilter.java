package com.chong.mcspcgoodsservice.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import java.io.IOException;

public class LogTimeFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(LogTimeFilter.class);

    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("LogTimeFilter init");
    }

    public void doFilter(ServletRequest var1, ServletResponse var2, FilterChain var3)
            throws IOException, ServletException {
        var3.doFilter(var1, var2);
    }

    public void destroy() {
        logger.info("LogTimeFilter destory");
    }
}
