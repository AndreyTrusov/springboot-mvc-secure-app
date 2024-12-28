package sk.project.springboot_mvc_secure_app.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.entity.User;
import sk.project.springboot_mvc_secure_app.service.EventService;
import sk.project.springboot_mvc_secure_app.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;

    @GetMapping("user/profile")
    public String showProfilePage() {
        return "user/profile";
    }

    @PostMapping("/register")
    public String registerUser(HttpServletRequest request, @ModelAttribute("user") User user, Model model, @RequestParam String password_1, @RequestParam String password_2) {

        try{
            userService.save(user, password_1, password_2, request);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("user", user);
            return "register";
        }

        List<Event> publicEvents = eventService.findAllPublicEvents();

        model.addAttribute("events", publicEvents);

        return "redirect:/events?loggedin=true";
    }

}
