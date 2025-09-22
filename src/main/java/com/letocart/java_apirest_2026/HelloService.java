package com.letocart.java_apirest_2026;

import org.springframework.stereotype.Service;

@Service
public class HelloService {
    static int count = 0;

    public HelloService(){}

    public String helloCount(){
        count++;
        return "Hello World number "+ count;
    }
}
