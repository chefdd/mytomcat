package com.zhou.project.zhouTomcat;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class MyTomcat {

    private int port = 8080;

    private Map<String, String> urlServletMap = new HashMap<String, String>();

    public MyTomcat(int port) {
        this.port = port;
    }

    public void start() {
        initServletMapping();

        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            log.error("tomcat start error:{}", e.toString());
        }
    }

    public void initServletMapping() {
        for (ServletMapping servletMapping : ServletMappingConfig.servletMappingList) {
            urlServletMap.put(servletMapping.getUrl(), servletMapping.getClazz());
        }
    }

    private void dispatch(MyRequest myRequest, MyResponse myResponse) {
        String clazz = urlServletMap.get(myRequest.getUrl());
    }
}
