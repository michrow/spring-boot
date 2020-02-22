package com.example.demo.web.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("app init");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("app destroyed");
    }
}
