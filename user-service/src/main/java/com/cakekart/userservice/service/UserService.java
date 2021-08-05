package com.cakekart.userservice.service;

import com.cakekart.userservice.entity.User;

public interface UserService {
    public User save(User user);
    public User getById(String id);

    void deleteUser(String id);
}
