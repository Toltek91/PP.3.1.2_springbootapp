package katacademy.userscrud.controller;

import katacademy.userscrud.model.User;
import katacademy.userscrud.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UsersController {

    private  final UserServiceImp userService;

    @Autowired
    public UsersController(UserServiceImp userService) {
        this.userService = userService;
    }


    @GetMapping({"/users","/"})
    public String getAllUsers(Model model) {
        List<User> usersList = userService.getAllUsers();
        model.addAttribute("users", usersList);
        return "users";
    }


    @GetMapping("/user-create")
    public String addUserForm() {
        return "/user-create";
    }

    @PostMapping("/user-create")
    public String addUserSubmit(User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-edit")
    public String editUserForm(@RequestParam Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("user", user);
        return "/user-edit";
    }

    @PostMapping("/user-edit")
    public String editUserSubmit(User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/delete")
    public String deleteUser(@RequestParam Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
