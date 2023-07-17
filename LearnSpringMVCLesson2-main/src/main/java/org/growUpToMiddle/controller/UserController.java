package org.growUpToMiddle.controller;

import org.growUpToMiddle.model.User;
import org.growUpToMiddle.service.UserService;
import org.growUpToMiddle.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getUsersPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @PostMapping("/users")
    public String addUser(User user) {
        userService.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}")
    public String getUserPage(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.getUserById(id));
        return "/user";
    }

    @PostMapping("/user/{id}/update")
    public String updateUser(@PathVariable("id") Long userId,User user,String firstName, String lastName,String email) {
        System.out.println(user);
        userService.updateUser(userId,user,firstName,  lastName, email);
        return "redirect:/users/" + userId;
    }

    @GetMapping("/users/{id}/delete")
    public String updateUser(@PathVariable("id") Long userId) {
        userService.deleteUser(userId);
        return "redirect:/users";
    }

}
