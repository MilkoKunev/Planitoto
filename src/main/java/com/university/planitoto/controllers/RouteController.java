package com.university.planitoto.controllers;

import com.university.planitoto.models.Route;
import com.university.planitoto.repositories.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@Controller
@RequestMapping("/routes")
public class RouteController {


    private final RouteRepository repository;

    @Autowired
    RouteController(RouteRepository repository) {
        this.repository = repository;
    }

    @GetMapping("")
    public String getAllRoutes(ModelMap model){
        List<Route> routes = repository.findAll();

        model.addAttribute("routes", routes);
        return "routes/routes";
    }

    @GetMapping("/create")
    public String getCreateForm(Model model) {
        model.addAttribute("route", new Route());
        return "routes/createRoute";
    }

    @PostMapping("/save")
    public String saveRoute(@ModelAttribute Route route, Model model) {
        if(route != null) {
            this.repository.save(route);
        }
        model.addAttribute("message", "Route created successfully");
        return "redirect:/routes";
    }

    @GetMapping("/{name}")
    public String getRoute(@RequestParam(value = "name") String name, Model model) {
        if(name == null) {
           //TODO: Return error message if name is not present
        }
        Route route = repository.findByName(name);
        if(route == null) {
            //TODO: Return "Route not found"
        }
        model.addAttribute(route);
        return "individualRoute";
    }
}
