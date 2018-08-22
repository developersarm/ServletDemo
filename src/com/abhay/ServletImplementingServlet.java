package com.abhay;

import java.io.*;
import javax.servlet.*;

public class ServletImplementingServlet implements Servlet {
    ServletConfig config = null;

    @Override
    public void init(ServletConfig servletConfig) {
        this.config = servletConfig;
    }

    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException, ServletException{
        servletResponse.setContentType("text/html");

        PrintWriter out = servletResponse.getWriter();
        out.print("<html><body>");
        out.print("<b>hello simple servlet</b>");
        out.print("</body></html>");

//        out.close();
    }

    @Override
    public void destroy() {
        System.out.println("Servlet is destroyed");
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public String getServletInfo() {
        return "copyright 2007-1010";
    }
}