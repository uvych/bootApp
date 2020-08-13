package com.gb.boot.project.bootApp.controllers;

import com.gb.boot.project.bootApp.model.User;
import com.gb.boot.project.bootApp.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/allUsers")
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllProduct());
        return "user-page";
    }

    @PostMapping("user/add")
    public String addNewUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/allUsers";
    }

    @GetMapping("user/edit/{id}")
    public String showEditUser(@PathVariable Long id, Model model) {
        model.addAttribute("user",  userService.getProductById(id));
        return "user-edit-page";
    }

    @PostMapping("user/edit")
    public String editUser(@ModelAttribute User user) {
        userService.saveOrUpdate(user);
        return "redirect:/allUsers";
    }

    @GetMapping("user/remove/{id}")
    public String removeUserById(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/allUsers";
    }

    @GetMapping("user/find")
    public String findByID(@RequestParam(required = false) Long id, Model model){
        model.addAttribute("user", userService.getProductById(id));
        return "user-by-id";
    }
}
