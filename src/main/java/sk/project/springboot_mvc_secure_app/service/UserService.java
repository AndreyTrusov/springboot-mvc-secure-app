package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> findAll();
    List<User> findAllActiveUsers();
    Optional<User> findById(Long id);
    User findByEmail(String email);
    User save(User user);
    boolean deleteById(Long id);
}
