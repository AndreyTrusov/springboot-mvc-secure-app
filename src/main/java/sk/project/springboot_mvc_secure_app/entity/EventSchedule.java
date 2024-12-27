package sk.project.springboot_mvc_secure_app.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "event_schedule")
public class EventSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long scheduleId;

    @NotNull(message = "Event ID is required")
    @Column(name = "event_id", nullable = false)
    private Long eventId;

    @NotNull(message = "Learning Center ID is required")
    @Column(name = "learning_center_id", nullable = false)
    private Long learningCenterId;

    @NotNull(message = "Start date is required")
    @FutureOrPresent(message = "Start date cannot be in the past")
    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @NotNull(message = "End date is required")
    @Future(message = "End date must be in the future")
    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    @Column(name = "duration", nullable = false)
    private Integer duration;

    @Min(value = 1, message = "Max tickets must be at least 1")
    @Column(name = "max_tickets", nullable = false)
    private Integer maxTickets;

    @NotNull(message = "Ticket price is required")
    @DecimalMin(value = "0.0", inclusive = true, message = "Ticket price must be at least 0")
    @Digits(integer = 8, fraction = 2, message = "Ticket price must be a valid monetary value")
    @Column(name = "ricket_price", nullable = false)
    private BigDecimal ticketPrice;

    @Column(name = "created_at", updatable = false)
    private LocalDate createdAt;

    public EventSchedule() {
        this.createdAt = LocalDate.now();
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public @NotNull(message = "Event ID is required") Long getEventId() {
        return eventId;
    }

    public void setEventId(@NotNull(message = "Event ID is required") Long eventId) {
        this.eventId = eventId;
    }

    public @NotNull(message = "Learning Center ID is required") Long getLearningCenterId() {
        return learningCenterId;
    }

    public void setLearningCenterId(@NotNull(message = "Learning Center ID is required") Long learningCenterId) {
        this.learningCenterId = learningCenterId;
    }

    public @NotNull(message = "Start date is required") @FutureOrPresent(message = "Start date cannot be in the past") LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(@NotNull(message = "Start date is required") @FutureOrPresent(message = "Start date cannot be in the past") LocalDate startDate) {
        this.startDate = startDate;
    }

    public @NotNull(message = "End date is required") @Future(message = "End date must be in the future") LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(@NotNull(message = "End date is required") @Future(message = "End date must be in the future") LocalDate endDate) {
        this.endDate = endDate;
    }

    public @Min(value = 1, message = "Duration must be at least 1 minute") Integer getDuration() {
        return duration;
    }

    public void setDuration(@Min(value = 1, message = "Duration must be at least 1 minute") Integer duration) {
        this.duration = duration;
    }

    public @Min(value = 1, message = "Max tickets must be at least 1") Integer getMaxTickets() {
        return maxTickets;
    }

    public void setMaxTickets(@Min(value = 1, message = "Max tickets must be at least 1") Integer maxTickets) {
        this.maxTickets = maxTickets;
    }

    public @NotNull(message = "Ticket price is required") @DecimalMin(value = "0.0", inclusive = true, message = "Ticket price must be at least 0") @Digits(integer = 8, fraction = 2, message = "Ticket price must be a valid monetary value") BigDecimal getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(@NotNull(message = "Ticket price is required") @DecimalMin(value = "0.0", inclusive = true, message = "Ticket price must be at least 0") @Digits(integer = 8, fraction = 2, message = "Ticket price must be a valid monetary value") BigDecimal ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "EventSchedule{" +
                "scheduleId=" + scheduleId +
                ", eventId=" + eventId +
                ", learningCenterId=" + learningCenterId +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", duration=" + duration +
                ", maxTickets=" + maxTickets +
                ", ticketPrice=" + ticketPrice +
                ", createdAt=" + createdAt +
                '}';
    }
}

