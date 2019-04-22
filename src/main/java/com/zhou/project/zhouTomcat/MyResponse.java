package com.zhou.project.zhouTomcat;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {

    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void write(String content) throws IOException {

        //http响应协议
      /*  HTTP/1.1 200 OK
        Date: Fri, 22 May 2009 06:07:21 GMT
        Content-Type: text/html; charset=UTF-8*/

        StringBuffer httpResponse = new StringBuffer();
        httpResponse.append("HTTP/1.1 200 OK")
                .append("Content-Type: text/html\n")
                .append("\r\n")
                .append("<html><body>")
                .append(content)
                .append("<body></html>");
        outputStream.write(httpResponse.toString().getBytes());
        outputStream.close();
    }
}
