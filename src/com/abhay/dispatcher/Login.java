package com.abhay.dispatcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Login extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String n = req.getParameter("userName");
        String p = req.getParameter("userPass");

        if (p.equals("servlet")) {
            RequestDispatcher rd = req.getRequestDispatcher("six");
            rd.forward(req, resp);
        }
        else{
            out.print("Sorry UserName or Password Error!");
            RequestDispatcher rd = req.getRequestDispatcher("/index.html");
            rd.include(req, resp);
        }
    }
}
