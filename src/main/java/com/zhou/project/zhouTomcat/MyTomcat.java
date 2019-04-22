package com.zhou.project.zhouTomcat;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
            log.info("mytomcat is start... ");
            while (true) {
                Socket socket = serverSocket.accept();
                InputStream inputStream = socket.getInputStream();
                OutputStream outputStream = socket.getOutputStream();


                MyRequest myRequest = new MyRequest(inputStream);
                MyResponse myResponse = new MyResponse(outputStream);



            }
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

        //reflect
        try {
            Class<MyServlet> myServletClass = (Class<MyServlet>) Class.forName(clazz);
            MyServlet myServlet = myServletClass.newInstance();
            myServlet.service(myRequest, myResponse);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyTomcat(8080).start();
    }
}
