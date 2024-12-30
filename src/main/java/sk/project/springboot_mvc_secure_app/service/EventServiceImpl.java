package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventRepository;
import sk.project.springboot_mvc_secure_app.dao.UserRepository;
import sk.project.springboot_mvc_secure_app.entity.Event;
import sk.project.springboot_mvc_secure_app.entity.User;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private UserRepository userRepository;

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

        String currentUserEmail = null;

        try {
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

            if (principal instanceof UserDetails) {
                UserDetails userDetails = (UserDetails) principal;
                currentUserEmail = userDetails.getUsername();
            } else if (principal instanceof String) {
                currentUserEmail = (String) principal;
            } else {
                throw new IllegalStateException("Authenticated principal is not of type UserDetails or String");
            }
        } catch (Exception e) {
            throw new IllegalStateException("Error retrieving user email from security context +" + e, e);
        }

        if (currentUserEmail == null || currentUserEmail.isEmpty()) {
            throw new IllegalStateException("Authenticated user email is null or empty");
        }

        User currentUser = userRepository.findByEmail(currentUserEmail);
        if (currentUser == null) {
            throw new IllegalStateException("Authenticated user not found in the database");
        }

        Event savedEvent = new Event();
        savedEvent.setCreatedAt(LocalDate.now());
        savedEvent.setName(event.getName());
        savedEvent.setDescription(event.getDescription());
        savedEvent.setCreatedBy(currentUser.getId());

        return eventRepository.save(savedEvent);
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

