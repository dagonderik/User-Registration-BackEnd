package com.example.dagon.registerUser.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dagon.registerUser.model.User;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>(Arrays.asList(

        new User("1", "_Spring FrameWork", "_Spring Description"),
        new User("12", "Spring FrameWork", "Spring Description"),
        new User("3", "Java FrameWork", "Java Description")
    ));

    public List<User> getAllUserList() {
        return userList;
    }

    public User getUser(String id) {
        return userList.stream().filter( user -> user.getId().equals(id)).findFirst().get();
    }

    public void addUser(User user) {
        userList.add(user);
    }
    
}
