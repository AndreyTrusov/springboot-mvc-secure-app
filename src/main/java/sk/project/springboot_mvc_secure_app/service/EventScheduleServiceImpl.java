package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventScheduleRepository;
import sk.project.springboot_mvc_secure_app.entity.EventSchedule;

import java.util.List;
import java.util.Optional;

@Service
public class EventScheduleServiceImpl implements EventScheduleService {

    private final EventScheduleRepository eventScheduleRepository;

    @Autowired
    public EventScheduleServiceImpl(EventScheduleRepository eventScheduleRepository) {
        this.eventScheduleRepository = eventScheduleRepository;
    }

    @Override
    public List<EventSchedule> findByEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            throw new IllegalArgumentException("Invalid Event ID");
        }
        return eventScheduleRepository.findByEventId(eventId);
    }

    @Override
    public List<EventSchedule> findByLearningCenterId(Long learningCenterId) {
        if (learningCenterId == null || learningCenterId <= 0) {
            throw new IllegalArgumentException("Invalid Learning Center ID");
        }
        return eventScheduleRepository.findByLearningCenterId(learningCenterId);
    }

    @Override
    public Optional<EventSchedule> findById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid Schedule ID");
        }
        return eventScheduleRepository.findById(id);
    }

    @Override
    @Transactional
    public EventSchedule save(EventSchedule schedule) {
        if (schedule == null) {
            throw new IllegalArgumentException("EventSchedule object cannot be null");
        }
        return eventScheduleRepository.save(schedule);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid Schedule ID");
        }

        boolean exists = eventScheduleRepository.existsById(id);

        if (exists) {
            eventScheduleRepository.deleteById(id);
            System.out.println("EventSchedule with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("EventSchedule with ID " + id + " not found.");
            return false;
        }
    }
}

