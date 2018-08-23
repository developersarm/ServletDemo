package com.abhay.servletContext;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        ServletContext context = getServletContext();
        Enumeration<String> e = context.getInitParameterNames();

        String str = "";
        while(e.hasMoreElements()){
            str = e.nextElement();
            out.print("<br>Name: " + str);
            out.print(" value: " + context.getInitParameter(str));
        }

        out.close();
    }
}
