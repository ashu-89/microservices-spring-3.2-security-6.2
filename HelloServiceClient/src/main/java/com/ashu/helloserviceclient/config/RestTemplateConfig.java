package com.ashu.helloserviceclient.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    @Bean
    @LoadBalanced
    //If we comment out @LoadBalanced above, code doesn't work. detailed explanation below
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    /*
    The java.net.UnknownHostException: hello-service error occurs
    when the RestTemplate is unable to resolve the hostname "hello-service" to an IP address.
    This is expected behavior when using Eureka and Spring Cloud LoadBalancer with RestTemplate.

    When you use @LoadBalanced with RestTemplate,
    it integrates with Ribbon, a client-side load balancer,
    and is aware of the service names registered with Eureka.
    It allows you to use the service name directly in the URL
    without worrying about the actual IP address and port.

    If you remove @LoadBalanced from the RestTemplate configuration,
    it loses this awareness of Eureka service names,
    and you need to provide the exact hostname and port,
    which may not be resolved in your local environment.

    So, it's recommended to use @LoadBalanced with RestTemplate
    when working with Eureka and Spring Cloud LoadBalancer.
    If you encounter any issues, ensure that your RestTemplate configuration is correct
    and that Eureka is registering and discovering services properly.
     */


}
