package com.ashu.helloserviceclient.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/hello-client")
public class HelloServiceClientController {

    @GetMapping
    public ResponseEntity<String> helloClient() {

        RestTemplate restTemplate = new RestTemplate();
        String forObject = restTemplate.getForObject("http://localhost:8081/api/home", String.class);
        return new ResponseEntity<>(forObject, HttpStatus.OK);

    }


}
