package com.ppx.power.config;

import org.apache.catalina.startup.Tomcat;

public class SpringPpxApplication {
    public static void run() {
        Tomcat tomcat = new Tomcat();
        tomcat.setPort(9999);
//        tomcat.addWebapp("/");
    }
}
