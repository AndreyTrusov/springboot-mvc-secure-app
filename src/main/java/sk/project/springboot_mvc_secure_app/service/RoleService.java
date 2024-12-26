package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.Role;

import java.util.Optional;

public interface RoleService {
    Optional<Role> findById(Long id);
    Role save(Role role);
    boolean deleteById(Long id);
}
