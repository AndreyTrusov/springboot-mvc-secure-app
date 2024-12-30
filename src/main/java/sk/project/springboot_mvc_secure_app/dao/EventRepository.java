package sk.project.springboot_mvc_secure_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.project.springboot_mvc_secure_app.entity.Event;

import java.util.List;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByIsPrivateFalse();
    List<Event> findByNameContainingIgnoreCase(String name);
    List<Event> findByCreatedBy(Long userId);
    List<Event> findByIsPrivateTrue();
    List<Event> findByName(String name);
}
