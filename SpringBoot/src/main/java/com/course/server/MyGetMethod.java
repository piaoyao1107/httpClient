package com.course.server;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

@RestController
public class MyGetMethod {

    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    public String getCookies(HttpServletResponse response){
        //HttpServletRequest    请求信息的类
        //HttpServletResponse   响应信息的类

        //添加cookie到响应信息
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);

        return "恭喜你获得cookies成功！";

    }

    //要求客户端携带cookies访问

    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        //判断cookies是否为空
        if (Objects.isNull(cookies)){
            return "你必须携带cookie访问";
        }

        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login") && cookie.getValue().equals("true")){
                return "恭喜你，携带了正确的cookies信息";
            }
        }

        return "你必须携带cookie访问";
    }
}
