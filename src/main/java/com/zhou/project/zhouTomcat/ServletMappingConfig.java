package com.zhou.project.zhouTomcat;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "com.zhou.project.zhouTomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "com.zhou.project.zhouTomcat.HelloWorldServlet"));
    }


}
