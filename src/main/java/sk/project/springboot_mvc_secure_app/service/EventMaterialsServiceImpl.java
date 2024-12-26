package sk.project.springboot_mvc_secure_app.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.project.springboot_mvc_secure_app.dao.EventMaterialsRepository;
import sk.project.springboot_mvc_secure_app.entity.EventMaterials;

import java.util.List;

@Service
public class EventMaterialsServiceImpl implements EventMaterialsService {

    private final EventMaterialsRepository eventMaterialsRepository;

    @Autowired
    public EventMaterialsServiceImpl(EventMaterialsRepository eventMaterialsRepository) {
        this.eventMaterialsRepository = eventMaterialsRepository;
    }

    @Override
    public List<EventMaterials> findByEventId(Long eventId) {
        if (eventId == null || eventId <= 0) {
            throw new IllegalArgumentException("Invalid Event ID");
        }
        return eventMaterialsRepository.findByEventId(eventId);
    }

    @Override
    @Transactional
    public EventMaterials save(EventMaterials materials) {
        if (materials == null) {
            throw new IllegalArgumentException("EventMaterials object cannot be null");
        }
        return eventMaterialsRepository.save(materials);
    }

    @Override
    @Transactional
    public boolean deleteById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid Material ID");
        }

        boolean exists = eventMaterialsRepository.existsById(id);

        if (exists) {
            eventMaterialsRepository.deleteById(id);
            System.out.println("EventMaterials with ID " + id + " deleted successfully.");
            return true;
        } else {
            System.out.println("EventMaterials with ID " + id + " not found.");
            return false;
        }
    }
}

