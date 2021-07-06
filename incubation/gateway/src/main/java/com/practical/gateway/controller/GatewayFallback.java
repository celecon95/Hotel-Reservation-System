package com.practical.gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayFallback {

    @GetMapping("/defaultFallback")
    public String getFallBack() {
        return "Error connecting the service, try again later";
    }

}