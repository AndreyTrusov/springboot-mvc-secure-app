package sk.project.springboot_mvc_secure_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.service.EventService;

import java.util.List;

@Controller
public class EventsController {

    private final EventService eventService;

    @Autowired
    public EventsController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/")
    public String showCleanPage(Model model) {
        List<Event> publicEvents = eventService.findAllPublicEvents();

        model.addAttribute("events", publicEvents);

        return "events";
    }

    @GetMapping("/events")
    public String viewEvents(Model model) {
        List<Event> publicEvents = eventService.findAllPublicEvents();

        model.addAttribute("events", publicEvents);

        return "events";
    }

//    @GetMapping("/events")
//    public String showEventsPage() {
//        return "events";
//    }
}
