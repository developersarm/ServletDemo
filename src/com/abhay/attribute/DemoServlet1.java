package com.abhay.attribute;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class DemoServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            PrintWriter out = resp.getWriter();

            ServletContext context = getServletContext();
            context.setAttribute("company", "IBM");

            out.println("Welcom to first servlet");
            out.println("<a href='eleven'>visit</a>");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
