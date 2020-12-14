package com.diy.spring;

import com.diy.spring.annotation.XAutowired;
import com.diy.spring.annotation.XController;
import com.diy.spring.annotation.XRequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@XController
@XRequestMapping("/test")
public class TestController {

    @XAutowired
    TestService testService;

    @XRequestMapping("query")
    public void query(HttpServletRequest request, HttpServletResponse response){
        if (request.getParameter("username") == null) {
            try {
                response.getWriter().write("param username is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            String paramName = request.getParameter("username");
            try {
                response.getWriter().write("param username is " + paramName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println(" new request param username -- >" + paramName);
        }
    }

    @XRequestMapping("listClassName")
    public void listClassName(HttpServletRequest request, HttpServletResponse response) {
        String name = testService.listClassName();
        System.out.println("test service return value = " + name);
        try {
            response.getWriter().write(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
