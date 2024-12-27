package sk.project.springboot_mvc_secure_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sk.project.springboot_mvc_secure_app.service.EventService;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    // TODO: when user open one event handle materials feedback and so on
}

