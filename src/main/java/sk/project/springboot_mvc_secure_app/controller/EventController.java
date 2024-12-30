package sk.project.springboot_mvc_secure_app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.service.EventService;

import java.util.Optional;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event/create-event")
    public String showCleanPage(Model model) {

        return "/event/create-event";
    }

    @GetMapping("/event/event-details/{eventId}")
    public String viewEvent(@PathVariable Long eventId, Model model) {
        Optional<Event> event = eventService.findById(eventId);

        if (event.isEmpty()) {
            return "event-not-found";
        }

        model.addAttribute("event", event);

        return "/event/event-details";
    }
}

