package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.EventMaterials;

import java.util.List;
import java.util.Optional;

public interface EventMaterialsService {
    List<EventMaterials> findByEventId(Long eventId);
//    Optional<EventMaterials> findById(Long id);
    EventMaterials save(EventMaterials materials);
    boolean deleteById(Long id);
}
