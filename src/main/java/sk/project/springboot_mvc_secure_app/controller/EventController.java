package sk.project.springboot_mvc_secure_app.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.service.EventService;

import java.util.Optional;

@Controller
public class EventController {

    @Autowired
    private EventService eventService;

    @GetMapping("/event/create-event")
    public String showCleanPage(Model model) {
        model.addAttribute("event", new Event());
        return "event/create-event";
    }

    @GetMapping("/event/event-details/{eventId}")
    public String viewEvent(@PathVariable Long eventId, Model model) {
        Optional<Event> event = eventService.findById(eventId);

        if (event.isEmpty()) {
            return "redirect:/event/events?error=eventNotFound";
        }

        model.addAttribute("event", event);

        return "/event/event-details";
    }

    @PostMapping("/event/save")
    public String saveEvent(@ModelAttribute("event") @Valid Event event, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "redirect:/event/events?error=validationError";
        }

        eventService.save(event);
        return "redirect:/event/events";
    }
}

