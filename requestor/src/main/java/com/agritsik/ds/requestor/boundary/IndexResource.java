package com.agritsik.ds.requestor.boundary;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexResource {

    @Value("${spring.application.name}")
    private String app;

    @Autowired
    ResponderClient responderClient;

    @RequestMapping("/")
    public String index() {
        return "Hello from " + app;
    }

    @RequestMapping("/users")
    public String users() {
        return responderClient.getUsers();
    }

}
