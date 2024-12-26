package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventSubscriptionRepository;
import sk.project.springboot_mvc_secure_app.entity.EventSubscription;

import java.util.List;
import java.util.Optional;

@Service
public class EventSubscriptionServiceImpl implements EventSubscriptionService {

    private final EventSubscriptionRepository eventSubscriptionRepository;

    @Autowired
    public EventSubscriptionServiceImpl(EventSubscriptionRepository eventSubscriptionRepository) {
        this.eventSubscriptionRepository = eventSubscriptionRepository;
    }

    @Override
    public List<EventSubscription> findByUserId(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid User ID");
        }
        return eventSubscriptionRepository.findByUserId(userId);
    }

    @Override
    public Optional<EventSubscription> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid Subscription ID");
        }

        return eventSubscriptionRepository.findById(id);
    }

    @Override
    @Transactional
    public EventSubscription save(EventSubscription subscription) {
        if (subscription == null) {
            throw new IllegalArgumentException("EventSubscription object cannot be null");
        }
        return eventSubscriptionRepository.save(subscription);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid Subscription ID");
        }

        boolean exists = eventSubscriptionRepository.existsById(id);

        if (exists) {
            eventSubscriptionRepository.deleteById(id);
            System.out.println("EventSubscription with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("EventSubscription with ID " + id + " not found.");
            return false;
        }
    }
}

