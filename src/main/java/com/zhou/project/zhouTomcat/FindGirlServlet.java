package com.zhou.project.zhouTomcat;


import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class FindGirlServlet extends MyServlet{


    @Override
    public void doGet(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("get girl .....");
        } catch (IOException e) {
            log.error("doGet error :{}", e.toString());
        }
    }

    @Override
    public void doPost(MyRequest myRequest, MyResponse myResponse) {
        try {
            myResponse.write("post girl .....");
        } catch (IOException e) {
            log.error("doPost error :{}", e.toString());
        }
    }
}
