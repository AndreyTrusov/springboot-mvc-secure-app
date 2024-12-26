package sk.project.springboot_mvc_secure_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.project.springboot_mvc_secure_app.entity.EventSubscription;

import java.util.List;

@Repository
public interface EventSubscriptionRepository extends JpaRepository<EventSubscription, Long> {
    List<EventSubscription> findByUserId(Long userId);
    List<EventSubscription> findByEventId(Long eventId);
}
