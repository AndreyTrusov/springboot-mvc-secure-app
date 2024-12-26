package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.RoleRepository;
import sk.project.springboot_mvc_secure_app.entity.Role;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }


    @Override
    public Optional<Role> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        return roleRepository.findById(id);
    }

    @Override
    @Transactional
    public Role save(Role role) {
        if (role == null) {
            throw new IllegalArgumentException("Role object cannot be null");
        }
        return roleRepository.save(role);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        boolean exists = roleRepository.existsById(id);

        if (exists) {
            roleRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

