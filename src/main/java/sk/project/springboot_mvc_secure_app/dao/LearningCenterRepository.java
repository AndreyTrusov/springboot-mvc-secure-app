package sk.project.springboot_mvc_secure_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.project.springboot_mvc_secure_app.entity.LearningCenter;

import java.util.List;

@Repository
public interface LearningCenterRepository extends JpaRepository<LearningCenter, Long> {
    List<LearningCenter> findAll();
    List<LearningCenter> findByCapacityGreaterThan(int capacity);
    LearningCenter findByName(String name);
}
