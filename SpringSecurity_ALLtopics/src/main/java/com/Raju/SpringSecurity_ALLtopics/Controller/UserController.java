package com.Raju.SpringSecurity_ALLtopics.Controller;


import com.Raju.SpringSecurity_ALLtopics.Model.Users;
import com.Raju.SpringSecurity_ALLtopics.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

@Autowired
private UserService userService;

    @PostMapping("/register")
    public Users register(@RequestBody  Users users ){
        return userService.register(users);


    }
}
