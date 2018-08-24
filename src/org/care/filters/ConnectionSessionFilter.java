package org.care.filters;


import org.care.context.MyApplicationContext;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionSessionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        MyApplicationContext.create();
        try {
            filterChain.doFilter(servletRequest, servletResponse);
        } catch (Exception e) {
            Logger l = Logger.getLogger(ConnectionSessionFilter.class.getName());
            l.log(Level.SEVERE, "Something went wrong", e);
        }
        MyApplicationContext.destroy();
    }

    @Override
    public void destroy() {

    }
}
