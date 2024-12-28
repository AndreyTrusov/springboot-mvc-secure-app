package sk.project.springboot_mvc_secure_app.service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public User save(User user, String password_1, String password_2, HttpServletRequest request) {

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

        newUser.setLastLogin(LocalDate.now());
        newUser.setRole(newRole);

        authenticateUser(user, request);

        return userRepository.save(newUser);
    }

    private void authenticateUser(User user, HttpServletRequest request) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                user.getEmail(),
                user.getPasswordHash(),
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );

        SecurityContextHolder.getContext().setAuthentication(authToken);

        HttpSession session = request.getSession(true);
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());
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

