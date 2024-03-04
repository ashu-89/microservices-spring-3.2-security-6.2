package com.ashu.helloserviceclient.controller;

import com.ashu.helloserviceclient.config.WebClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/hello-client")
public class HelloServiceClientController {

    @Autowired
    WebClient.Builder webClient;

    @GetMapping
    public ResponseEntity<String> helloClient() {

        RestTemplate restTemplate = new RestTemplate();
        //String forObject = restTemplate.getForObject("http://localhost:8081/api/home", String.class);
        //String forObject = restTemplate.getForObject("http://hello-service/api/home", String.class);

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString("http://hello-service/api/home");

        //no path variables, query params
        String uriString = uriComponentsBuilder.toUriString();

        String apiResponseString = webClient.build()
                .get()
                .uri(uriString)
                .retrieve()
                .bodyToMono(String.class)
                .block();


        return new ResponseEntity<>(apiResponseString, HttpStatus.OK);

    }


}
