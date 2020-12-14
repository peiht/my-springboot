package com.diy.spring;

import com.diy.spring.annotation.XService;

@XService
public class TestServiceImpl implements TestService{
    @Override
    public String listClassName() {
        return "123456";
    }
}
