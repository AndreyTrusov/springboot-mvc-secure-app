package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

@Entity
@Table(name = "creator_event")
public class CreatorEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CreatorEventID")
    private Long creatorEventId;

    @NotNull(message = "Event ID is required")
    @Column(name = "EventID", nullable = false)
    private Long eventId;

    @NotNull(message = "Creator ID is required")
    @Column(name = "UserID", nullable = false)
    private Long userId;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDate createdAt;

    public CreatorEvent() {
        this.createdAt = LocalDate.now();
    }

    public CreatorEvent(Long eventId, Long userId) {
        this.eventId = eventId;
        this.userId = userId;
        this.createdAt = LocalDate.now();
    }

    public Long getCreatorEventId() {
        return creatorEventId;
    }

    public void setCreatorEventId(Long creatorEventId) {
        this.creatorEventId = creatorEventId;
    }

    public @NotNull(message = "Event ID is required") Long getEventId() {
        return eventId;
    }

    public void setEventId(@NotNull(message = "Event ID is required") Long eventId) {
        this.eventId = eventId;
    }

    public @NotNull(message = "Creator ID is required") Long getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "Creator ID is required") Long userId) {
        this.userId = userId;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "CreatorEvent{" +
                "creatorEventId=" + creatorEventId +
                ", eventId=" + eventId +
                ", creatorId=" + userId +
                ", createdAt=" + createdAt +
                '}';
    }
}

