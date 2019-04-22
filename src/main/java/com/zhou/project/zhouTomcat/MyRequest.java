package com.zhou.project.zhouTomcat;

import lombok.Data;

import java.io.IOException;
import java.io.InputStream;

@Data
public class MyRequest {


    private String url;
    private String method;


    public MyRequest(InputStream inputStream) throws IOException {
        String httyRequest = "";
        byte[] httpRequestBytes = new byte[1024];
        int length = 0;
        if ((length = inputStream.read(httpRequestBytes)) > 0) {
            httyRequest = new String(httpRequestBytes, 0, length);
        }
        /**
         * http协议
         *
         * 请求方法  空格 URL 空格 协议版本 回车符 换行符  //请求行
         *
         *
         */
        String httpHead = httyRequest.split("\n")[0];
        url = httpHead.split("\\s")[1];
        method = httpHead.split("\\s")[0];
        System.out.println(this);
    }
}
