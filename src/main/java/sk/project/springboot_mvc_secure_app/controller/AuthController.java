package sk.project.springboot_mvc_secure_app.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sk.project.springboot_mvc_secure_app.entity.User;
import sk.project.springboot_mvc_secure_app.service.UserService;

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
}
