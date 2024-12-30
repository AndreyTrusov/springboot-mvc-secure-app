package sk.project.springboot_mvc_secure_app.service;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;
import jakarta.servlet.http.HttpServletRequest;
import org.hibernate.service.spi.ServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.RoleRepository;
import sk.project.springboot_mvc_secure_app.dto.AdminProfileDTO;
import sk.project.springboot_mvc_secure_app.dto.UserPasswordDTO;
import sk.project.springboot_mvc_secure_app.dto.UserProfileDTO;
import sk.project.springboot_mvc_secure_app.dao.UserRepository;
import sk.project.springboot_mvc_secure_app.entity.Role;
import sk.project.springboot_mvc_secure_app.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<AdminProfileDTO> findAllActiveUsers() {
        List<User> usersList = userRepository.findAllByIsActiveTrue();

        List<AdminProfileDTO> newUsersList = usersList.stream()
                .map(user -> new AdminProfileDTO(user.getId(), user.getName(), user.getRole()))
                .collect(Collectors.toList());

        return newUsersList;
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
    public User findByEmail(String email) {
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

        if (userRepository.findByEmail(user.getEmail()) != null) {
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

    @Override
    @Transactional
    public boolean updateUser(UserProfileDTO user) {

        if (user == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }

        UserProfileDTO newUser = new UserProfileDTO();

        newUser.setId(user.getId());
        newUser.setName(user.getName());
        newUser.setPhoneNumber(user.getPhoneNumber());
        newUser.setCompany(user.getCompany());
        newUser.setJobTitle(user.getJobTitle());
        newUser.setAddress(user.getAddress());
        newUser.setDateOfBirth(user.getDateOfBirth());
        newUser.setGender(user.getGender());

        return userRepository.updateUser(newUser) == 1;
    }

    @Override
    @Transactional
    public boolean updateUserRole(Long id, String role) {
        try {
            Optional<User> userOptional = userRepository.findById(id);
            if (!userOptional.isPresent()) {
                return false;
            }

            User user = userOptional.get();

            Role newRole = roleRepository.findByRoleName("ROLE_" + role.toUpperCase());
            if (newRole == null) {
                return false;
            }

            user.setRole(newRole);
            userRepository.updateUserRole(user.getId(), user.getRole().getRoleId());

            return true;

        } catch (Exception ex) {
            throw new ServiceException("Unexpected error occurred while updating user role."+ex.getMessage(), ex);
        }
    }

    @Override
    @Transactional
    public boolean updateUserPassword(UserPasswordDTO userPasswordDTO) {

        if (userPasswordDTO == null) {
            throw new IllegalArgumentException("User object cannot be null");
        }

        UserPasswordDTO newUser = new UserPasswordDTO();

        newUser.setId(userPasswordDTO.getId());

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        newUser.setPasswordHash(passwordEncoder.encode(userPasswordDTO.getNewPassword()));

        return userRepository.updateUserPassword(newUser) == 1;
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

