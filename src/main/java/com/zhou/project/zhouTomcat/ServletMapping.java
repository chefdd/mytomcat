package com.zhou.project.zhouTomcat;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ServletMapping {

    private String servletName;
    private String url;
    private String clazz;

}
