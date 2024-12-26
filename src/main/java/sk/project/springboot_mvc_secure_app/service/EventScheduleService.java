package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.EventSchedule;

import java.util.List;
import java.util.Optional;

public interface EventScheduleService {
    List<EventSchedule> findByEventId(Long eventId);
    List<EventSchedule> findByLearningCenterId(Long learningCenterId);
    Optional<EventSchedule> findById(Long id);
    EventSchedule save(EventSchedule schedule);
    boolean deleteById(Long id);
}
