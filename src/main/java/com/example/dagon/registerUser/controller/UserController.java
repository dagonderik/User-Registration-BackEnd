package com.example.dagon.registerUser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.dagon.registerUser.model.User;
import com.example.dagon.registerUser.services.UserService;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/users")
    public List<User> all_users() {
        return userService.getAllUserList();
    }
    
    @RequestMapping("/users/{id}")
    public User getUser(@PathVariable("id") String id) {
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value ="/users/{id}")
    public void putUser(@RequestBody User user) {
        userService.editUser(user, user.getId());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/users")
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/users/{id}")
    public void deleteUser(@PathVariable ("id") String id) {
        userService.deleteUser(id);
    }
}
