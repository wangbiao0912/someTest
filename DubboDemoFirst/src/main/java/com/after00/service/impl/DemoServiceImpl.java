package com.after00.service.impl;

import com.after00.service.DemoService;

public class DemoServiceImpl implements DemoService {

    public String sayHello(String name) {
        System.out.println("init : " + name);
        return "hello " + name;
    }
}
