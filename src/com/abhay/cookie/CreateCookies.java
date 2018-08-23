package com.abhay.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CreateCookies extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();

            String n = req.getParameter("username");
            String p = req.getParameter("password");

            Cookie ck = new Cookie("uname", n);
            resp.addCookie(ck);
            resp.addCookie(new Cookie("upass", p));
            out.print("Please print something");
            out.println("<form action='/ServletDemo/fifteen' method='post'>");
            out.println("<button type='submit' value='go'/>Submit</button>");
            out.println("</form>");
            out.print("Also this line too!");
//            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
