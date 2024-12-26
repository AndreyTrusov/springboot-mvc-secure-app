package sk.project.springboot_mvc_secure_app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.project.springboot_mvc_secure_app.entity.EventMaterials;

import java.util.List;

@Repository
public interface EventMaterialsRepository extends JpaRepository<EventMaterials, Long> {
    List<EventMaterials> findByEventId(Long eventId);
}
