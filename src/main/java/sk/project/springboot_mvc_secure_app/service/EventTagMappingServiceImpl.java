package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventTagMappingRepository;
import sk.project.springboot_mvc_secure_app.entity.EventTagMapping;

import java.util.List;

@Service
public class EventTagMappingServiceImpl implements EventTagMappingService {

    private final EventTagMappingRepository repository;

    @Autowired
    public EventTagMappingServiceImpl(EventTagMappingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<EventTagMapping> findByEventId(Long eventId) {
        return repository.findByEventId(eventId);
    }

    @Override
    public List<EventTagMapping> findByTagId(Long tagId) {
        return repository.findByTagId(tagId);
    }

    @Override
    public EventTagMapping save(EventTagMapping eventTagMapping) {
        if (eventTagMapping == null || eventTagMapping.getEventId() == null || eventTagMapping.getTagId() == null) {
            throw new IllegalArgumentException("EventTagMapping or its required fields cannot be null");
        }
        return repository.save(eventTagMapping);
    }

    @Override
    @Transactional
    public boolean deleteByEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            throw new IllegalArgumentException("Invalid event ID");
        }

        int rowsDeleted = repository.deleteByEventId(eventId);
        return rowsDeleted > 0;
    }

    @Override
    @Transactional
    public boolean deleteById(Long tagMappingId) {
        if (tagMappingId == null || tagMappingId <= 0) {
            throw new IllegalArgumentException("Invalid tagMapping ID");
        }

        boolean exists = repository.existsById(tagMappingId);
        if (exists) {
            repository.deleteById(tagMappingId);
            return true;
        }
        return false;
    }
}

