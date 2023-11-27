package com.app.controller;

import com.app.model.User;
import com.app.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 4800)
@RestController
@RequestMapping("/api/v1/")
public class AppController {
    @Autowired
    private UserService userService;

    @GetMapping("/findFirst")
    public String hello() {
        return "Hello "+userService.getAllUsers()
                .stream()
                .findFirst()
                .map(f->f.getName())
                .orElseGet(()->null);
    }

    @PostConstruct()
    public void initTable(){
        userService.createUser(new User("MyApp"));
    }
}
