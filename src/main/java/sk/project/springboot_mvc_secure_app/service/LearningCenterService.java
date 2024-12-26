package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.LearningCenter;

import java.util.List;
import java.util.Optional;

public interface LearningCenterService {
    List<LearningCenter> findAll();
//    LearningCenter findByName(String name);
//    List<LearningCenter> findByCapacityGreaterThan(int capacity);
    Optional<LearningCenter> findById(Long id);
    LearningCenter save(LearningCenter learningCenter);
    boolean deleteById(Long id);
}
