package com.university.planitoto.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class GlobalErrorController {

    @GetMapping("/profile/{code}")
    public String getError(@PathVariable("code") int code, Model model) {
        switch(code) {
            case 400: return "profileBadRequest";
        }
        return "redirect:/";
    }

}
