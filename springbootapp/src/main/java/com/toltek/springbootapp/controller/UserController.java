package com.toltek.springbootapp.controller;


import com.toltek.springbootapp.model.User;
import com.toltek.springbootapp.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @GetMapping("/users")
    public String findAll(Model model) {
        List<User> users = userServiceImpl.findAll();
        model.addAttribute("users", users);
        return "users";
    }

    @GetMapping("/user-create")
    public String createUserForm(User user) {
        return "user-create";
    }

    @PostMapping("/user-create")
    public String create(User user) {
        userServiceImpl.put(user);
        return "redirect:/users";
    }

    @GetMapping("/user/put")
    public String putUserForm(@RequestParam Long id, Model model) {
        Optional<User> user = userServiceImpl.findById(id);
        model.addAttribute("user", user);
        return "/user-put";
    }

    @PostMapping("/user-put")
    public String put(User user) {
        userServiceImpl.put(user);
        return "redirect:/users";
    }


    @GetMapping("/user/delete")
    public String delete(User user) {
        userServiceImpl.delete(user);
        return "redirect:/users";
    }
}
