package katacademy.userscrud.controller;

import katacademy.userscrud.model.User;
import katacademy.userscrud.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/users")
public class UsersController {

    private  final UserServiceImp userService;

    @Autowired
    public UsersController(UserServiceImp userService) {
        this.userService = userService;
    }


    @GetMapping({"/users","/"})
    public String getAllUsers(Model model, @ModelAttribute("flashMessage") String flashAttribute) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }


    @GetMapping("/new")
    public String addUserForm(Model model) {
        model.addAttribute("user-create", new User());
        return "user-create";
    }

    @PostMapping("/new")
    public String addUserSubmit(@ModelAttribute User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable Long id, Model model) {
        User user = userService.readUser(id);
        model.addAttribute("edit-user", user);
        return "edit-user";
    }

    @PostMapping("/edit-user/{id}")
    public String editUserSubmit(@PathVariable Long id, @ModelAttribute User user) {
        userService.createOrUpdateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }


}
