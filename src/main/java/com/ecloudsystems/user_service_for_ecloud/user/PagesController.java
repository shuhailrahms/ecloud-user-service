package com.ecloudsystems.user_service_for_ecloud.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class PagesController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String listUsers(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @PostMapping("/save")
    public String addUser(@ModelAttribute User user, Model model) {
        try {
            userService.saveUser(user);
            return "redirect:/users";
        } catch (Exception e) {
            model.addAttribute("errorMessage", "Username " + user.getUsername() + " already exists! Try a different one");
            model.addAttribute("users", userService.getAll());
            return "users";
        }
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") Long id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("users", userService.getAll());
        return "users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
