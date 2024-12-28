package sk.project.springboot_mvc_secure_app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sk.project.springboot_mvc_secure_app.entity.User;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        return "login?logout";
    }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "login?error";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @GetMapping("/notFound")
    public String notFound() {
        return "not-found";
    }
}
