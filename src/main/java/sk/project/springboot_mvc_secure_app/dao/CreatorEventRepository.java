package sk.project.springboot_mvc_secure_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.project.springboot_mvc_secure_app.entity.CreatorEvent;

import java.util.List;

@Repository
public interface CreatorEventRepository extends JpaRepository<CreatorEvent, Long> {
    List<CreatorEvent> findByUserId(Long userId);
}