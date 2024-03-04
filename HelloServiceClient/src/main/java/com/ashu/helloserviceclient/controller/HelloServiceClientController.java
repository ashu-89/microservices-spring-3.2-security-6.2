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
@RequestMapping("/api/hello-service-client")
public class HelloServiceClientController {

    @Autowired
    WebClient.Builder webClient;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/hello-client")
    public ResponseEntity<String> helloClient() {

        UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
                .fromUriString("http://hello-service/api/hello-service/hello");

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

//    @GetMapping("/hello-client")
//    public ResponseEntity<String> helloClient() {
//        // Now you can use restTemplate to make API calls
//        String forObject = restTemplate.getForObject("http://hello-service/api/hello-service/hello", String.class);
//        return new ResponseEntity<>(forObject, HttpStatus.OK);
//    }


}
