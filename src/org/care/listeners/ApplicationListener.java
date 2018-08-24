package org.care.listeners;

import org.care.context.MyApplicationContext;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.*;

public class ApplicationListener implements ServletContextListener {
    private Connection con = null;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        try {
            MyApplicationContext.init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        try {
            MyApplicationContext.destroyContext();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
