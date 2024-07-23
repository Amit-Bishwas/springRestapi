package com.amit.springRestapi.rest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestControler
{
    //add code for the "/heello
    @GetMapping("/hello")
        public String sayHello()
        {
            return "Hello World";
        }
}
