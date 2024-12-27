package sk.project.springboot_mvc_secure_app.dao;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import sk.project.springboot_mvc_secure_app.entity.EventTagMapping;

import java.util.List;

@Repository
public interface EventTagMappingRepository extends JpaRepository<EventTagMapping, Long> {
    List<EventTagMapping> findByEventId(Long eventId);

    List<EventTagMapping> findByTagId(Long tagId);

    boolean existsByEventId(Long eventId);

    @Transactional
    int deleteByEventId(Long eventId);
}
