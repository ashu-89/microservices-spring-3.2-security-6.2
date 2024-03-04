package com.ashu.helloserviceclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Bean
    //@LoadBalanced
    //If we comment out @LoadBalanced, will get UnknownHostException. Explained below.

    //Spring beans have same name as the methodName instantiating them.
    //So if i @Autowire somewhere .... , that object's name i'll have to make as webClient itself!
    public WebClient.Builder webClient(){
        return WebClient.builder();
    }

    //**To DO
    //It somehow wasn't working with REST TEMPLATE
    //USING REST TEMPLATE, I WAS HAVING TO HARD CODE HOSTNAME AND PORT NUMBER
    //It wasn't picking up EUREKA registered urls

    //However, last time, i had not put @LoadBalanced in RestTemplate
    //Will try if adding that annotation makes 1 microservice (HelloServiceClient) consume
    //another microservice (HelloService)
    //with Eureka registered URLs using RestTemplate's get for object method for making
    //API calls over HTTP


    /*** unkown host exception explained below
     *
     * When you use @LoadBalanced in Spring,
     * it provides load-balancing for your application
     * when making requests to services registered with a service registry (like Eureka).
     * The @LoadBalanced annotation ensures that the client-side load balancer is applied
     * to the RestTemplate or WebClient bean, allowing it to resolve service names
     * (like "hello-service") to actual network locations.
     *
     * When you remove @LoadBalanced, the load balancer functionality is disabled,
     * and you'll have to provide the exact hostname and port of the service you want to connect to.
     * In your case, the error "java.net.UnknownHostException: Failed to resolve 'hello-service'"
     * indicates that without the load balancer, the application can't resolve the hostname
     * 'hello-service' to a network address.
     *
     * In a microservices architecture using service discovery,
     * it's generally a good practice to keep @LoadBalanced to enable load balancing
     * and let the service registry handle the dynamic discovery of services.
     * This way, you don't have to hardcode hostnames and ports,
     * and the load balancer takes care of distributing requests
     * among available instances of a service.
     *
     * So, in both RestTemplate and WebClient,
     * it's advisable to use @LoadBalanced when you are working with service discovery and Eureka,
     * ensuring proper load balancing and dynamic service resolution.
     *
     */
}
