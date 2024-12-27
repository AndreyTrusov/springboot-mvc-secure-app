package sk.project.springboot_mvc_secure_app.service;

import sk.project.springboot_mvc_secure_app.entity.EventTagMapping;

import java.util.List;

public interface EventTagMappingService {
    List<EventTagMapping> findByEventId(Long eventId);

    List<EventTagMapping> findByTagId(Long tagId);

    EventTagMapping save(EventTagMapping eventTagMapping);

    boolean deleteByEventId(Long eventId);

    boolean deleteById(Long tagMappingId);
}
