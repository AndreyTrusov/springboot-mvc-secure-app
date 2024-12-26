package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.EventSubscription;

import java.util.List;
import java.util.Optional;

public interface EventSubscriptionService {
    List<EventSubscription> findByUserId(Long userId);
//    List<EventSubscription> findByEventId(Long eventId);
    Optional<EventSubscription> findById(Long id);
    EventSubscription save(EventSubscription subscription);
    boolean deleteById(Long id);
}