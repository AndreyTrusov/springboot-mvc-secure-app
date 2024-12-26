package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventFeedbackRepository;
import sk.project.springboot_mvc_secure_app.entity.EventFeedback;

import java.util.List;

@Service
public class EventFeedbackServiceImpl implements EventFeedbackService {

    private final EventFeedbackRepository eventFeedbackRepository;

    @Autowired
    public EventFeedbackServiceImpl(EventFeedbackRepository eventFeedbackRepository) {
        this.eventFeedbackRepository = eventFeedbackRepository;
    }

    @Override
    public List<EventFeedback> findByEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            throw new IllegalArgumentException("Invalid Event ID");
        }
        return eventFeedbackRepository.findByEventId(eventId);
    }

    @Override
    @Transactional
    public EventFeedback save(EventFeedback feedback) {
        if (feedback == null) {
            throw new IllegalArgumentException("EventFeedback object cannot be null");
        }
        return eventFeedbackRepository.save(feedback);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid Feedback ID");
        }

        boolean exists = eventFeedbackRepository.existsById(id);

        if (exists) {
            eventFeedbackRepository.deleteById(id);
            System.out.println("EventFeedback with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("EventFeedback with ID " + id + " not found.");
            return false;
        }
    }
}

