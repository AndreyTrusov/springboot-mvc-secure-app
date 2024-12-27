package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.UserRepository;
import sk.project.springboot_mvc_secure_app.entity.Role;
import sk.project.springboot_mvc_secure_app.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @Qualifier("userDetailsManager")
    private InMemoryUserDetailsManager userDetailsManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findAllActiveUsers() {
        return userRepository.findAllByIsActiveTrue();
    }

    @Override
    public Optional<User> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        return userRepository.findById(id);
    }

    @Override
    public User findByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    @Transactional
    public User save(User user, String password_1, String password_2) {

        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }

        if (!password_1.equals(password_2)) {
            throw new IllegalArgumentException("Passwords do not match");
        }

        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Email is already in use");
        }

        User newUser = new User();
        Role newRole = new Role();

        newRole.setRoleId(1L);

        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        newUser.setPasswordHash(passwordEncoder.encode(password_1));

        UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
                .username(user.getName())
                .password("{bcrypt}" + newUser.getPasswordHash())
                .roles("USER")
                .build();

        userDetailsManager.createUser(userDetails);

        newUser.setLastLogin(LocalDate.now());
        newUser.setRole(newRole);
        return userRepository.save(newUser);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        boolean exists = userRepository.existsById(id);

        if (exists) {
            userRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

