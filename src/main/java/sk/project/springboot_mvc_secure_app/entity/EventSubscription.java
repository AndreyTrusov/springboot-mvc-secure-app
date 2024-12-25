package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "event_subscription")
public class EventSubscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SubscriptionID")
    private Long subscriptionId;

    @NotNull(message = "User ID is required")
    @Column(name = "UserID", nullable = false)
    private Long userId;

    @NotNull(message = "Event ID is required")
    @Column(name = "EventID", nullable = false)
    private Long eventId;

    @Column(name = "StartedAt", nullable = false, updatable = false)
    private LocalDate startedAt;

    @Column(name = "Active", nullable = false)
    private Boolean active;

    public EventSubscription() {
        this.startedAt = LocalDate.now();
        this.active = true;
    }

    public EventSubscription(Long userId, Long eventId, Boolean active) {
        this.userId = userId;
        this.eventId = eventId;
        this.startedAt = LocalDate.now();
        this.active = active;
    }

    @Override
    public String toString() {
        return "EventSubscription{" +
                "subscriptionId=" + subscriptionId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", startedAt=" + startedAt +
                ", active=" + active +
                '}';
    }
}

