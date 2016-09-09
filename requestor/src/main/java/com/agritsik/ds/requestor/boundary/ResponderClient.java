package com.agritsik.ds.requestor.boundary;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ResponderClient {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private EurekaClient discoveryClient;

    @HystrixCommand(fallbackMethod = "fallback")
    public String getUsers(){
        InstanceInfo responder = discoveryClient.getNextServerFromEureka("responder", false);
        return restTemplate.getForObject(responder.getHomePageUrl()+"/users", String.class);
    }

    public String fallback(){
        return "Responder is unavailable...";
    }

}
