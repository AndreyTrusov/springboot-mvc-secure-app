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

//    @RequestMapping("/error")
//    public String handleError(Model model) {
//        model.addAttribute("status", "Unknown Error");
//        model.addAttribute("message", "An unexpected error occurred.");
//
//        Throwable throwable = (Throwable) model.asMap().get("javax.servlet.error.exception");
//        if (throwable != null) {
//            model.addAttribute("message", throwable.getMessage());
//        }
//
//        return "error";
//    }
}
