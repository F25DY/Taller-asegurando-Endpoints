package com.endpoints.asegurando_endpoints.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AsegurandoEndpointsController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of("message", "Hola desde Spring Boot");
    }    

    @GetMapping("/hello/{name}")
    public Map<String, String> hello(@PathVariable String name) {
        return Map.of("message", "Hola, " + name);
    }

    @PostMapping("/echo")
    public Map<String, Object> echo(@RequestBody Map<String, Object> payload) {
        return Map.of(
                "status", "ok",
                "received", payload);
    }
}
