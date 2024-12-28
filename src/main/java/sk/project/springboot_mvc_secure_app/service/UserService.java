package sk.project.springboot_mvc_secure_app.service;

import jakarta.servlet.http.HttpServletRequest;
import sk.project.springboot_mvc_secure_app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    List<User> findAllActiveUsers();
    Optional<User> findById(Long id);
    Optional<User> findByEmail(String email);
    User findByName(String name);
    User save(User user, String password_1, String password_2, HttpServletRequest request);
    boolean deleteById(Long id);
}
