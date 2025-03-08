package com.example.SpringBoot.controller;

import com.example.SpringBoot.model.User;
import com.example.SpringBoot.service.UserServiceImp;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserServiceImp userServiceImp;

    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping
    public String getUsers(Model model) {
        model.addAttribute("name", "User");
        model.addAttribute("users", userServiceImp.getAllUsers());
        return "users";
    }

    @GetMapping("/new")
    public String newUser(Model model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping
    public String create(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new";
        }
        userServiceImp.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String edit(@ModelAttribute("id") Long id, Model model, User user) {
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "edit";
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute("user") @Valid User user,
                         BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "edit";
        }
        userServiceImp.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String drop(@ModelAttribute("id") Long id, Model model, User user) {
        model.addAttribute("id", id);
        model.addAttribute("user", user);
        return "delete";
    }

    @PostMapping("delete")
    public String delete(@ModelAttribute("id") Long id) {
        userServiceImp.deleteUser(id);
        return "redirect:/users";
    }
}
