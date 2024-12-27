package sk.project.springboot_mvc_secure_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sk.project.springboot_mvc_secure_app.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("user/profile")
    public String showProfilePage() {
        return "user/profile";
    }

}
