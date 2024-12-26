package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.LearningCenterRepository;
import sk.project.springboot_mvc_secure_app.entity.LearningCenter;

import java.util.List;
import java.util.Optional;

@Service
public class LearningCenterServiceImpl implements LearningCenterService {

    private final LearningCenterRepository learningCenterRepository;

    @Autowired
    public LearningCenterServiceImpl(LearningCenterRepository learningCenterRepository) {
        this.learningCenterRepository = learningCenterRepository;
    }

    @Override
    public List<LearningCenter> findAll() {
        return learningCenterRepository.findAll();
    }

    @Override
    public Optional<LearningCenter> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        return Optional.ofNullable(learningCenterRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("LearningCenter not found with id: " + id)));
    }

    @Override
    @Transactional
    public LearningCenter save(LearningCenter learningCenter) {
        if (learningCenter == null) {
            throw new IllegalArgumentException("LearningCenter object cannot be null");
        }
        return learningCenterRepository.save(learningCenter);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        boolean exists = learningCenterRepository.existsById(id);

        if (exists) {
            learningCenterRepository.deleteById(id);
            System.out.println("LearningCenter with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("LearningCenter with ID " + id + " not found.");
            return false;
        }
    }
}

