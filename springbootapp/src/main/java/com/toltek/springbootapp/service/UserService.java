package com.toltek.springbootapp.service;

import com.toltek.springbootapp.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();


    User put(User user);


    Optional<User> findById(Long id);


    void delete(User user);
}
