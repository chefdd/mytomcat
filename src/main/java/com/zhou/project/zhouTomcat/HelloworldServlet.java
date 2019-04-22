package com.zhou.project.zhouTomcat;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
public class HelloworldServlet extends MyServlet{


    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get world....");
        } catch (IOException e) {
            log.error("hello world doGet error:{}", e.toString());
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post world....");
        } catch (IOException e) {
            log.error("hello world doPost error:{}", e.toString());
        }
    }
}
