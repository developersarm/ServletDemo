package com.abhay.events.httpevent;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Demo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String n=req.getParameter("username");
        out.print("Welcome "+n);

        HttpSession session=req.getSession();
        session.setAttribute("uname",n);

        ServletContext ctx=getServletContext();
        int t=(Integer)ctx.getAttribute("totalusers");
        int c=(Integer)ctx.getAttribute("currentusers");
        out.print("<br>total users= "+t);
        out.print("<br>current users= "+c);

        out.print("<br><a href='/thirteen'>logout</a>");

        out.close();
    }
}
