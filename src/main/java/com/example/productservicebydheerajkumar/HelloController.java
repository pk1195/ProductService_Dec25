package com.example.productservicebydheerajkumar;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloController {

   // @RequestMapping(value = "/hello",method = RequestMethod.GET)
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello, I am Pooja Kedar!";
    }

    @RequestMapping(value = "/hi/{id}", method = RequestMethod.GET)
    public String sayHi(@PathVariable String id) {
        return "Hi, I am Pooja Kedar! Learning Spring Boot."+id;
    }
}
