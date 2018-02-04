package com.university.planitoto.controllers;

import com.university.planitoto.models.Hike;
import com.university.planitoto.models.Route;
import com.university.planitoto.models.UserBean;
import com.university.planitoto.repositories.HikeRepository;
import com.university.planitoto.repositories.RouteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/routes")
public class RouteController {

    private final RouteRepository routeRepository;
    private final HikeRepository hikeRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @Autowired
    RouteController(RouteRepository repository, HikeRepository hikeRepository) {
        this.routeRepository = repository;
        this.hikeRepository = hikeRepository;
    }

    @GetMapping("")
    public String getAllRoutes(ModelMap model){
        List<Route> routes = routeRepository.findAll();

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
            this.routeRepository.save(route);
        }
        model.addAttribute("message", "Route created successfully");
        return "redirect:/routes";
    }

    @GetMapping("/{name}")
    public String getRoute(@PathVariable(value="name") String name, Model model) {
        if(name == null) {
           //TODO: Return error message if name is not present
        }
        Route route = routeRepository.findByName(name);
        if(route == null) {
            //TODO: Return "Route not found"
        }
        if(route.getHikes() != null){
            List<Hike> hikes = new ArrayList<>();
            for(String id: route.getHikes()) {
                Hike hike = hikeRepository.findOne(id);
                hikes.add(hike);
            }
            model.addAttribute("hikes", hikes);
        }
        model.addAttribute("route", route);
        return "routes/individualRoute";
    }

    @GetMapping("/{routeName}/hike/{hikeId}")
    public String getHike(@PathVariable(value="routeName") String routeName, @PathVariable(value="hikeId") String attrHikeId, Model model) {
        List<String> hikes = routeRepository.findByName(routeName).getHikes();
        if(hikes.isEmpty()) {
            //TODO: generate error for
        }
        for(String hikeId: hikes) {
            if(attrHikeId.equals(hikeId)) {
                Hike hike = hikeRepository.findOne(hikeId);
                model.addAttribute(hike);
                return "individualHike";
            }
        }
        return "routes";
    }

    @GetMapping("/{routeName}/hike")
    public String getFormHike(@PathVariable(value="routeName") String routeName, Model model) {
        model.addAttribute("hike", new Hike());
        model.addAttribute("routeName", routeName);
        return "hikes/createHike";
    }

    @PostMapping("/{routeName}/hike")
    public String createHike(@PathVariable(value="routeName") String routeName, @ModelAttribute("hike") Hike hike, Model model) {
        Route route = routeRepository.findByName(routeName);

        hike.setRegion(route.getRegion());
        hike.setRoute(route.getName());
        hikeRepository.save(hike);

        mongoOperations.updateFirst(new Query().addCriteria(Criteria.where("name").is(route.getName())),
                new Update().push("hikes", hike.getId()), Route.class);

        model.addAttribute("route", route);
        return "redirect:/routes";
    }
}
