package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.CreatorEvent;

import java.util.List;
import java.util.Optional;

public interface CreatorEventService {
    List<CreatorEvent> findByUserId(Long userId);
    Optional<CreatorEvent> findById(Long id);
    CreatorEvent save(CreatorEvent createEvent);
    boolean deleteById(Long id);
}
