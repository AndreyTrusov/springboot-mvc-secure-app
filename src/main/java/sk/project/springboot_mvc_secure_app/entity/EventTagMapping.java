package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "event_tag_mapping")
public class EventTagMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tag_mapping_id", nullable = false)
    private Long tagMappingId;

    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @Column(name = "tag_id", nullable = false)
    private Long tagId;

    @Column(name = "mapped_at", updatable = false)
    private LocalDate mappedAt;

    public EventTagMapping() {
    }

    public Long getTagMappingId() {
        return tagMappingId;
    }

    public void setTagMappingId(Long tagMappingId) {
        this.tagMappingId = tagMappingId;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }

    public LocalDate getMappedAt() {
        return mappedAt;
    }

    public void setMappedAt(LocalDate mappedAt) {
        this.mappedAt = mappedAt;
    }

    @Override
    public String toString() {
        return "EventTagMapping{" +
                ", eventId=" + eventId +
                ", tagId=" + tagId +
                ", mappedAt=" + mappedAt +
                '}';
    }

}

