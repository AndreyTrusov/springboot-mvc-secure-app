package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventRepository;
import sk.project.springboot_mvc_secure_app.entity.Event;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public List<Event> findAllPublicEvents() {
        return eventRepository.findByIsPrivateFalse();
    }

    @Override
    public List<Event> findAllPrivateEvents() {
        return eventRepository.findByIsPrivateTrue();
    }

    @Override
    public List<Event> findByCreatedBy(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID");
        }
        return eventRepository.findByCreatedBy(userId);
    }

    @Override
    public Optional<Event> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        return eventRepository.findById(id);
    }

    @Override
    public List<Event> findByName(String name) {
        return eventRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    @Transactional
    public Event save(Event event) {
        if (event == null) {
            throw new IllegalArgumentException("Event object cannot be null");
        }
        return eventRepository.save(event);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID");
        }

        boolean exists = eventRepository.existsById(id);

        if (exists) {
            eventRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}

