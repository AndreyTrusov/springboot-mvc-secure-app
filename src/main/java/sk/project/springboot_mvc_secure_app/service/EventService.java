package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.Event;

import java.util.List;
import java.util.Optional;

public interface EventService {
    List<Event> findAllPublicEvents();
    List<Event> findAllPrivateEvents();
    List<Event> findByCreatedBy(Long userId);
    Optional<Event> findById(Long id);
    List<Event> findByName(String name);
    Event save(Event event);
    boolean deleteById(Long id);
}
