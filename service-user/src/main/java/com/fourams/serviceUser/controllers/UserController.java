package com.fourams.serviceUser.controllers;

import com.fourams.serviceUser.Entities.User;
import com.fourams.serviceUser.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping(value = "/users")
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @PostMapping
    public User newUser(@RequestBody User user){
        return userService.newUser(user);
    }

    @PostMapping("/login")
    public User login(String email, String password){
        return userService.login(email, password);
    }


    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userService.getUserById(id);
    }

    @PutMapping("/{id}")
    public User updateUserById(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping("/{id}")
    public User deleteUserById(@PathVariable int id){
        return userService.deleteUser(id);
    }
}
