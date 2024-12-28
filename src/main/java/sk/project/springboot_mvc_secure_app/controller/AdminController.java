package sk.project.springboot_mvc_secure_app.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.project.springboot_mvc_secure_app.dto.AdminProfileDTO;
import sk.project.springboot_mvc_secure_app.dto.UserPasswordDTO;
import sk.project.springboot_mvc_secure_app.dto.UserProfileDTO;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.entity.User;
import sk.project.springboot_mvc_secure_app.service.EventService;
import sk.project.springboot_mvc_secure_app.service.UserService;

import java.util.ArrayList;
import java.util.List;


@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @GetMapping("/admin/admin-profile")
    public String showProfilePage(Model model) {

        List<AdminProfileDTO> users = userService.findAllActiveUsers();

        model.addAttribute("users", users);

        return "admin/admin-profile";
    }

//    @PostMapping("/admin/updateUserRole")
//    public String updateUserProfile(@Validated @ModelAttribute("user") AdminProfileDTO user,
//                                    BindingResult bindingResult, Model model) {
//        if (bindingResult.hasErrors()) {
//            model.addAttribute("userPasswordDTO", new UserPasswordDTO());
//            return "redirect:/user/profile?error";
//        }
//        if (userService.updateUser(user)) {
//            return "redirect:/user/profile?edit_profile_updated";
//        } else {
//            return "redirect:/user/profile?edit_profile_fail";
//        }

//        return "admin/admin-profile";
//    }
}
