package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventTagMappingRepository;
import sk.project.springboot_mvc_secure_app.dao.UserRepository;
import sk.project.springboot_mvc_secure_app.entity.EventTagMapping;
import sk.project.springboot_mvc_secure_app.entity.User;

import java.util.List;
import java.util.Optional;

@Service
public class EventTagMappingServiceImpl implements EventTagMappingService {

    private final EventTagMappingRepository eventTagMappingRepository;

    @Autowired
    public EventTagMappingServiceImpl(EventTagMappingRepository eventTagMappingRepository) {
        this.eventTagMappingRepository = eventTagMappingRepository;
    }

    @Override
    public List<EventTagMapping> findByEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            throw new IllegalArgumentException("Invalid Event ID");
        }
        return eventTagMappingRepository.findByEventId(eventId);
    }

    @Override
    public List<EventTagMapping> findByTagId(Long tagId) {
        if (tagId == null || tagId <= 0) {
            throw new IllegalArgumentException("Invalid Tag ID");
        }
        return eventTagMappingRepository.findByTagId(tagId);
    }

    @Override
    @Transactional
    public EventTagMapping save(EventTagMapping eventTagMapping) {
        if (eventTagMapping == null) {
            throw new IllegalArgumentException("EventTagMapping object cannot be null");
        }
        return eventTagMappingRepository.save(eventTagMapping);
    }

    @Override
    @Transactional
    public boolean deleteByEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            throw new IllegalArgumentException("Invalid Event ID");
        }

        boolean isDeleted = eventTagMappingRepository.deleteByEventId(eventId);

        if (isDeleted) {
            System.out.println("EventTagMapping records for Event ID " + eventId + " deleted successfully.");
        } else {
            System.out.println("No EventTagMapping records found for Event ID " + eventId);
        }

        return isDeleted;
    }
}

