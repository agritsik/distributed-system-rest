package com.agritsik.ds.requestor.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class IndexResource {

    @Value("${spring.application.name}")
    private String app;

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping("/")
    public String index() {
        return "Hello from " + app;
    }

    @RequestMapping("/users")
    public String users() {
        return restTemplate.getForObject("http://localhost:8080/users", String.class);
    }

}
