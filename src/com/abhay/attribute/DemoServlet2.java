package com.abhay.attribute;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();
            ServletContext context = getServletContext();
            String n = (String) context.getAttribute("company");
            out.println("Welcome to " + n);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
