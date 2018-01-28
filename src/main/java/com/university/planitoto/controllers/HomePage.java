package com.university.planitoto.controllers;

import com.university.planitoto.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomePage {

    @GetMapping("/greetings")
    public String greting(@RequestParam(value="name", required=false, defaultValue = "PlanitotoUser")String name, Model model){
        model.addAttribute("name", name);
        return "greetings";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute User login) {

        return null;
    }
}
