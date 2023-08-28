package com.myserv.api.rh.controller;

import com.myserv.api.rh.model.User;
import com.myserv.api.rh.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequiredArgsConstructor
@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping("/api/auth/users/all")
    public List<User> getAllUsers() {
        return this.userService.findAllUsers();
    }

    @DeleteMapping("/api/auth/users/{id}")
    public void deleteUser(@PathVariable String id) {
        this.userService.deleteById(id);
    }
}
