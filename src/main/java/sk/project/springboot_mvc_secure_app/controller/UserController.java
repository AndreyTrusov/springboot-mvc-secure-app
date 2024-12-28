package sk.project.springboot_mvc_secure_app.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sk.project.springboot_mvc_secure_app.dto.UserPasswordDTO;
import sk.project.springboot_mvc_secure_app.dto.UserProfileDTO;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.entity.User;
import sk.project.springboot_mvc_secure_app.service.EventService;
import sk.project.springboot_mvc_secure_app.service.UserService;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private EventService eventService;


    @GetMapping("/user/profile")
    public String showProfilePage(Model model) {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();

        User userInfo = userService.findByEmail(currentUsername);

        UserPasswordDTO passwordDTO = new UserPasswordDTO();
        passwordDTO.setId(userInfo.getId());

        model.addAttribute("user", userInfo);
        model.addAttribute("userPasswordDTO", passwordDTO);

        return "user/profile";
    }

    @PostMapping("/user/profile/info")
    public String updateUserProfile(@Validated @ModelAttribute("user") UserProfileDTO user,
                                    BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userPasswordDTO", new UserPasswordDTO());
            return "redirect:/user/profile?error";
        }
        if (userService.updateUser(user)) {
            return "redirect:/user/profile?edit_profile_updated";
        } else {
            return "redirect:/user/profile?edit_profile_fail";
        }
    }

    @PostMapping("/user/profile/password")
    public String updateUserPassword(@Valid UserPasswordDTO userPasswordDTO,
                                     BindingResult bindingResult,
                                     RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("passwordChangeError", bindingResult.getAllErrors().get(0).getDefaultMessage());
            return "redirect:/user/profile?error";
        }

        if (!userPasswordDTO.getNewPassword().equals(userPasswordDTO.getConfirmPassword())) {
//            bindingResult.rejectValue("confirmPassword", "error.passwordChangeDTO", "Passwords do not match");
            redirectAttributes.addFlashAttribute("passwordChangeError", "Passwords do not match");
            return "redirect:/user/profile?error";
        }

        if (userService.updateUserPassword(userPasswordDTO)) {
            redirectAttributes.addFlashAttribute("passwordChangeSuccess", "Password changed successfully!");
            return "redirect:/user/profile?edit_password_updated";
        } else {
            redirectAttributes.addFlashAttribute("passwordChangeError", "Password update failed.");
            return "redirect:/user/profile?edit_password_fail";
        }
    }



    @PostMapping("/register")
    public String registerUser(HttpServletRequest request, @ModelAttribute("user") User user, Model model, @RequestParam String password_1, @RequestParam String password_2) {

        try {
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
