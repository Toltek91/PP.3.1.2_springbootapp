package com.toltek.springbootapp.service;

import com.toltek.springbootapp.model.User;
import com.toltek.springbootapp.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User put(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Transactional(readOnly = true)
    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


    @Transactional
    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }
}
