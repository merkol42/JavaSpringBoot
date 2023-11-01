package com.merkol.springboot.mycoolapp.rest;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Role;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {

    //expose "/" that return "Hello World!"
    @GetMapping("/")
    public String sayHello() {
        return "Hello World!!!";
    }
}
