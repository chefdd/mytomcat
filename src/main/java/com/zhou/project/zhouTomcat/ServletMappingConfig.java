package com.zhou.project.zhouTomcat;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ServletMappingConfig {

    public static List<ServletMapping> servletMappingList = new ArrayList<ServletMapping>();

    static {
        servletMappingList.add(new ServletMapping("findGirl", "/girl", "mytomcat.FindGirlServlet"));
        servletMappingList.add(new ServletMapping("helloWorld", "/world", "mytomcat.HelloWorldServlet"));
    }


}
