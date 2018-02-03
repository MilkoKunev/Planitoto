package com.university.planitoto.controllers;

import com.university.planitoto.models.User;
import com.university.planitoto.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/profile")
public class UserController {

    private UserRepository repository;

    @Autowired
    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public String getProfile(@PathVariable(value = "id") String id, Model model) {
        User user = repository.findByFacebookId(id);
        if(user == null) {
            model.addAttribute("message", "Profile not found");
            return "profile";
        }
        model.addAttribute("profile", user);
        return "profile";
    }

    @PostMapping("")
    public String createProfile(@RequestBody User user) {
        if (user != null && user.getName() != null && user.getFacebookId() != null){
            repository.save(user);
            return "redirect:/profile/" + user.getFacebookId();
        }
        else {
            return "redirect:/error/profile/400";
        }
    }
}
