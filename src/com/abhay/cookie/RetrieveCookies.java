package com.abhay.cookie;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RetrieveCookies extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        Cookie ck[] = req.getCookies();
        for (Cookie c : ck) {
            out.println(c.getName() + ": " + c.getValue());
            out.println("<br/>");
        }

        out.close();
    }
}
