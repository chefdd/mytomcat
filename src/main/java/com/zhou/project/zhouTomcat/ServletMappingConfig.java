package com.zhou.project.zhouTomcat;

import java.util.ArrayList;
import java.util.List;

public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "mytomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "mytomcat.HelloWorldServlet"));
    }


}
