package com.endpoints.asegurando_endpoints;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GfgController {

    @GetMapping("/gfg/welcome")
    public String welcome() {
        return "Welcome to GFG!";
    }

    @GetMapping("/gfg")
    public String securedEndpoint() {
        return "Welcome to the secured GFG endpoint!";
    }
}
