package sk.project.springboot_mvc_secure_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.project.springboot_mvc_secure_app.entity.LearningCenter;
import sk.project.springboot_mvc_secure_app.service.LearningCenterService;

import java.util.List;

@Controller
public class LocationsController {

    @Autowired
    private LearningCenterService learningCenterService;


    @GetMapping("/locations")
    public String showLocations(Model model) {
        List<LearningCenter> locations = learningCenterService.findAll();
        model.addAttribute("locations", locations);
        return "locations";
    }

}
