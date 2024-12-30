package sk.project.springboot_mvc_secure_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.project.springboot_mvc_secure_app.dto.AdminProfileDTO;
import sk.project.springboot_mvc_secure_app.service.UserService;

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

    @PostMapping("/admin/updateUserRole")
    public String updateUserRole(@RequestParam("id") Long id,
                                 @RequestParam("role") String role,
                                 RedirectAttributes redirectAttributes) {

        try {
            boolean updated = userService.updateUserRole(id, role);

            if (updated) {
                redirectAttributes.addFlashAttribute("success", "User role updated successfully!");
            } else {
                redirectAttributes.addFlashAttribute("error", "Failed to update user role.");
            }
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "An error occurred: " + e.getMessage());
        }

        return "redirect:/admin/admin-profile";
    }
}
