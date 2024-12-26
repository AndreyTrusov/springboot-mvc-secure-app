package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.CreatorEventRepository;
import sk.project.springboot_mvc_secure_app.entity.CreatorEvent;

import java.util.List;
import java.util.Optional;

@Service
public class CreatorEventServiceImpl implements CreatorEventService {

    private final CreatorEventRepository creatorEventRepository;

    @Autowired
    public CreatorEventServiceImpl(CreatorEventRepository creatorEventRepository) {
        this.creatorEventRepository = creatorEventRepository;
    }

    @Override
    public List<CreatorEvent> findByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid User ID");
        }
        return creatorEventRepository.findByUserId(userId);
    }

    @Override
    public Optional<CreatorEvent> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid CreatorEvent ID");
        }
        return creatorEventRepository.findById(id);
    }

    @Override
    @Transactional
    public CreatorEvent save(CreatorEvent creatorEvent) {
        if (creatorEvent == null) {
            throw new IllegalArgumentException("CreatorEvent object cannot be null");
        }
        return creatorEventRepository.save(creatorEvent);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid CreatorEvent ID");
        }

        boolean exists = creatorEventRepository.existsById(id);

        if (exists) {
            creatorEventRepository.deleteById(id);
            System.out.println("CreatorEvent with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("CreatorEvent with ID " + id + " not found.");
            return false;
        }
    }
}

