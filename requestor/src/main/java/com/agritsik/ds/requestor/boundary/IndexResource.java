package com.agritsik.ds.requestor.boundary;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
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

    @Autowired
    EurekaClient discoveryClient;

    @RequestMapping("/")
    public String index() {
        return "Hello from " + app;
    }

    @RequestMapping("/users")
    public String users() {
        InstanceInfo responder = discoveryClient.getNextServerFromEureka("responder", false);
        return restTemplate.getForObject(responder.getHomePageUrl()+"/users", String.class);
    }

}
