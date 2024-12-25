package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
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

