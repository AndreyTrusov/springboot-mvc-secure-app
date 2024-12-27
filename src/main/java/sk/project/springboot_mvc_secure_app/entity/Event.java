package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "event")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @NotBlank(message = "Event name is required")
    @Size(min = 3, max = 100, message = "Event name must be between 3 and 100 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_private", nullable = false)
    private Boolean isPrivate = false;

    @Column(name = "created_by", nullable = false)
    private Long createdBy;

    @Column(name = "description")
    private String description;

    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    public Event() {
        this.createdAt = LocalDate.now();
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public @NotBlank(message = "Event name is required") @Size(min = 3, max = 100, message = "Event name must be between 3 and 100 characters") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Event name is required") @Size(min = 3, max = 100, message = "Event name must be between 3 and 100 characters") String name) {
        this.name = name;
    }

    public Boolean getPrivate() {
        return isPrivate;
    }

    public void setPrivate(Boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public Long getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Long createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", name='" + name + '\'' +
                ", isPrivate=" + isPrivate +
                ", createdBy=" + createdBy +
                ", description='" + description + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
