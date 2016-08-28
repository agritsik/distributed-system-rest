package com.agritsik.ds.requestor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ResponderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ResponderApplication.class, args);
    }
}
