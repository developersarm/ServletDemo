package org.care.context;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyApplicationContext {

    private static Connection jdbcConnection;

    private static final ThreadLocal<MyApplicationContext> appContextThreadLocal = new ThreadLocal<>();

    public static MyApplicationContext get() {
        return appContextThreadLocal.get();
    }

    private MyApplicationContext() {
    }

    // -------------------- static methods
    /**
     * This method is invoked only once using ServletContextListener when the server is starting-up
     * @throws Exception
     */
    public static void init()throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        jdbcConnection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/servletdemo?useSSL=false", "root", "admin");
    }

    /**
     * This method is invoked only once using ServletContextListener when the server is shutting down
     * @throws Exception
     */
    public static void destroyContext() throws Exception {
        jdbcConnection.close();
    }



    /**
     * This method is invoked from Filter - for every single request before service
     */
    public static void create() {
        if(appContextThreadLocal.get() != null) {
            throw new IllegalStateException("Thread local application context already exists");
        }
        appContextThreadLocal.set(new MyApplicationContext());
    }

    /**
     * This method is invoked from Filter - when the request has completed its service
     */
    public static void destroy() {
        if(appContextThreadLocal.get() == null) {
            throw new IllegalStateException("Thread local application context is already destroyed!");
        }
        appContextThreadLocal.remove();
    }

    // ----------------- member methods

    /**
     * method to get the JDBC connection opened for this application
     * @return
     */
    public Connection getJdbcConnection() {
        return jdbcConnection;
    }

}
