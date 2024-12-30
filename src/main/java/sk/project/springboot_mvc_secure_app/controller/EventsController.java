package sk.project.springboot_mvc_secure_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.service.EventService;

import java.util.List;

@Controller
public class EventsController {

    @Autowired
    private EventService eventService;

    @GetMapping("/")
    public String showCleanPage(Model model) {
        List<Event> publicEvents = eventService.findAllPublicEvents();

        model.addAttribute("events", publicEvents);

        return "/event/events";
    }

    @GetMapping("/event/search")
    public String searchEvents(@RequestParam("query") String query, Model model) {

        List<Event> events;

        if (query == null || query.trim().isEmpty()) {
            events = eventService.findAllPublicEvents();
        } else {
            events = eventService.findByName(query);

            if (events.isEmpty()) {
                model.addAttribute("message", "No events found containing: " + query);
            }
        }


        model.addAttribute("events", events);
        model.addAttribute("query", query);
        return "event/events";
    }

    @GetMapping("/event/events")
    public String viewEvents(Model model) {
        List<Event> publicEvents = eventService.findAllPublicEvents();

        model.addAttribute("events", publicEvents);

        return "event/events";
    }
}
