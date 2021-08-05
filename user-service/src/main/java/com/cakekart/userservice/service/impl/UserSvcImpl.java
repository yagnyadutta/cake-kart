package com.cakekart.userservice.service.impl;

import com.cakekart.userservice.entity.User;
import com.cakekart.userservice.repository.UserRepository;
import com.cakekart.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserSvcImpl implements UserService {

   @Autowired
    UserRepository userRepository;

   @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User getById(String id) {
        return userRepository.findById(id).get();
    }

    @Override
    public void deleteUser(String id) {
        Optional<User> cake = userRepository.findById(id);
        userRepository.delete(cake.get());
    }
}
