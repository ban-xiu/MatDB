package com.matdb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping("/health")
    public void healthCheck(){
        System.out.println("\nhealth checking");
    }

}
