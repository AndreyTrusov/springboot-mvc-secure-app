package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.time.LocalDate;

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

    public Long getFeedbackId() {
        return feedbackId;
    }

    public void setFeedbackId(Long feedbackId) {
        this.feedbackId = feedbackId;
    }

    public @NotNull(message = "Event ID is required") Long getEventId() {
        return eventId;
    }

    public void setEventId(@NotNull(message = "Event ID is required") Long eventId) {
        this.eventId = eventId;
    }

    public @NotNull(message = "User ID is required") Long getUserId() {
        return userId;
    }

    public void setUserId(@NotNull(message = "User ID is required") Long userId) {
        this.userId = userId;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public @NotNull(message = "Rating is required") Integer getRating() {
        return rating;
    }

    public void setRating(@NotNull(message = "Rating is required") Integer rating) {
        this.rating = rating;
    }

    public Boolean getAnonymous() {
        return isAnonymous;
    }

    public void setAnonymous(Boolean anonymous) {
        isAnonymous = anonymous;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
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

