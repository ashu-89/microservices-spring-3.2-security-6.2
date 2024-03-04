package com.ashu.helloserviceclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HelloServiceClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloServiceClientApplication.class, args);
    }
}
