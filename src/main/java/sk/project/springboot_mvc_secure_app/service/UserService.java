package sk.project.springboot_mvc_secure_app.service;

import jakarta.servlet.http.HttpServletRequest;
import sk.project.springboot_mvc_secure_app.dto.AdminProfileDTO;
import sk.project.springboot_mvc_secure_app.dto.UserPasswordDTO;
import sk.project.springboot_mvc_secure_app.dto.UserProfileDTO;
import sk.project.springboot_mvc_secure_app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    List<AdminProfileDTO> findAllActiveUsers();
    Optional<User> findById(Long id);
    User findByEmail(String email);
    User findByName(String name);
    User save(User user, String password_1, String password_2, HttpServletRequest request);
    boolean updateUser(UserProfileDTO user);
    boolean updateUserRole(Long id, String role);
    boolean updateUserPassword(UserPasswordDTO userPasswordDTO);
    boolean deleteById(Long id);
}
