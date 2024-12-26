package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.EventFeedback;

import java.util.List;
import java.util.Optional;

public interface EventFeedbackService {
    List<EventFeedback> findByEventId(Long eventId);
//    List<EventFeedback> findByUserId(Long userId);
//    Optional<EventFeedback> findById(Long id);
    EventFeedback save(EventFeedback feedback);
    boolean deleteById(Long id);
}
