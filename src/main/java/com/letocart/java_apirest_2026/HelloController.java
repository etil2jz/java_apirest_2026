package com.letocart.java_apirest_2026;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    public  HelloController() {}

    @GetMapping("/hello")
    public String hello() {
        return "Hello World";
    }
}
