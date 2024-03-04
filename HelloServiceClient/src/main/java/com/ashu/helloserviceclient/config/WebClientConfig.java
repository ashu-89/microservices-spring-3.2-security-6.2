package com.ashu.helloserviceclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    @LoadBalanced
    //Spring beans have same name as the methodName instantiating them.
    //So if i @Autowire somewhere .... , that object's name i'll have to make as webClient itself!
    public WebClient.Builder webClient(){
        return WebClient.builder();
    }

    //**To DO
    //It somehow wasn't working with REST TEMPLATE
    //USING REST TEMPLATE, I WAS HAVING TO HARD CORT HOSTNAME AND PORT NUMBER
    //It wasn't picking up EUREKA registered urls

    //However, last time, i had not put @LoadBalanced in RestTemplate
    //Will try if adding that annotation makes 1 microservice (HelloServiceClient) consume
    //another microservice (HelloService)
    //with Eureka registered URLs using RestTemplate's get for object method for making
    //API calls over HTTP
}
