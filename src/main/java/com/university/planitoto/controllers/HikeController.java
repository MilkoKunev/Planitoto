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

import com.university.planitoto.models.Hike;
import com.university.planitoto.repositories.HikeRepository;

@Controller
@RequestMapping("/hikes")
public class HikeController {
	
	private HikeRepository hikeRepository;
	
	@Autowired
	public HikeController(HikeRepository hikeRepository) {
		this.hikeRepository = hikeRepository;
	}
	
	@GetMapping("")
	public String getAllHikes(ModelMap model) {
		List<Hike> hikes = hikeRepository.findAll();
		model.addAttribute("hikes", hikes);
		return "hikes/hikes";
	}
	
	@GetMapping("/create")
	public String getCreateForm(Model model) {
		model.addAttribute("hike", new Hike());
		return "hikes/createHike";
		
	}
	
	@PostMapping("/save")
	public String saveHike(@ModelAttribute Hike hike) {
		if (hike != null) {
			this.hikeRepository.save(hike);
		}
		return "redirect:/hikes";
	}	

}
