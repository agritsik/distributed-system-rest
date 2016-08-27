package com.agritsik.ds.requestor.boundary;

import com.agritsik.ds.requestor.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class IndexResource {

    @Autowired
    UsersRepository usersRepository;

    @Value("${spring.application.name}")
    private String app;

    @RequestMapping("/")
    public String index(){
        return "Hello from " + app;
    }

    @RequestMapping("/users")
    public List<User> users(){
        return usersRepository.find();
    }

}
