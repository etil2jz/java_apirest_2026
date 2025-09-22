package com.letocart.java_apirest_2026;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class HelloController {

    private final HelloService service;

    public  HelloController(HelloService helloService) {
        this.service = helloService;
    }


    @PostMapping("/hello")
    public String sayHello(@RequestBody String name){
        return "Hello "+name;
    }

    @GetMapping("/helloworld")
    public String getHello(){
        return "Hello World!";
    }

    @GetMapping("/hello/{pathParam}")
    public String getHelloWithPathParam(@PathVariable String pathParam) {
        return "Hello World " + pathParam;
    }

    @GetMapping("/hello")
    public String getHelloWithQueryParam(@RequestParam String requestParam) {
        return "Hello World " + requestParam;
    }


    @GetMapping("/hello/count")
    public String getHelloCount(){
        return service.helloCount();
    }
}
