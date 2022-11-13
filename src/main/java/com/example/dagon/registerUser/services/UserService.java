package com.example.dagon.registerUser.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.dagon.registerUser.model.User;

@Service
public class UserService {

    private List<User> userList = new ArrayList<>(Arrays.asList());
    private int id = 1;

    public List<User> getAllUserList() {
        return userList;
    }

    public User getUser(String id) {
        return userList.stream().filter(user -> user.getId().equals(id)).findFirst().get();
    }

    public void addUser(User user) {
        user.setId(Integer.toString(id));
        id++;
        userList.add(user);
    }

    public void editUser(User user, String id) {
        userList.set(userList.indexOf(userList.stream().filter(u -> u.getId().equals(id)).findFirst().get()), user);
    }

    public void deleteUser(String id) {
        userList.removeIf(user -> user.getId().equals(id));
    }

}
