package com.university.planitoto.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.university.planitoto.models.Cabin;
import com.university.planitoto.repositories.CabinRepository;

@Controller
@RequestMapping("/cabins")
public class CabinController {
	
	private CabinRepository cabinRepository;
    @Autowired
    CabinController(CabinRepository cabinRepository) {
        this.cabinRepository = cabinRepository;
    }

    @GetMapping("")
    public String getAllcabins(ModelMap model){
        List<Cabin> cabins = cabinRepository.findAll();

        model.addAttribute("cabins", cabins);
        return "cabins/cabins";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("cabin", new Cabin());
        return "cabins/createCabin";
    }

    @PostMapping("/save")
    public String saveCabin(@ModelAttribute Cabin cabin) {
        if(cabin != null) {
            this.cabinRepository.save(cabin);
        }
        return "redirect:/cabins";
    }
}
