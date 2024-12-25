package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Entity
@Table(name = "event_feedback")
public class EventFeedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "FeedbackId")
    private Long feedbackId;

    @NotNull(message = "Event ID is required")
    @Column(name = "EventId", nullable = false)
    private Long eventId;

    @NotNull(message = "User ID is required")
    @Column(name = "UserId", nullable = false)
    private Long userId;

    @Column(name = "Feedback", length = 255)
    private String feedback;

    @NotNull(message = "Rating is required")
    @Column(name = "Rating", nullable = false)
    private Integer rating;

    @Column(name = "IsAnonymous", nullable = false)
    private Boolean isAnonymous = false;

    @Column(name = "CreatedAt", nullable = false, updatable = false)
    private LocalDate createdAt;

    public EventFeedback() {
        this.createdAt = LocalDate.now();
    }

    public EventFeedback(Long eventId, Long userId, String feedback, Integer rating, Boolean isAnonymous) {
        this.eventId = eventId;
        this.userId = userId;
        this.feedback = feedback;
        this.rating = rating;
        this.isAnonymous = isAnonymous;
        this.createdAt = LocalDate.now();
    }

    @Override
    public String toString() {
        return "EventFeedback{" +
                "feedbackId=" + feedbackId +
                ", eventId=" + eventId +
                ", userId=" + userId +
                ", feedback='" + feedback + '\'' +
                ", rating=" + rating +
                ", isAnonymous=" + isAnonymous +
                ", createdAt=" + createdAt +
                '}';
    }
}

