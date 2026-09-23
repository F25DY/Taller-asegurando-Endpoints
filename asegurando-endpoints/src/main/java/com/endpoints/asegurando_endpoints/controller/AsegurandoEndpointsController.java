package com.endpoints.asegurando_endpoints.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsegurandoEndpointsController {

    @GetMapping("/gfg")
    public String hello() {
        return "Hello World!";
    }    

    @GetMapping("/gfg/welcome")
    public String welcome() {
        return "Welcome to the GFG endpoint!";
    }


}
